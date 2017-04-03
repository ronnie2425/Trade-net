package edu.ycp.cs320.Trade_net.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.Trade_net.model.Notification;
import edu.ycp.cs320.Trade_net.model.User;

public class PostTest {
	private Posts post;
	User user = new User();

	
	@Before
	public void setUp() {
		post = new Posts("platform", "game", 10.01, "buy", "message", user, 1, 1);
	}
	
	@Test
	public void testGetPlatform() {
		assertEquals("platform", post.getPlatform());
	}
	@Test
	public void testGetGame() {
		assertEquals("game", post.getGame());
	}
	@Test
	public void testGetTime() {
		assertEquals(10.01, post.getTime(), .0001);
	}
	@Test
	public void testGetTradeType() {
		assertEquals("buy", post.getBuy());
	}
	@Test
	public void testGetMessage() {
		assertEquals("message", post.getMessage());
	}
	@Test
	public void testGetUser() {
		assertEquals(user, post.getUser());
	}
	@Test
	public void testGetUserID(){
		assertEquals(1, post.getUserId());
	}
	@Test
	public void testGetPostID(){
		assertEquals(1, post.getPostId());
	}
}
