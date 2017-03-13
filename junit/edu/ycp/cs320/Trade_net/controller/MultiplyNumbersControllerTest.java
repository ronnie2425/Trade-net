package edu.ycp.cs320.rstevenson.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.rstevenson.controller.MultiplyNumbersController;
import edu.ycp.cs320.rstevenson.model.Numbers;

public class MultiplyNumbersControllerTest {
	private Numbers model;
	private MultiplyNumbersController controller;
	
	@Before
	public void setUp() {
		model = new Numbers();
		controller = new MultiplyNumbersController();
		
		model.setnum1(5);
		model.setnum2(10);
		
		controller.setModel(model);
	}
	
	@Test
	public void testNumberIsGreater() {
		assertTrue(controller.getresult() == 50);
		
	}
}
