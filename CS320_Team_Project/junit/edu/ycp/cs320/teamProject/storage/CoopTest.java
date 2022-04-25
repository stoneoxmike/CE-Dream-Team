package edu.ycp.cs320.teamProject.storage;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CoopTest {
public Co_op test1, test2, test3, test4;
	
	@Before
	public void setUp() throws Exception{
		test1 = new Co_op(4, 12, 3);
		test2 = new Co_op(4, 5, 4);
		test3 = new Co_op(5, 6, 2);
		test4 = new Co_op(6, 15, 3);
	}
	
	//Tests for getters 
	@Test
	public void testgetresumeStrength() throws Exception{
		assertTrue(test1.getresumeStrength() == 4);
		assertTrue(test2.getresumeStrength() == 4);
		assertTrue(test3.getresumeStrength() == 5);
		assertTrue(test4.getresumeStrength() == 6);
	}
	@Test
	public void testgetLength() throws Exception{
		assertTrue(test1.getLength() == 12);
		assertTrue(test2.getLength() == 5);
		assertTrue(test3.getLength() == 6);
		assertTrue(test4.getLength() == 15);
	}
	@Test
	public void testgetCredits() throws Exception{
		assertTrue(test1.getCredits() == 3);
		assertTrue(test1.getCredits() == 4);
		assertTrue(test1.getCredits() == 3);
		assertTrue(test1.getCredits() == 3);
	}
	
	//Setting for new tests

	public void testgetresumeStrengthset() throws Exception{
		test1.setresumeStrength(3);
		test2.setresumeStrength(5);
		test3.setresumeStrength(1);
		test4.setresumeStrength(2);
		assertTrue(test1.getresumeStrength() == 3);
		assertTrue(test2.getresumeStrength() == 5);
		assertTrue(test3.getresumeStrength() == 1);
		assertTrue(test4.getresumeStrength() == 2);
	}
	@Test
	public void testgetLengthset() throws Exception{
		test1.setLength(5);
		test2.setLength(10);
		test3.setLength(7);
		test4.setLength(3);
		assertTrue(test1.getLength() == 5);
		assertTrue(test2.getLength() == 10);
		assertTrue(test3.getLength() == 7);
		assertTrue(test4.getLength() == 3);
	}
	@Test
	public void testgetCreditsset() throws Exception{
		test1.setCredits(4);
		test2.setCredits(0);
		test3.setCredits(2);
		test4.setCredits(3);
		assertTrue(test1.getCredits() == 4);
		assertTrue(test2.getCredits() == 0);
		assertTrue(test3.getCredits() == 2);
		assertTrue(test4.getCredits() == 3);
	}
		
		
	
}