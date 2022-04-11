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
						Derby db = new Derby();
						db.createTables();
						
						System.out.println("Loading initial data...");
						db.loadInitialData();
						
						System.out.println("DB successfully initialized!");
					} catch (Exception e) {
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
	}
	
	// retrieves User information from query result set
	private void loadUser(User user, ResultSet resultSet, int index) throws SQLException {
		user.setUserID(resultSet.getInt(index++));
		user.setUsername(resultSet.getString(index++));
		user.setPassword(resultSet.getString(index++));
	}
	
	// retrieves Job information from query result set
	private void loadJob(Job job, ResultSet resultSet, int index) throws SQLException {

	}
	
	// retrieves WrittenBy information from query result set
	private void loadUserJob(UserJob UserJob, ResultSet resultSet, int index) throws SQLException {
		
	}
	
	//  creates the Authors and Books tables
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;				
			
				try {
					stmt1 = conn.prepareStatement(
						"create table users (" +
						"	user_id integer primary key " +
						"		generated always as identity (start with 1, increment by 1), " +									
						"	username varchar(40)," +
						"	password varchar(40)" +
						")"
					);	
					stmt1.executeUpdate();
					
					System.out.println("Users table created");
					
					stmt2 = conn.prepareStatement(
							"create table jobs(" +
							"	job_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
//							"	author_id integer constraint author_id references authors, " +  	// this is now in the BookAuthors table
							"	name varchar(128)," +
							"	salary float," +
							"   location varchar(128)" +
							"   housingStipend integer" +
							"   commuteTime float" +
//----------------------------------------------------------------------------------------------
// The recommended way of storing booleans in Oracle SQL is to use a NUMBER(1) field. 
//This can store 1 as true and 0 as false.
//This can be handled within the actual request from the JSP to convert the boolean answer
// of true or false to the binary values of 1 or 0.
							"   remote NUMBER(1)" +
//----------------------------------------------------------------------------------------------
							"   size integer" + 
							"   age integer" +
							"   culture integer" +
							"   opportunity integer" +
							"   workLifeBalance integer" +
							"   sizeWeight integer" +
							"   ageWeight integer" +
							"   cultureWeight integer" +
							"   opportunityWeight integer" +
							"   workLifeBalanceWeight integer" +
							"   salaryWeight integer" +
							")"
					);
					stmt2.executeUpdate();
					
					System.out.println("Jobs table created");					
					
					stmt3 = conn.prepareStatement(
							"create table UserJob (" +
							"	user_id   integer constraint user_id references books, " +
							"	job_id integer constraint job_id references authors " +
							")"
					);
					stmt3.executeUpdate();
					
					System.out.println("UserJobs table created");					
										
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
				}
			}
		});
	}
	
	// loads default data into database such as:
	//		-creating tables
	//		-default admin profile
	//		-default keys
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				//default admin username
				String username = "admin";
				//default admin password
				String password = "12345";
				//fake salary for sample job
				double inputSalary = 12000.12;
				//fake location for sample job
				String inputLocation = "Maryland";
				//fake stipend for sample job
				int housingStipend = 2500;
				//fake commute time for sample job
				Double commuteTime = 1.5;
				//create a new User object called admin
				//using the username and password
				User admin = new User(username, password);
				//create a new Job object called sample
				Job sample = new Job();
				//Use setters within Job class to assigned values
				sample.setSalary(inputSalary);
				sample.setLocation(inputLocation);
	
				//create preparedStatments for queries
				 PreparedStatement insertAdmin = null;
				 PreparedStatement checkAdmin  = null;
				 PreparedStatement insertJob   = null;
				 PreparedStatement checkJob    = null;
				 
				 //create resultSet to store returned queries
				 ResultSet resultSet           = null;
				 
				 try {	 
				//query to check to see if the admin user already exists within the database
				 checkAdmin = conn.prepareStatement("select users.user_id, users.username, users.password "
				 		+ " from users"
				 		+ " where users.username = ?"
				 		+ " and users.password = ?");
				 
				 checkAdmin.setString(1, admin.getUsername());
				 checkAdmin.setString(2, admin.getPassword());
					
					// establish the list of Users to receive the result
					List<User> result = new ArrayList<User>();
					
					// execute the query, get the results, and assemble them in an ArrayList
					resultSet = checkAdmin.executeQuery();
					//set num rows to 0
					int rows = 0;
					while (resultSet.next()) {
						//create a new user object
						User updatedUser = new User();
						//user the loadUser method to initialize the retrieved values to the
						//assigned user object
						//NOTE: loadUser is located above and uses User Class setter methods
						loadUser(updatedUser, resultSet, 1);
	
						//add that user to the result List
						result.add(updatedUser);
						//increment rows
						rows++;
					}
					//if some amount of rows exists run this method
					if (rows != 0)
					{
						for (int i = 0; i < result.size(); i++)
						{
							//print out the iteration and admin profile information 
							System.out.println((i+1)+ ": " + "\n" + "username: " + result.get(i).getUsername() + "\n" + "password: " + result.get(i).getPassword());
						}
					}
					//if no amount of rows exists run this method
					else {
						//
						System.out.println("No Admin User found. Initializing new Admin User in database: ");
						System.out.println("Your Admin User is:");
						System.out.println("Username: " + admin.getUsername());
						System.out.println("Password: " + admin.getPassword());
						
						try {
							
							 result = new ArrayList<User>();
							
							 insertAdmin = conn.prepareStatement("insert into users (username, password) values (?,?)");
							 
							 insertAdmin.setString(1, admin.getUsername());
							 insertAdmin.setString(2, admin.getPassword());
							 
							 resultSet = insertAdmin.executeQuery();
							 rows = 0;
							 while (resultSet.next())
							 {
								 User createdUser = new User();
								 loadUser(createdUser, resultSet, 1);
								 
								 result.add(createdUser);
							 }
							 
						} catch (SQLException e) {
							throw new SQLException("It made a fucky wucky", e);
						} finally {
							DBUtil.closeQuietly(insertAdmin);	
						}
					}
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(checkAdmin);
				} 
				 return true;
			}
		});
	}
}