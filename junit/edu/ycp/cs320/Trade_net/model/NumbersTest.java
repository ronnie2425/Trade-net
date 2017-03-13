package edu.ycp.cs320.rstevenson.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.rstevenson.model.Numbers;

public class NumbersTest {
	private Numbers model;
	
	@Before
	public void setUp() {
		model = new Numbers();
	}
	
	@Test
	public void testSetnum1() {
		model.setnum1(4);
		assertEquals(4,(int) model.getnum1());
	}
	public void testSetnum2() {
		model.setnum2(44);
		assertEquals(44,(int) model.getnum2());
	}
	public void testSetnum3() {
		model.setnum3(444);
		assertEquals(444,(int) model.getnum3());
	}
	
	public void testSetresult() {
		model.setresult(12345);
		assertEquals(12345,(int) model.getresult());
	}
}
