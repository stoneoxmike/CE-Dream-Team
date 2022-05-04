package edu.ycp.cs320.teamProject.derbyDatabase;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.ycp.cs320.teamProject.model.Pair;
import edu.ycp.cs320.teamProject.derbyDatabase.DatabaseProvider;
import edu.ycp.cs320.teamProject.derbyDatabase.IDatabase;
import edu.ycp.cs320.teamProject.storage.Full_Time;
import edu.ycp.cs320.teamProject.storage.Job;
import edu.ycp.cs320.teamProject.storage.User;
import edu.ycp.cs320.teamProject.storage.UserJob;




//IMPORTANT
//-------------------------
//Code adapted from Lab 6
//-------------------------




/**
 * An interactive query tool for SQLite.
 */
public class Derby {
	static class RowList extends ArrayList<List<String>> {
		private static final long serialVersionUID = 1L;
	}
	
	private static final String PAD =
		"                                                    " +
		"                                                    " +
		"                                                    " +
		"                                                    ";
	private static final String SEP =
		"----------------------------------------------------" +
		"----------------------------------------------------" +
		"----------------------------------------------------" +
		"----------------------------------------------------";

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
						tables.createTables(conn, false);
						
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
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn, Boolean input) {
		try {
			return doExecuteTransaction(txn, input);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
	
	// SQL transaction function which retries the transaction MAX_ATTEMPTS times before failing
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn, Boolean input) throws SQLException {
		Connection conn = connect(input);
		
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
	private Connection connect(Boolean input) throws SQLException {
		Connection conn = null;
		if (input == false)
		{
		conn = DriverManager.getConnection("jdbc:derby:inputsdb;create=true");		
		
		// Set autocommit() to false to allow the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		}
		else if (input == true)
		{
		conn = DriverManager.getConnection("jdbc:derby:testdb;create=true");
		conn.setAutoCommit(false);
		}
		return conn;
	}
	
	//  creates the Authors and Books tables
	public void createTables(Connection inputConn, Boolean test) {
		Connection tempConn = inputConn;
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection tempConn) throws SQLException {
				System.out.println(tempConn);
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;				
			
				try {
					stmt1 = tempConn.prepareStatement(
						"create table users (" +
						"	user_id integer primary key " +
						"		generated always as identity (start with 1, increment by 1), " +									
						"	username varchar(40)," +
						"	password varchar(40)" +
						")"
					);	
					stmt1.executeUpdate();
					
					System.out.println("Users table created");
					
					stmt2 = tempConn.prepareStatement(
							"create table jobs(" +
							"	job_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
//							"	author_id integer constraint author_id references authors, " +  	// this is now in the BookAuthors table
							"	name varchar(128)," +
							"	salary float," +
							"   location varchar(128)," +
							"   housingStipend integer," +
							"   commuteTime float," +
//----------------------------------------------------------------------------------------------
// The recommended way of storing booleans in Oracle SQL is to use a NUMBER(1) field. 
//This can store 1 as true and 0 as false.
//This can be handled within the actual request from the JSP to convert the boolean answer
// of true or false to the binary values of 1 or 0.
							"   remote int," +
//----------------------------------------------------------------------------------------------
							"   size integer," + 
							"   age integer," +
							"   culture integer," +
							"   opportunity integer," +
							"   workLifeBalance integer," +
							"   sizeWeight integer," +
							"   ageWeight integer," +
							"   cultureWeight integer," +
							"   opportunityWeight integer," +
							"   workLifeBalanceWeight integer," +
							"   salaryWeight integer" +
							")"
					);
					stmt2.executeUpdate();
					
					System.out.println("Jobs table created");					
					
					stmt3 = tempConn.prepareStatement(
							"create table userjob (" +
							"	user_id integer constraint user_id references users, " +
							"	job_id integer constraint job_id references jobs " +
							")"
					);
					stmt3.executeUpdate();
					
					System.out.println("UserJobs table created");					
										
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt3);
				}
			}
		}, test);
	}
	
	public void dropTables(String tableName, Boolean test)
	{
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;				
			
				try {
					stmt1 = conn.prepareStatement(
						"drop table "
						+ tableName
					);	
					stmt1.executeUpdate();
					
					System.out.println(tableName +" table removed");
					return true;
				} catch (SQLException e)
				{
					System.out.println("Error Deleting Table: " + tableName);
					System.out.println(e.getMessage());
					return false;
				}
			
			}
		}, test);
	}
}