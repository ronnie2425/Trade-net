package edu.ycp.cs320.rstevenson.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.rstevenson.controller.AddNumbersController;
import edu.ycp.cs320.rstevenson.model.Numbers;

public class AddNumbersControllerTest {
	private Numbers model;
	private AddNumbersController controller;
	
	@Before
	public void setUp() {
		model = new Numbers();
		controller = new AddNumbersController();
		
		model.setnum1(1);
		model.setnum2(10);
		model.setnum3(100);
		
		controller.setModel(model);
	}
	
	@Test
	public void testgetResult() {
		assertTrue(controller.getresult() == 111);
	
	}
}
