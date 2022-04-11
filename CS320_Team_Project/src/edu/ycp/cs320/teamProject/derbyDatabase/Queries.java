package edu.ycp.cs320.teamProject.derbyDatabase;

import edu.ycp.cs320.teamProject.derbyDatabase.DatabaseProvider;
import edu.ycp.cs320.teamProject.derbyDatabase.IDatabase;

public class Queries{
	static {
		IDatabase db = DatabaseProvider.getInstance();
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}
}
