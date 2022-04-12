package edu.ycp.cs320.teamProject.derbyDatabase;

<<<<<<< Updated upstream
import edu.ycp.cs320.teamProject.derbyDatabase.DatabaseProvider;
import edu.ycp.cs320.teamProject.derbyDatabase.IDatabase;

public class Queries{
=======
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

public class Queries implements IDatabase {
>>>>>>> Stashed changes
	static {
		IDatabase db = DatabaseProvider.getInstance();
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
	public List<Pair<User, Job>> findUserByID(String id) {
		return executeTransaction(new Transaction<List<Pair<User,Job>>>() {
			@Override
			public List<Pair<User, Job>> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select authors.*, books.* " +
							"  from  authors, books, bookAuthors " +
							"  where books.title = ? " +
							"    and authors.author_id = bookAuthors.author_id " +
							"    and books.book_id     = bookAuthors.book_id"
					);
					stmt.setString(1, title);
					
					List<Pair<User, Job>> result = new ArrayList<Pair<User,Job>>();
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						Author author = new Author();
						loadAuthor(author, resultSet, 1);
						Book book = new Book();
						loadBook(book, resultSet, 4);
						
						result.add(new Pair<User, Job>(author, book));
					}
					
					// check if the title was found
					if (!found) {
						System.out.println("<" + title + "> was not found in the books table");
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
	public List<Pair<User, Job>> findAllJobsByUserID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertUser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertJobIntoJobsTable(String title, Double salary, String location, int housingStipend,
			Double commuteTime, boolean remote, int size, int age, int culture, int opportunity,
			int workLifeBalance, boolean insurance, boolean pension, boolean pto, int signingBonus, int annualBonus,
			int jobLevel, int length, int resumeStrength, int credits, boolean fullTimeOpportunity, int sizeWeight,
			int ageWeight, int cultureWeight, int opportunityWeight, int workLifeBalanceWeight, int salaryWeight) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Job> removeJobByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
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
			Connection conn = DriverManager.getConnection("jdbc:derby:C:/CS320-2022-LibraryExample-DB/library.db;create=true");		
			
			// Set autocommit() to false to allow the execution of
			// multiple queries/statements as part of the same transaction.
			conn.setAutoCommit(false);
			
			return conn;
		}
		
		// retrieves Job information from query result set
		private void loadJob(Job job, ResultSet resultSet, int index) throws SQLException {
			job.setSalary(resultSet.getInt(index++));
			job.setLocation(resultSet.getString(index++));
			job.setHousingStipend(resultSet.getString(index++));
			job.setCommuteTime(resultSet.getString(index++));
			job.setRemote(resultSet.getString(index++));
			job.setSize(resultSet.getString(index++));
			job.setAge(resultSet.getString(index++));
			job.setCulture(resultSet.getString(index++));
			job.setOpportunity(resultSet.getString(index++));
			job.setWorkLifeBalance(resultSet.getString(index++));
			job.setInsurance(resultSet.getString(index++));
			job.setPension(resultSet.getString(index++));
			job.setPto(resultSet.getString(index++));
			job.setSigningBonus(resultSet.getString(index++));
			job.setAnnualBonus(resultSet.getString(index++));
			job.setJobLevel(resultSet.getString(index++));
			// TODO change following values depending on type of job
			job.setLength(resultSet.getString(index++));
			job.setResumeStrength(resultSet.getString(index++));
			job.setCredits(resultSet.getString(index++));
			job.setFullTimeOpportunity(resultSet.getString(index++));
			//
			job.setSizeWeight(resultSet.getString(index++));
			job.setAgeWeight(resultSet.getString(index++));
			job.setCultureWeight(resultSet.getString(index++));
			job.setOpportunityWeight(resultSet.getString(index++));
			job.setWorkLifeBalanceWeight(resultSet.getString(index++));
			job.setSalaryWeight(resultSet.getString(index++));
		}
		
		// retrieves User information from query result set
		private void loadUser(User user, ResultSet resultSet, int index) throws SQLException {
//			book.setAuthorId(resultSet.getInt(index++));  // no longer used
			user.setUsername(resultSet.getString(index++));
			user.setPassword(resultSet.getString(index++));
		}
}
