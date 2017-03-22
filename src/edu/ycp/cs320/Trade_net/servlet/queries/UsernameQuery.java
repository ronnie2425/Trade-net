package edu.ycp.cs320.Trade_net.servlet.queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

import edu.ycp.cs320.Trade_net.database.DBUtil;

public class UsernameQuery {
	public static String main(String[] args,String username) throws Exception {
		// load Derby JDBC driver
		Object obj=null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			System.err.println("Could not load Derby JDBC driver");
			System.err.println(e.getMessage());
			System.exit(1);
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;

		// connect to the database
		conn = DriverManager.getConnection("jdbc:derby:test.db;create=true");

	

		try {
			conn.setAutoCommit(true);
			
			// prompt user for title to search for
			

			// a canned query to find book information (including author name) from title
			stmt = conn.prepareStatement(
					"select users.username "
					+ "  from users "
					+ "  where users.username= ? "
			);

			// substitute the title entered by the user for the placeholder in the query
			stmt.setString(1, username);

			// execute the query
			resultSet = stmt.executeQuery();

			// get the precise schema of the tuples returned as the result of the query
			ResultSetMetaData resultSchema = stmt.getMetaData();

			// iterate through the returned tuples, printing each one
			// count # of rows returned
			int rowsReturned = 0;
		
			while (resultSet.next()) {
				for (int i = 1; i <= resultSchema.getColumnCount(); i++) {
					 obj = resultSet.getObject(i);
					
			
				}
		
				
				// count # of rows returned
				rowsReturned++;
			}
			
			// indicate if the query returned nothing
			if (rowsReturned == 0) {
				System.out.println("No rows returned that matched the query");
			}
		} finally {
			// close result set, statement, connection
			DBUtil.closeQuietly(resultSet);
			DBUtil.closeQuietly(stmt);
			DBUtil.closeQuietly(conn);
			
		}
		return obj.toString();
	}
}
