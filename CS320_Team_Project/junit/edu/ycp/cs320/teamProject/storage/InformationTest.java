package edu.ycp.cs320.teamProject.storage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;



public class InformationTest {
	public Information general, test1, test2, test3, test4;
	
    @Before
    public void setUp() throws Exception {
        //create a new instance of information
         test1 = new Information(5, 1, 5, 6, 3, 1);
    	 test2 = new Information(6, 6, 6, 6, 6, 6);
    	 test3 = new Information(0, 0, 0, 0, 0, 0);
    	 test4 = new Information(0, 0, 0, 0, 1, 0);
    	 general = new Information();
    	 general.setSalary(1010.10);
    }

    @Test
    public void testGetRating() throws Exception {
    	assertTrue(test1.getRating() == 3.5);
        assertTrue(test2.getRating() == 6.0);
        assertTrue(test3.getRating() == 0.0);
        assertTrue(test4.getRating() == 0.2);
    }

    //test getter methods
    @Test
    public void testGetSalary() throws Exception {
    	assertTrue(general.getSalary() == 1010.10);
    }

    //test setter methods
    @Test
    public void testSetSalary() throws Exception {
        general.setSalary(2020.20);
        assertTrue(general.getSalary() == 2020.20);
    }
}