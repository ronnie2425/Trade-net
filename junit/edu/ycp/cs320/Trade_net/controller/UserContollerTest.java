package edu.ycp.cs320.Trade_net.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.Trade_net.database.DatabaseProvider;
import edu.ycp.cs320.Trade_net.database.DerbyDatabase;
import edu.ycp.cs320.Trade_net.database.IDatabase;
import edu.ycp.cs320.Trade_net.model.Notification;
import edu.ycp.cs320.Trade_net.model.Posts;
import edu.ycp.cs320.Trade_net.model.User;

public class UserContollerTest {
	private Notification model;
	private User user;
	private UserController controller;
	private IDatabase db;

	private List<Posts> posts = null;
	
	@Before
	public void setUp() {
		user = new User("Rick", "pass", "theboy@email.com", 1);
		model = new Notification("hey", user);
		controller=new UserController(user);
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
	
	@Test
	public void testPost() {
		db = DatabaseProvider.getInstance();
		controller.post(user, "platform8", "game8", "buy", "message");
		
		posts=db.findPosts("platform8", "game8", "buy");
		assertEquals(false, posts.isEmpty());
		
	}
	@Test
	public void testLogin() {
		assertEquals(false, controller.login("Rick", "pdasda"));
		assertEquals(true, controller.login("User1", "Password1"));
		
	}
	
	
}
