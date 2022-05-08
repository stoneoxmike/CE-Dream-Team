package database;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.teamProject.derbyDatabase.DBUtil;
import edu.ycp.cs320.teamProject.derbyDatabase.DatabaseProvider;
import edu.ycp.cs320.teamProject.derbyDatabase.Derby;
import edu.ycp.cs320.teamProject.derbyDatabase.IDatabase;
import edu.ycp.cs320.teamProject.derbyDatabase.PersistenceException;

public class DerbyTest {
	private boolean connected;
	private Derby db;
	private DatabaseProvider dbp;
	private IDatabase idb;
	Connection conn;
	
	@Before
	public void setup()
	{
		connected = true;
		Derby db = new Derby();
	//	System.out.println(conn);
		conn = null;
	}
	
	@Test
	public void testConnection()
	{
		conn = null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			conn = DriverManager.getConnection("jdbc:derby:C:/test.db;create=true");
			System.out.println(conn);
		//	connected = true;
		} catch (SQLException e)
		{
			connected = false;
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e)
		{
			connected = false;
			System.out.println("Embedded Driver Error");
			System.out.println(e.getMessage());
		}
		assertTrue(connected);
	}
	
	@Test
	public void testCreateTables()
	{
		Boolean test = false;
		try {
			Derby db = new Derby();
			System.out.println(conn);
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			db.createTables(conn, true);
			test = true;
		    db.dropTables("userjob", true);
			db.dropTables("users", true);
			db.dropTables("jobs", true);
		} catch (ClassNotFoundException e)
		{
			test = false;
			System.out.println("Embedded Driver Error");
			System.out.println(e.getMessage());
		} catch(PersistenceException e)
		{
			
		}
		assertTrue(test);
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
	
	/*
	private static void Initialize(Connection conn) throws IOException {
					try {
						//checks to see if the table of users exists
						//creates User tables
						System.out.println("Creating tables...");
						Derby tables = new Derby();
						tables.createTables();
						
						System.out.println("Loading initial data...");
						DatabaseProvider db = new DatabaseProvider();
						db.getInstance().loadInitialData();
						
						System.out.println("DB successfully initialized!");
					} catch (PersistenceException e) {
						System.out.println("Error with database. Tables may already exist");
					}
			}
	
	
	
}
*/
