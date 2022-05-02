package edu.ycp.cs320.teamProject.storage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.teamProject.model.InfoInput;

public class UserTest {
	public User user1, user2; 
	
	private InfoInput model;
	
	@Before
	public void setUp() throws Exception {
		user1 = new User("username1", "pw4user");
		user2 = new User("broady", "jobcomparison");
	}
	
	//tests for getters
	
	@Test
	public void testgetUsername() {
		assertTrue(user1.getUsername().contentEquals("username1"));
		assertTrue(user2.getUsername().contentEquals("broady"));
	}

	@Test
	public void testgetPassword() {
		assertTrue(user1.getPassword().contentEquals("pw4user"));
		assertTrue(user2.getPassword().contentEquals("jobcomparison"));
	}
	
	//tests for setters 
	
	@Test
	public void testsetgetUser() {
		
		user1.setUsername("broad34@hotmail.com");
		user2.setUsername("username2plz");
		
		assertTrue(user1.getUsername().contentEquals("broad34@hotmail.com"));
		assertTrue(user2.getUsername().contentEquals("username2plz"));
	}
	
	@Test
	public void testsetgetPassword() {
		
		user1.setPassword("password4Jobcomp");
		user2.setPassword("1235%^&*");
		
		assertTrue(user1.getPassword().contentEquals("password4Jobcomp"));
		assertTrue(user2.getPassword().contentEquals("1235%^&*"));
	}
	
}
