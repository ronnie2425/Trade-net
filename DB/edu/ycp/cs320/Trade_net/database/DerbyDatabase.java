package edu.ycp.cs320.Trade_net.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.Trade_net.model.User;
import edu.ycp.cs320.Trade_net.model.Posts;
import edu.ycp.cs320.Trade_net.model.Notification;



public class DerbyDatabase implements IDatabase {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}
	
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;

	
	
	
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
	
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();
		
		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;
			
			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}
			
			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}
			
			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}

	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:test.db;create=true");
		
		// Set autocommit to false to allow execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	private void loadUser(User user, ResultSet resultSet, int index) throws SQLException {
		user.setUserId(resultSet.getInt(index++));
		user.setUsername(resultSet.getString(index++));
		user.setPassword(resultSet.getString(index++));
		user.setEmail(resultSet.getString(index++));
	}
	
	private void loadPost(Posts post, ResultSet resultSet, int index) throws SQLException {
		post.setPostId(resultSet.getInt(index++));
		post.setUserId(resultSet.getInt(index++));
		post.setPlatform(resultSet.getString(index++));
		post.setGame(resultSet.getString(index++));
		post.setBuy(resultSet.getString(index++));		
		post.setTime(resultSet.getDouble(index++));	
		post.setMessage(resultSet.getString(index++));
	}
	private void loadNotification(Notification n, ResultSet resultSet, int index) throws SQLException {
		n.setNotificationId(resultSet.getInt(index++));
		n.setUserId(resultSet.getInt(index++));
		n.setNotification(resultSet.getString(index++));
	}
	
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			//@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				
				try {
					// Users : User_id | Username | Password | Email
					stmt1 = conn.prepareStatement(
						"create table users (" +
						"	user_id integer primary key " +
						"		generated always as identity (start with 1, increment by 1), " +									
						"	username varchar(20), " +
						"	password varchar(20), " +
						"   email varchar(40) "+
						")"
					);	
					//System.out.println("test");
					stmt1.executeUpdate();
					// Posts : post id | user id | platform | game | trade/buy | time | message
					stmt2 = conn.prepareStatement(
							"create table posts (" +
							"	post_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	user_id integer constraint user_id references users, " +
							"	platform varchar(20), " +
							"	game varchar(20), " +
							"   trade varchar(5), " +
							"   time double, " +
							"   message varchar(200) "+
							")"
					);
					//System.out.println("test");
					stmt2.executeUpdate();
					// Notification : notifiction id | user id | message
					stmt3 = conn.prepareStatement(
							"create table notification (" +
							"	notification_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	post_id integer constraint post_id references users, " +
							"	message varchar(200)" +
							")"
					);
					//System.out.println("test");
					stmt3.executeUpdate();
					
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
				}
			}
		});
	}
	
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			//@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<User> userList;
				List<Posts> postList;
				List<Notification> notList;
				
				try {
					userList = InitialData.getUsers();
					postList = InitialData.getPosts();
					notList = InitialData.getNotifications();
					
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertUser = null;
				PreparedStatement insertPost   = null;
				PreparedStatement insertNotification   = null;

				try {
					// populate authors table (do authors first, since author_id is foreign key in books table)
					insertUser = conn.prepareStatement("insert into users (username, password, email) values (?, ?, ?)");
					for (User user : userList) {
//						insertAuthor.setInt(1, author.getAuthorId());	// auto-generated primary key, don't insert this
						insertUser.setString(1, user.getUsername());
						insertUser.setString(2, user.getPassword());
						insertUser.setString(3, user.getEmail());
						insertUser.addBatch();
					}
					insertUser.executeBatch();
					
					insertNotification = conn.prepareStatement("insert into notification (post_id, message) values (?, ?)");
					for (Notification not : notList) {
//						insertAuthor.setInt(1, author.getAuthorId());	// auto-generated primary key, don't insert this
						insertNotification.setInt(1, not.getUserId());
						insertNotification.setString(2, not.getNotification());
						insertNotification.addBatch();
					}
					insertNotification.executeBatch();
					
					// populate books table (do this after authors table,
					// since author_id must exist in authors table before inserting book)
					insertPost = conn.prepareStatement("insert into posts (user_id, platform, game, trade, time, message) values (?, ?, ?, ?, ?, ?)");
					for (Posts post : postList) {
//						insertBook.setInt(1, book.getBookId());		// auto-generated primary key, don't insert this
						insertPost.setInt(1, post.getUserId());
						insertPost.setString(2, post.getPlatform());
						insertPost.setString(3, post.getGame());
						insertPost.setString(4,  post.getBuy());
						insertPost.setDouble(5, post.getTime());
						insertPost.setString(6, post.getMessage());
						insertPost.addBatch();
					}
					insertPost.executeBatch();
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertPost);
					DBUtil.closeQuietly(insertUser);
					DBUtil.closeQuietly(insertNotification);
				}
			}
		});
	}
	
	public List<Notification> insertNotification(final int userid,final String message)
	{
		return executeTransaction(new Transaction<List<Notification>>()
		{
			public List<Notification> execute(Connection conn) throws SQLException
			{
				PreparedStatement stmt = null;
				ResultSet res = null;
				
				try
				{
					stmt = conn.prepareStatement(
							"insert into Notification(userid,message)"
							+ "values(?,?)");
					stmt.setInt(1, userid);
					stmt.setString(2, message);
					
					stmt.executeUpdate();
					return null;
				}
				finally
				{
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(res);
				}
			}
		});
	}
	
	public List<User> insertUser(final String username,final String password,final String email)
	{
		return executeTransaction(new Transaction<List<User>>()
		{
			public List<User> execute(Connection conn) throws SQLException
			{
				PreparedStatement stmt = null;
				ResultSet res = null;
				
				try
				{
					stmt = conn.prepareStatement(
							"insert into Users(username,password,email)"
							+ "values(?,?,?)");
					stmt.setString(1, username);
					stmt.setString(2, password);
					stmt.setString(3, email);
					
					stmt.executeUpdate();
					return null;
				}
				finally
				{
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(res);
				}
			}
		});
	}
	
	public List<Posts> insertPost(final int userid,final String platform,final String game,final String trade ,final int time, final String message)
	{
		return executeTransaction(new Transaction<List<Posts>>()
		{
			public List<Posts> execute(Connection conn) throws SQLException
			{
				PreparedStatement stmt = null;
				ResultSet res = null;
				
				try
				{
					// Posts : post id | user id | platform | game | trade/buy | time | message
					stmt = conn.prepareStatement(
							"insert into Posts(userid,platform,game,trade/buy,time,message)"
							+ "values(?,?,?,?,?,?)");
					stmt.setInt(1, userid);
					stmt.setString(2, platform);
					stmt.setString(3, game);
					stmt.setString(4, trade);
					stmt.setInt(5, time);
					stmt.setString(6, message);
					
					stmt.executeUpdate();
					return null;
				}
				finally
				{
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(res);
				}
			}
		});
	}
	
	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		DerbyDatabase db = new DerbyDatabase();
		db.createTables();
		
		System.out.println("Loading initial data...");
		db.loadInitialData();
		
		System.out.println("Success!");
	}

	/*public List<String> verifyUserCredentials(final String username, final String password) {
		return executeTransaction(new Transaction<List<String>>(){

			public List<String> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet set1 = null;
				List<String> result;
				
				try{
					stmt = conn.prepareStatement("select * from users where users.username "
							+ "= ? and user.password = ?");
					stmt.setString(1, username);
					stmt.setString(2, password);
					
					result = new ArrayList<String>();
					set1 = stmt.executeQuery();
					
					while(set1.next()){
						String user = set1.getString(1);
						String pass = set1.getString(2);
						
						result.add(user);
						result.add(pass);
						
					}
				}
				finally{
					DBUtil.closeQuietly(set1);
					DBUtil.closeQuietly(stmt);
				}
				return result;
			}
		});
	}
	*/

}
