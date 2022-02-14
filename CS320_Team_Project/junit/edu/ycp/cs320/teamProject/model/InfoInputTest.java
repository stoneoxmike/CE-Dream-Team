package edu.ycp.cs320.teamProject.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.teamProject.model.InfoInput;

public class InfoInputTest {
	private InfoInput model;
	
	@Before
	public void setUp() {
		model = new InfoInput();
	}
	
	@Test
	public void testSetMin() {
		model.setMin(1);
		assertEquals(1, model.getMin());
	}
	
	public void testSetMax() {
		model.setMax(100);
		assertEquals(100, model.getMax());
	}
}
