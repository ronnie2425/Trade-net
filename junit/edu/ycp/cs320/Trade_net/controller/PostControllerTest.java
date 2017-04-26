package edu.ycp.cs320.Trade_net.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.Trade_net.model.*;
import edu.ycp.cs320.Trade_net.controller.*;
import edu.ycp.cs320.Trade_net.database.IDatabase;

public class PostControllerTest {
	private Posts model;
	private User user;
	private PostController controller;
	private IDatabase db;
	private List<Posts> posts = null;
	@Before
	public void setUp() {
		user= new User("testp","pass","email",5);
		model=new Posts("platform3","game3","buy","this is a test",user);
		controller= new PostController(model);
	}
	
	@Test
	public void testGetPosts() {
		assertEquals(false,controller.getPosts().isEmpty());
	}
	@Test
	public void testDeletePost() {
		model.setUser(user);
		assertEquals(user, model.getUser());
	}
}
