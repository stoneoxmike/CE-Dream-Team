package database;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.ycp.cs320.teamProject.derbyDatabase.DatabaseProvider;
import edu.ycp.cs320.teamProject.derbyDatabase.IDatabase;

public class QueriesTest {

	private DatabaseProvider dbp;
	private IDatabase idb;
	
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
