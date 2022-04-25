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
    	 general.setHousingStipend(1600);
    	 general.setLocation("detroit");
    	 general.setCommuteTime(20.0);
    	 general.setRemote(true);
    	 general.setSalaryWeight(1);
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
    
    @Test
    public void testHousingStipendy() throws Exception {
    	assertTrue(general.getHousingStipend() == 1600);
    }
    
    @Test
    public void testgetLocation() throws Exception {
    	assertTrue(general.getLocation().contentEquals("detroit"));
    }
    
    @Test
    public void testCommuteTime() throws Exception {
    	assertTrue(general.getCommuteTime() == 20.00);
    }
    
    @Test
    public void testGetRemote() throws Exception {
    	assertTrue(general.getRemote().equals(true));
    }
    
    @Test
    public void testgetsizeWeight() throws Exception {
    	assertTrue(test1.getSizeWeight() == 5);
    }
    
    @Test
    public void testageWeight() throws Exception {
    	assertTrue(test1.getAgeWeight() == 1);
    }
    
    @Test
    public void testcultureWeight() throws Exception {
    	assertTrue(test1.getCultureWeight() == 5);
    }
    @Test
    public void testGetOpportunityWeight() throws Exception {
    	assertTrue(test1.getOpportunityWeight() == 6);
    }
    
    @Test
    public void testGetWorkLifeBalanceWeight() throws Exception {
    	assertTrue(test1.getWorkLifeBalanceWeight() == 3);
    }
    
    @Test
    public void testgetsalaryWeight() throws Exception {
    	assertTrue(general.getSalaryWeight() == 1);
    }

    //test setter methods
    
    @Test
    public void testSetSalary() throws Exception {
        general.setSalary(2020.20);
        assertTrue(general.getSalary() == 2020.20);
    }
    
    @Test
    public void testsetHousingStipendy() throws Exception {
    	 general.setHousingStipend(1200);
    	assertTrue(general.getHousingStipend() == 1200);
    }
    
    @Test
    public void testsetLocation() throws Exception {
    	 general.setLocation("alaska");
    	assertTrue(general.getLocation().contentEquals("alaska"));
    }
    
    @Test
    public void testsetCommuteTime() throws Exception {
    	 general.setCommuteTime(35.00);
    	assertTrue(general.getCommuteTime() == 35.00);
    }
    
    @Test
    public void testsetRemote() throws Exception {
    	 general.setRemote(false);
    	assertTrue(general.getRemote().equals(false));
    }
    
    @Test
    public void testsetsizeWeight() throws Exception {
    	test1.setSizeWeight(6);
    	assertTrue(test1.getSizeWeight() == 6);
    }
    
    @Test
    public void testsetageWeight() throws Exception {
    	test1.setAgeWeight(6);
    	assertTrue(test1.getAgeWeight() == 6);
    }
    
    @Test
    public void testsetcultureWeight() throws Exception {
    	test1.setCultureWeight(1);
    	assertTrue(test1.getCultureWeight() == 1);
    }
    @Test
    public void testsetopportunityWeight() throws Exception {
    	test1.setOpportunityWeight(4);
    	assertTrue(test1.getOpportunityWeight() == 4);
    }
    
    @Test
    public void testsetgetworkLifeBalanceWeight() throws Exception {
    	test1.setWorkLifeBalance(3);
    	assertTrue(test1.getWorkLifeBalance() == 3);
    }
    
    @Test
    public void testsetgetsalaryWeight() throws Exception {
    	assertTrue(general.getSalaryWeight() == 1);
    }
}