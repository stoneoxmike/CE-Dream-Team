package edu.ycp.cs320.teamProject.storage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.teamProject.model.InfoInput;

public class FullTimeTest {
	public Full_Time test1, test2, test3, test4;
	
	@Before
	public void setUp() throws Exception{
		test1 = new Full_Time(true, false, true, 5000, 2500, 3);
		test2 = new Full_Time(true, false, false, 1000, 250, 1);
		test3 = new Full_Time(true, true, true, 10000, 5500, 5);
		test4 = new Full_Time(false, false, true, 500, 100, 1);
	}
	
	//Tests for getters 
	@Test
	public void testgetInsurance() throws Exception{
		assertTrue(test1.getInsurance() == true);
		assertTrue(test2.getInsurance() == true);
		assertTrue(test3.getInsurance() == true);
		assertTrue(test4.getInsurance() == false);
				
	}
	
	@Test
	public void testgetPension() throws Exception{
		assertTrue(test1.getPension() == false);
		assertTrue(test2.getPension() == false);
		assertTrue(test3.getPension() == true);
		assertTrue(test4.getPension() == false);
				
	}
	
	@Test
	public void testgetPto() throws Exception{
		assertTrue(test1.getPto() == true);
		assertTrue(test2.getPto() == false);
		assertTrue(test3.getPto() == true);
		assertTrue(test4.getPto() == true);
				
	}
	
	@Test
	public void testgetSigningBonus() throws Exception{
		assertTrue(test1.getSigningBonus() == 5000);
		assertTrue(test2.getSigningBonus() == 1000);
		assertTrue(test3.getSigningBonus() == 10000);
		assertTrue(test4.getSigningBonus() == 500);
				
	}
	
	@Test
	public void testgetAnnualBonus() throws Exception{
		assertTrue(test1.getAnnualBonus() == 2500);
		assertTrue(test2.getAnnualBonus() == 250);
		assertTrue(test3.getAnnualBonus() == 5500);
		assertTrue(test4.getAnnualBonus() == 100);
				
	}
	
	@Test
	public void testgetJobLevel() throws Exception{
		assertTrue(test1.getJobLevel() == 3);
		assertTrue(test2.getJobLevel() == 1);
		assertTrue(test3.getJobLevel() == 5);
		assertTrue(test4.getJobLevel() == 1);
				
	}
	
	//Tests for setters
	
	@Test
	public void testgetInsuranceSet() throws Exception{
		test1.setInsurance(false);
		test2.setInsurance(true);
		test3.setInsurance(false);
		test4.setInsurance(false);
		assertTrue(test1.getInsurance() == false);
		assertTrue(test2.getInsurance() == true);
		assertTrue(test3.getInsurance() == false);
		assertTrue(test4.getInsurance() == false);
				
	}
	
	//NF
	@Test
	public void testgetPensionSet() throws Exception{
		assertTrue(test1.getPension() == false);
		assertTrue(test2.getPension() == false);
		assertTrue(test3.getPension() == true);
		assertTrue(test4.getPension() == false);
				
	}
	
	//NF
	@Test
	public void testgetPtoSet() throws Exception{
		assertTrue(test1.getPto() == true);
		assertTrue(test2.getPto() == false);
		assertTrue(test3.getPto() == true);
		assertTrue(test4.getPto() == true);
				
	}
	
	//NF
	@Test
	public void testgetSigningBonusSet() throws Exception{
		assertTrue(test1.getSigningBonus() == 5000);
		assertTrue(test2.getSigningBonus() == 1000);
		assertTrue(test3.getSigningBonus() == 10000);
		assertTrue(test4.getSigningBonus() == 500);
				
	}
	
	//NF	
	@Test
	public void testgetAnnualBonusSet() throws Exception{
		assertTrue(test1.getAnnualBonus() == 2500);
		assertTrue(test2.getAnnualBonus() == 250);
		assertTrue(test3.getAnnualBonus() == 5500);
		assertTrue(test4.getAnnualBonus() == 100);
				
	}
	
	@Test
	public void testgetJobLevelSet() throws Exception{
		test1.setJobLevel(5);
		test2.setJobLevel(3);
		test3.setJobLevel(2);
		test4.setJobLevel(10);
		assertTrue(test1.getJobLevel() == 5);
		assertTrue(test2.getJobLevel() == 3);
		assertTrue(test3.getJobLevel() == 2);
		assertTrue(test4.getJobLevel() == 10);
				
	}
	
}