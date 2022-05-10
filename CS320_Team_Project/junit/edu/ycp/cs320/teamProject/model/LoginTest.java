package edu.ycp.cs320.teamProject.model;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LoginTest {
public Login login1, login2, login3;

	@Before
	public void setUp() throws Exception {
		
		login1 = new Login(); 
		login1.setUsername("cheeseman");
		login1.setPassword("password12345");
		login2 = new Login();
		login2.setUsername("datboi");
		login2.setPassword("broady");
		login3 = new Login();
		login3.setUsername("dannydevito");
		login3.setPassword("security");
		
	}
	
	//testing getters
	
	@Test
	public void testgetUsername() {
		
		assertTrue(login1.getUsername().contentEquals("cheeseman"));
		assertTrue(login2.getUsername().contentEquals("datboi"));
		assertTrue(login3.getUsername().contentEquals("dannydevito"));
		
	}
	
	@Test
	public void testgetPassword() {
		
		assertTrue(login1.getPassword().contentEquals("password12345"));
		assertTrue(login2.getPassword().contentEquals("broady"));
		assertTrue(login3.getPassword().contentEquals("security"));
		
	}
	
	
}
