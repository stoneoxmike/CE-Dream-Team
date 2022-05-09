package database;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.teamProject.derbyDatabase.DatabaseProvider;
import edu.ycp.cs320.teamProject.derbyDatabase.Derby;
import edu.ycp.cs320.teamProject.derbyDatabase.IDatabase;
import edu.ycp.cs320.teamProject.derbyDatabase.PersistenceException;
import edu.ycp.cs320.teamProject.derbyDatabase.Queries;

public class QueriesTest {

	private DatabaseProvider dbp;
	private IDatabase idb;
	private Queries query;
	private Connection conn;
	
	@Before
	public void setup() {
		try {
			Derby db = new Derby();
			System.out.println(conn);
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			db.createTables(conn, false);
		}catch (ClassNotFoundException e)
		{
			System.out.println("Embedded Driver Error");
			System.out.println(e.getMessage());
		} catch(PersistenceException e)
		{
			System.out.println("Persistence Error");
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testInsertUser()
	{
		query = new Queries();
		String username = "username";
		String password = "password";
		int result = query.insertUser(username, password);
		assertTrue(result == 1);
	}
	
	@Test
	public void testInsertJob()
	{
		query = new Queries();
		String title = "job";
		Double salary = 21.0;
		String location = "location";
		int housingStipend = 5000;
		Double commuteTime = 1.25;
		boolean remote = false;
		int size = 1;
		int age = 2;
		int culture = 3;
		int opportunity = 4;
		int workLifeBalance = 5;
		boolean insurance = true;
		boolean pension = false;
		boolean pto = false;
		int signingBonus = 500;
		int annualBonus = 0;
		int jobLevel = 0;
		int length = 0;
		int resumeStrength = 0;
		int credits = 0;
		boolean fullTimeOpportunity = false;
		int sizeWeight = 1;
		int ageWeight = 2;
		int cultureWeight = 3;
		int opportunityWeight = 4;
		int workLifeBalanceWeight = 5;
		int salaryWeight = 6;
		String username = "username";
		String password = "password";
		int result = query.insertJobIntoJobsTable(title, salary, location, housingStipend, commuteTime, remote, size, age, culture, opportunity, workLifeBalance, insurance, pension, pto, signingBonus, annualBonus, jobLevel, length, resumeStrength, credits, fullTimeOpportunity, sizeWeight, ageWeight, cultureWeight, opportunityWeight, workLifeBalanceWeight, salaryWeight, username, password);
		assertTrue(result == 1);
	}
	
	@Test
	public void testFindJobs() {
		query = new Queries();
		String username = "username";
		
		//assertEquals( ,);
	}
	
//	@Test
//	public void testSetInstance()
//	{
//		dbp = new DatabaseProvider();
//		DatabaseProvider.setInstance(idb);
//		System.out.println(idb);
//		assertEquals(idb, DatabaseProvider.getInstance());
//	}
//	
//	@Test
//	public void testGetInstance()
//	{
//		assertEquals(idb, DatabaseProvider.getInstance());
//		
//	}
	
	
}
