package edu.ycp.cs320.Trade_net.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.Trade_net.model.Notification;
import edu.ycp.cs320.Trade_net.model.User;

public class NotificationTest {
	private Notification model;
	private User user;
	
	@Before
	public void setUp() {
		user = new User("Rick", "pass", "theboy@email.com", 1);
		model = new Notification("hey", user);
	}
	
	@Test
	public void testSetandGetNotification() {
		model.setNotification("hey");
		assertEquals("hey", model.getNotification());
	}
	@Test
	public void testSetandGetUser() {
		model.setUser(user);
		assertEquals(user, model.getUser());
	}
}
