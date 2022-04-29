package edu.ycp.cs320.teamProject.storage;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class InternshipTest {
public Internship intern1, intern2, intern3;
		
		@Before
		public void setUp() throws Exception{
			
			intern1 = new Internship(12 ,5, true);
			intern2 = new Internship(8, 3, false);
			intern3 = new Internship(10, 6, true);
			
		}
		
		//Tests for getters
		@Test
		public void testgetLength() {
			
			assertTrue(intern1.getLength()==12);
			assertTrue(intern2.getLength()==8);
			assertTrue(intern3.getLength()==10);
			
 		}
		
		@Test
		public void testgetresumeStrength() {
			
			assertTrue(intern1.getResumeStrength() == 5);
			assertTrue(intern2.getResumeStrength() == 3);
			assertTrue(intern3.getResumeStrength() == 6);
		
		}
		
		@Test
		public void getfullTimeOpportunity() {
			
			assertTrue(intern1.getfullTimeOpportunity() == true);
			assertTrue(intern2.getfullTimeOpportunity() == false);
			assertTrue(intern3.getfullTimeOpportunity() == true);
		

		}
		
		//Testing setters 
		
		@Test
		public void testsetgetLength() {
			
			//setting 
			intern1.setLength(14);
			intern2.setLength(4);
			intern3.setLength(15);
			assertTrue(intern1.getLength()==14);
			assertTrue(intern2.getLength()==4);
			assertTrue(intern3.getLength()==15);
			
 		}
		
		@Test
		public void testsetgetresumeStrength() {
			
			//setting
			intern1.setResumeStrength(3);
			intern2.setResumeStrength(2);
			intern3.setResumeStrength(4);
			assertTrue(intern1.getResumeStrength() == 3);
			assertTrue(intern2.getResumeStrength() == 2);
			assertTrue(intern3.getResumeStrength() == 4);
		
		}
		
		@Test
		public void testsetgetfullTimeOpportunity() {
			
			//setting 
			intern1.setFullTimeOpportunity(false);
			intern2.setFullTimeOpportunity(true);
			intern3.setFullTimeOpportunity(true);
			assertTrue(intern1.getfullTimeOpportunity() == false);
			assertTrue(intern2.getfullTimeOpportunity() == true);
			assertTrue(intern3.getfullTimeOpportunity() == true);

		}
			
}
