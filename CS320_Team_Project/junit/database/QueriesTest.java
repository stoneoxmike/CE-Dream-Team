package database;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.ycp.cs320.teamProject.derbyDatabase.DatabaseProvider;
import edu.ycp.cs320.teamProject.derbyDatabase.IDatabase;
import edu.ycp.cs320.teamProject.derbyDatabase.Queries;

public class QueriesTest {

	private DatabaseProvider dbp;
	private IDatabase idb;
	private Queries query;
	
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
	public void testSetInstance()
	{
		dbp = new DatabaseProvider();
		dbp.setInstance(idb);
		System.out.println(idb);
		assertEquals(idb, dbp.getInstance());
	}
	
	@Test
	public void testGetInstance()
	{
		assertEquals(idb, dbp.getInstance());
		
	}
}
