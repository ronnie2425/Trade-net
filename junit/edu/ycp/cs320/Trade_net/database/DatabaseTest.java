package edu.ycp.cs320.Trade_net.database;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.apache.derby.database.Database;
import org.junit.Test;

import edu.ycp.cs320.Trade_net.database.*;
import edu.ycp.cs320.Trade_net.model.*;

public class DatabaseTest {
	private IDatabase db = null;
	
	List<User> users = null;
	List<Notification> notifications = null;
	List<Posts> posts = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		
	}
	
	@Before
	public void setUp() throws Exception
	{
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
	
	@After
	public void tearDown() throws Exception
	{
		
	}
	
	@Test
	public void TestFindUser()
	{
		System.out.println("\n*** Testing FindUser ***");
		
		String username = "User1";
		users = db.findUser(username);
		if (users.isEmpty())
		{
			System.out.println("Ah fuck, you goofed");
			fail("No user found with username <" + username + ">");
		}
		else
		{
			System.out.println("User <" + username + "> found!");
		}
	}
	
	@Test
	public void TestFindPosts()
	{
		System.out.println("\n*** Testing FindPosts ***");
		
		String pf = "platform1";
		String game = "game1";
		String trade = "trade";
		posts = db.findPosts(pf, game, trade);
		if (posts.isEmpty())
		{
			System.out.println("Ah fuck, you goofed");
			fail("No post found with specified information");
		}
		else
		{
			System.out.println("Posts found!");
		}
	}
	
	@Test
	public void TestFindNot()
	{
		System.out.println("\n*** Testing FindNotification ***");
		
		int postId = 1;
		
		notifications = db.findNot(postId);
		if (notifications.isEmpty())
		{
			System.out.println("Ah fuck, you goofed");
			fail("No notification found with specified information");
		}
		else
		{
			System.out.println("Notification found: " + notifications.get(0).getNotification());
		}
	}
	
	@Test
	public void TestInsertPost()
	{
		System.out.println("\n*** Testing InsertPost ***");
		
		int userid = 2;
		String pf = "xbox365";
		String game = "Warframe";
		String trade = "buy";
		int time = 0;
		String msg = "pls work";
		
		posts = db.findPosts(pf, game, trade);
		if (!posts.isEmpty())
		{
			System.out.println("Failed to insert Post");
			fail("Post already exists");
		}
		else
		{
			db.insertPost(userid, pf, game, trade, time, msg);
			System.out.println("Post successfully inserted");
		}
	}
	
	@Test
	public void TestInsertUser()
	{
		System.out.println("\n*** Testing InsertUser ***");
		
		String user = "ricardo";
		String pass = "kelly";
		String email = "iam@tired.rn";
		
		users = db.findUser(user);
		if (!users.isEmpty())
		{
			System.out.println("Failed to insert User");
			fail("User already exists");
		}
		else
		{
			db.insertUser(user, pass, email);
			System.out.println("User successfully inserted");
		}
	}
	

	@Test
	public void TestInsertNotification()
	{
		System.out.println("\n*** Testing InsertNotification ***");
		
		int userid = 2;
		String msg = "work!!";
		
		notifications = db.findNot(20);
		if (!notifications.isEmpty())
		{
			System.out.println("Failed to insert Notification");
			fail("Notification already exists");
		}
		else
		{
			db.insertNotification(userid, msg);
			System.out.println("Notification successfully inserted");
		}
	}

}
