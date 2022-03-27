package edu.ycp.cs320.teamProject.derbyDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Derby {
	public static void main(String[] args) throws ClassNotFoundException {
		//connect to the derby jdcb driver
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		
		//create the URL string for the Derby database
		String jdbcURL = "jdbc:derby:inputdb;create=true";
		try {
			//check the class for the embedded Driver
			Class.forName(driver);
			//create a connection message for the drivermanager getting the database URL
			Connection conn = DriverManager.getConnection(jdbcURL);
			//print out a confirmation message
			System.out.println("derby database successfully connected");
			//create a table
			//need to create a logic check for this if a table already exists
			createTable("inputs", conn);
			//create a row
			//this is where the requests would be made to from the HTTP to create rows based on the columns
			createRow("inputs", "name", "salary", "BD", "12420", conn);
			//catch an SQL exception
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//shutdown Derby to not consume memory and processing data
		shutdownDerby();
	}
	
	//method to create a table within Derby SQL
	public static void createTable(String tableName, Connection conn) 
	{
		//create a temporary statement variable
		Statement stmt = null;
		//sql query string
		String sql = "Create Table " + tableName + " (id int not null generated always as identity," + "name varchar(128), salary float)";
		try 
		{
			//create a statement with the connection from the main method
		stmt = conn.createStatement();
		//update the Derby database with the statement using the query string
		stmt.executeUpdate(sql);
		//print out a confirmation message
		System.out.println("Table " + tableName + " Created!");
		}
		//catch a sql exception
		catch (SQLException e)
		{
			System.out.println("Error Creating Table (Table may already exist)");
		}
	}
	
	public static void createRow(String tableName, String rowName, String rowValue, String valueName, String valueValue, Connection conn)
	{
		//create a temporary statement variable
		Statement stmt = null;
		//sql query string
		String sql = "Insert into " + tableName + 
				" ("+rowName+", "+rowValue+") values ('"+valueName+"', "+valueValue+")";
		try
		{
			//create a statement with the connection from the main method
		stmt = conn.createStatement();
		//check to see if it added a row
		//check should get previous amount of rows and check for previous + 1
		int rows = stmt.executeUpdate(sql);
		if (rows > 0)
		{
			System.out.println("Row " + rowName + " Successfully created in " + tableName + "!");
		}
		//catch a sql exception
		} catch (SQLException e) {
			System.out.println("Row creating failed.");
		}
	}
	
	//method to shutdownDerby database connection
	public static void shutdownDerby()
	{
		String shutdownURL = "jdbc:derby:;shutdown=true";
		try {
			DriverManager.getConnection(shutdownURL);
		} catch (SQLException e) {
			//the SQL state should return this string as an Exception catch
			if (e.getSQLState().equals("XJ015"))
			{
				System.out.println("Derby shutdown successfully");
			}
			//if not, Derby did not shutdown correctly
			else
			{
			System.out.println("Error closing Derby");
			
			}
		}
	}
}
