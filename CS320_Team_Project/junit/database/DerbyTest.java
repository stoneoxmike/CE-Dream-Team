package database;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import edu.ycp.cs320.teamProject.derbyDatabase.DBUtil;
import edu.ycp.cs320.teamProject.derbyDatabase.DatabaseProvider;
import edu.ycp.cs320.teamProject.derbyDatabase.Derby;
import edu.ycp.cs320.teamProject.derbyDatabase.PersistenceException;

public class DerbyTest {
	private boolean connected;
	private Derby db;
	Connection conn;
	
	public void setup()
	{
		connected = true;
		Derby db = new Derby();
		conn = null;
	}
	
	@Test
	public void testConnection()
	{
		conn = null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			conn = DriverManager.getConnection("jdbc:derby:inputsdb;create=true");
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
	/*
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Connection conn = null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			//creates database connection (if database doesn't exist create database)
			conn = DriverManager.getConnection("jdbc:derby:inputsdb;create=true");
			conn.setAutoCommit(true);
	
			Initialize(conn);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			DBUtil.closeQuietly(conn);
		}
		
}

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
	
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;	

	// wrapper SQL transaction function that calls actual transaction function (which has retries)
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
	
	// SQL transaction function which retries the transaction MAX_ATTEMPTS times before failing
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();
		
		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;
			
			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}
			
			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}
			
			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}

	// TODO: Here is where you name and specify the location of your Derby SQL database
	// TODO: Change it here and in SQLDemo.java under CS320_LibraryExample_Lab06->edu.ycp.cs320.sqldemo
	// TODO: DO NOT PUT THE DB IN THE SAME FOLDER AS YOUR PROJECT - that will cause conflicts later w/Git
	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:inputsdb;create=true");		
		
		// Set autocommit() to false to allow the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}*/
	
}
