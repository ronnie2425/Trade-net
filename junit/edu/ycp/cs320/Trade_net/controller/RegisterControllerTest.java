package edu.ycp.cs320.Trade_net.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.Trade_net.database.DatabaseProvider;
import edu.ycp.cs320.Trade_net.database.DerbyDatabase;
import edu.ycp.cs320.Trade_net.model.Register;
import edu.ycp.cs320.Trade_net.model.User;
import edu.ycp.cs320.Trade_net.database.*;

public class RegisterControllerTest {
	private Register model;
	private User user;
	private Register modelWrong;
	private RegisterController controller;
	private RegisterController controller2;
	private IDatabase db;
	private List<User> users = null;
	
	@Before
	public void setUp() {
		user = new User("Rick", "pass", "theboy@email.com", 1);
		model = new Register("regcon", "pass","pass","the@email.com");
		modelWrong = new Register("regcon", "pass","no","the@email.com");
		controller=new RegisterController(model);
		controller2=new RegisterController(modelWrong);
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
	
	@Test
	public void testVerify() {
		//assertEquals(true, controller.verify());
		assertEquals(false, controller2.verify());
	}
	@Test
	public void testCreate() {
		controller.create();
		users=db.findUser(user.getUsername());
		assertEquals(false, users.isEmpty());
		
	}
}
