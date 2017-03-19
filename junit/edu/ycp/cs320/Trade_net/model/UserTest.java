package edu.ycp.cs320.Trade_net.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.Trade_net.model.User;

public class UserTest {
	private User user;
	
	@Before
	public void setUp() {
		user = new User("rick", "word", "memes@4chan.reddit");
	}
	
	@Test
	public void testSetandGetUsername() {
		user.setUsername("Richard Kellington");
		assertEquals("Richard Kellington",user.getUsername());
	}
	public void testSetandGetPassword() {
		user.setPassword("secret");
		assertEquals("secret",user.getPassword());
	}
	public void testSetandGetEmail() {
		user.setEmail("Outofjokes@tired.late");
		assertEquals("Outofjokes@tired.late",user.getEmail());
	}
}
