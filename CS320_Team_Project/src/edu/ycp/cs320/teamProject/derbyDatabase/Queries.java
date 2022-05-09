package edu.ycp.cs320.teamProject.derbyDatabase;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.teamProject.model.Pair;
import edu.ycp.cs320.teamProject.storage.Job;
import edu.ycp.cs320.teamProject.storage.User;
import edu.ycp.cs320.teamProject.storage.UserJob;

public class Queries implements IDatabase {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}

	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;
	
	@Override
	public User findUserByID(String username, String password) {
		return executeTransaction(new Transaction<User>() {
			@Override
			public User execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select users.user_id " +
							"  from  users " +
							"  where users.username = ? " +
							"  and users.password = ? "
					);
					stmt.setString(1, username);
					stmt.setString(2, password);
					
					User result = new User();
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						User user = new User();
						loadUser(user, resultSet, 0);
						
						result = user;
					}
					result.setUsername(username);
					result.setPassword(password);
					
					// check if the title was found
					if (!found) {
						System.out.println("<" + username + "> was not found in the users table");
					}
					
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}

	@Override
	public List<Pair<User, Job>> findAllJobsByUserID(String username, String password) {
		return executeTransaction(new Transaction<List<Pair<User, Job>>>() {
			@Override
			public List<Pair<User, Job>> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					
					User user = new User(username, password);
					user = findUserByID(user.getUsername(), user.getPassword());
					stmt = conn.prepareStatement(
							"select jobs.* " +
							"  from jobs, users, userjob  " + 
							"  where jobs.job_id = userjob.job_id and " + 
							"  users.user_id = userjob.user_id and " + 
							"  users.user_id = ?"
					);
					
					int id = user.getUserID();
					stmt.setInt(1, id);
				
					ArrayList<Pair<User, Job>> result = new ArrayList<Pair<User, Job>>();
					
					
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						Job job = new Job();
						loadJob(job, resultSet, 0);
						Pair<User, Job> pair = new Pair<User, Job>(user, job);
						ArrayList<Pair<User, Job>> list = new ArrayList<Pair<User, Job>>();
						list.add(pair);
						result = list;
					}
					
					if (!found) {
						System.out.println("<" + id + "> was not found in the users table");
					}
					
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}

	@Override
	public Integer insertUser(String username, String password) {
		return executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				//PreparedStatement checkAdmin = null;
				ResultSet resultSet = null;
				//User admin = null;
				
				try {
					stmt = conn.prepareStatement(
							"insert into users (username, password) " +
							"  values (?, ?) "
					);
					stmt.setString(1, username);
					stmt.setString(2,  password);
					
					Integer result = 1;
					
					stmt.executeUpdate();
				
					/* checkAdmin = conn.prepareStatement("select users.user_id, users.username, users.password "
						 		+ " from users"
						 		+ " where users.username = ?"
						 		+ " and users.password = ?");
						 
						 checkAdmin.setString(1, username);
						 checkAdmin.setString(2, password);
							
							// execute the query, get the results, and assemble them in an ArrayList
							resultSet = checkAdmin.executeQuery();
							//set num rows to 0
							int rows = 0;
							while (resultSet.next()) {
								//user the loadUser method to initialize the retrieved values to the
								//assigned user object
								//NOTE: loadUser is located above and uses User Class setter methods
								loadUser(admin, resultSet, 1);
			
								//add that user to the result List
								System.out.println(admin);
								//increment rows
								rows++;
								result = 1;
							}
							//if no amount of rows exists run this method
							if (rows == 0) {
								//print out statement saying no Admin found along with the admin username and password
								System.out.println("Error inserting User");
							} */
							
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}

	@Override
	public Integer insertJobIntoJobsTable(String title, Double salary, String location, int housingStipend,
			Double commuteTime, boolean remote, int size, int age, int culture, int opportunity,
			int workLifeBalance, boolean insurance, boolean pension, boolean pto, int signingBonus, int annualBonus,
			int jobLevel, int length, int resumeStrength, int credits, boolean fullTimeOpportunity, int sizeWeight,
			int ageWeight, int cultureWeight, int opportunityWeight, int workLifeBalanceWeight, int salaryWeight, String username, String password) {
		return executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				PreparedStatement stmt2 = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"insert into jobs (name, salary, location, housingStipend, commuteTime, remote, size, age, culture, opportunity, workLifeBalance, sizeWeight, ageWeight, cultureWeight, opportunityWeight, workLifeBalanceWeight, salaryWeight) " +
							"  values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) "
					);
					stmt.setString(1, title);
					stmt.setDouble(2,  salary);
					stmt.setString(3, location);
					stmt.setInt(4, housingStipend);
					stmt.setDouble(5, commuteTime);
					stmt.setBoolean(6, remote);
					stmt.setInt(7, size);
					stmt.setInt(8, age);
					stmt.setInt(9, culture);
					stmt.setInt(10, opportunity);
					stmt.setInt(11, workLifeBalance);
					stmt.setInt(12, sizeWeight);
					stmt.setInt(13, ageWeight);
					stmt.setInt(14, cultureWeight);
					stmt.setInt(15, opportunityWeight);
					stmt.setInt(16, workLifeBalanceWeight);
					stmt.setInt(17, salaryWeight);
					
					User user = findUserByID(username, password); 
					
					stmt2 = conn.prepareStatement(
							" insert into userjob (user_id, job_id) " +
							" values (?, ?) "
							
					);
					stmt2.setInt(1, user.getUserID());
					
					//findAllJobsByUserID(user.getUserID());
					
					//stmt2.setInt(2, );
					
					Integer result = 1;
					
					stmt.executeUpdate();
					
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}

	@Override
	public Integer removeJobByTitle(String title) {
		return executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"delete from jobs where " +
							"  jobs.title = ? "
					);
					stmt.setString(1, title);
					
					Integer result = 0;
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Integer found = 0;
					
					while (resultSet.next()) {
						found = 1;
						
						result = found;
					}
					
					// check if the title was found
					if (found == 0) {
						System.out.println("<" + title + "> was not correctly deleted");
					}
					
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
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
			Connection conn = DriverManager.getConnection("jdbc:derby:C:/inputs.db;create=true");		
			
			// Set autocommit() to false to allow the execution of
			// multiple queries/statements as part of the same transaction.
			conn.setAutoCommit(false);
			
			return conn;
		}
		
		// retrieves Job information from query result set
		private void loadJob(Job job, ResultSet resultSet, int index) throws SQLException {
			job.setJobID(resultSet.getInt(index++));
			job.setSalary(resultSet.getDouble(index++));
			job.setLocation(resultSet.getString(index++));
			job.setHousingStipend(resultSet.getInt(index++));
			job.setCommuteTime(resultSet.getDouble(index++));
			job.setRemote(resultSet.getBoolean(index++));
			job.setSize(resultSet.getInt(index++));
			job.setAge(resultSet.getInt(index++));
			job.setCulture(resultSet.getInt(index++));
			job.setOpportunity(resultSet.getInt(index++));
			job.setWorkLifeBalance(resultSet.getInt(index++));
			job.setSizeWeight(resultSet.getInt(index++));
			job.setAgeWeight(resultSet.getInt(index++));
			job.setCultureWeight(resultSet.getInt(index++));
			job.setOpportunityWeight(resultSet.getInt(index++));
			job.setWorkLifeBalanceWeight(resultSet.getInt(index++));
			job.setSalaryWeight(resultSet.getInt(index++));
			// TODO change following values depending on type of job
			job.setInsurance(resultSet.getBoolean(index++));
			job.setPension(resultSet.getBoolean(index++));
			job.setPto(resultSet.getBoolean(index++));
			job.setSigningBonus(resultSet.getInt(index++));
			job.setAnnualBonus(resultSet.getInt(index++));
			job.setJobLevel(resultSet.getInt(index++));
			job.setLength(resultSet.getInt(index++));
			job.setResumeStrength(resultSet.getInt(index++));
			job.setCredits(resultSet.getInt(index++));
			job.setFullTimeOpportunity(resultSet.getBoolean(index++));
			//
		}
		
		// retrieves User information from query result set
		private void loadUser(User user, ResultSet resultSet, int index) throws SQLException {
			user.setUserID(resultSet.getInt(index++));
			user.setUsername(resultSet.getString(index++));
			user.setPassword(resultSet.getString(index++));
		}
		
		private void loadUserJob(UserJob userJob, ResultSet resultSet, int index) throws SQLException {
			userJob.setUserID(resultSet.getInt(index++));
			userJob.setJobID(resultSet.getInt(index++));
		}
		
		// loads default data into database such as:
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
					// TODO we need to change this or change Job to concrete
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
					 
					 System.out.println("Loading Initial Data: ");
					 try {	 
					//query to check to see if the admin user already exists within the database
					 checkAdmin = conn.prepareStatement("select users.user_id, users.username, users.password "
					 		+ " from users"
					 		+ " where users.username = ?"
					 		+ " and users.password = ?");
					 
					 checkAdmin.setString(1, admin.getUsername());
					 checkAdmin.setString(2, admin.getPassword());
						
						// execute the query, get the results, and assemble them in an ArrayList
						resultSet = checkAdmin.executeQuery();
						//set num rows to 0
						int rows = 0;
						while (resultSet.next()) {
							//user the loadUser method to initialize the retrieved values to the
							//assigned user object
							//NOTE: loadUser is located above and uses User Class setter methods
							loadUser(admin, resultSet, 1);
		
							//add that user to the result List
							System.out.println(admin.getUsername() + ", " + admin.getPassword());
							//increment rows
							rows++;
						}
						//if no amount of rows exists run this method
						if (rows == 0) {
							//print out statement saying no Admin found along with the admin username and password
							System.out.println("No Admin User found. Initializing new Admin User in database: ");

								 //create insertion query
								 int result = insertUser(admin.getUsername(), admin.getPassword());
								 if (result == 1)
								 {
								 System.out.println("Your Admin User is:");
									//could create a random user and password generator later on
									System.out.println("Username: " + admin.getUsername());
									System.out.println("Password: " + admin.getPassword());
									System.out.println("ID: " + admin.getUserID());
									
								 System.out.println("Admin profile succesffuly input!");
								 }
								 else {
									 System.out.println("error with loading admin into table");
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
