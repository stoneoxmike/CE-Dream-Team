package edu.ycp.cs320.teamProject.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.teamProject.model.InfoInput;

public class InfoInputTest {
public InfoInput ii1, ii2, ii3;
	
	@Before
	public void setUp() {
		ii1 = new InfoInput();
		ii2 = new InfoInput();
		ii3 = new InfoInput();
		
		//setting for ii1
		ii1.setAge(35);
		ii1.setCommuteTime(3.0);
		ii1.setCulture(3);
		ii1.setInsurance(true);
		ii1.setLocation("Baltimore");
		ii1.setOpportunity(5);
		ii1.setRemote(false);
		ii1.setSalary(333.0);
		ii1.setSize(5);
		ii1.setWorkLifeBalance(4);
		ii1.setsizeWeight(4);
		ii1.setageWeight(4);
		ii1.setcultureWeight(3);
		ii1.setopportunityWeight(1);
		ii1.setworkLifeBalanceWeight(6);
		ii1.setsalaryWeight(2);
		
		
		//setting for ii2
		ii2.setAge(30000);
		ii2.setCommuteTime(10.675);
		ii2.setCulture(1);
		ii2.setInsurance(false);
		ii2.setLocation("New York City");
		ii2.setOpportunity(4);
		ii2.setRemote(false);
		ii2.setSalary(9999.00);
		ii2.setSize(3);
		ii2.setWorkLifeBalance(1);
		
		//setting for ii3
		ii3.setAge(110);
		ii3.setCommuteTime(13.45);
		ii3.setCulture(6);
		ii3.setInsurance(true);
		ii3.setLocation("Belgium");
		ii3.setOpportunity(2);
		ii3.setRemote(true);
		ii3.setSalary(15000.00);
		ii3.setSize(3);
		ii3.setWorkLifeBalance(2);
		
	}
	
	//testing getters (setter tests redundant)
	@Test

	public void testgetSalary() {
		
		assertTrue(ii1.getSalary() == 333.0);
		assertTrue(ii2.getSalary() == 9999.0);
		assertTrue(ii3.getSalary() == 15000.00);
	}
	
	@Test
	public void testgetLocation() {
		
		assertTrue(ii1.getLocation().contentEquals("Baltimore"));
		assertTrue(ii2.getLocation().contentEquals("New York City"));
		assertTrue(ii3.getLocation().contentEquals("Belgium"));
	}
	
	@Test
	public void testgetCommuteTime() {
	
		assertTrue(ii1.getCommuteTime() == 3.0);
		assertTrue(ii2.getCommuteTime() == 10.675);
		assertTrue(ii3.getCommuteTime() == 13.45);
		
	}
	
	@Test
	public void testgetRemote() {
		
		assertTrue(ii1.getRemote() == false);
		assertTrue(ii2.getRemote() == false);
		assertTrue(ii3.getRemote() == true);
		
	}
	
	@Test
	public void testgetInsurance() {
	
		assertTrue(ii1.getInsurance() == true);
		assertTrue(ii2.getInsurance() == false);
		assertTrue(ii3.getInsurance() == true);
		
	}
	
	@Test
	public void testgetSize() {
		
		assertTrue(ii1.getSize() == 5);
		assertTrue(ii2.getSize() == 3);
		assertTrue(ii3.getSize() == 3);
		
	}
	
	@Test
	public void testgetAge() {
		
		assertTrue(ii1.getAge() == 35);
		assertTrue(ii2.getAge() == 30000);
		assertTrue(ii3.getAge() == 110);
		
	}
	
	@Test
	public void testgetCulture() {
		
		assertTrue(ii1.getCulture() == 3);
		assertTrue(ii2.getCulture() == 1);
		assertTrue(ii3.getCulture() == 6);
		
	}
	
	@Test
	public void testgetOpportunity() {
		
		assertTrue(ii1.getOpportunity() == 5);
		assertTrue(ii2.getOpportunity() == 4);
		assertTrue(ii3.getOpportunity() == 2);
		
	}
	
	@Test
	public void testgetWorkLifeBalance() {
		
		assertTrue(ii1.getWorkLifeBalance() == 4);
		assertTrue(ii2.getWorkLifeBalance() == 1);
		assertTrue(ii3.getWorkLifeBalance() == 2);
		
	}
	
	@Test
	public void getsizeWeight() {
		
		assertTrue(ii1.getsizeWeight() == 4);
		
	}
	
	@Test
	public void getageWeight() {
		
		assertTrue(ii1.getageWeight() == 4);
		
	}
	
	
	@Test
	public void getcultureWeight() {
		
		assertTrue(ii1.getcultureWeight() == 3);
		
	}
	
	
	@Test
	public void getopportunityWeight() {
		
		assertTrue(ii1.getopportunityWeight() == 1);
		
	}
	
	
	@Test
	public void getworkLifeBalanceWeight() {
		
		assertTrue(ii1.getworkLifeBalanceWeight() == 6);
		
	}
	
	
	@Test
	public void getsalaryWeight() {
		
		assertTrue(ii1.getsalaryWeight() == 2);
		
	}
	
	
}
	

