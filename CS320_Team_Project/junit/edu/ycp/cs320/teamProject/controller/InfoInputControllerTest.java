package edu.ycp.cs320.teamProject.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.teamProject.controller.InfoInputController;
import edu.ycp.cs320.teamProject.model.InfoInput;

public class InfoInputControllerTest {
	private InfoInput model;
	private InfoInputController controller;
	
	@Before
	public void setUp() {
		model = new InfoInput();
		controller = new InfoInputController();
		
		
		controller.setModel(model);
	}
	
	@Test
	public void testNumberIsGreater() {
	}
}