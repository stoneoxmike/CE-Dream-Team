package edu.ycp.cs320.teamProject.derbyDatabase;

import java.util.List;


import edu.ycp.cs320.teamProject.storage.User;
import edu.ycp.cs320.teamProject.storage.Job;
import edu.ycp.cs320.teamProject.model.Pair;

public interface IDatabase {
	public List<Pair<User, Job>> findUserByID(String id);
	public List<Pair<User, Job>> findAllJobsByUserID(String id);
	public Integer insertUser(String username, String password);
	public Integer insertFulltimeIntoJobsTable(String title, String isbn, int published, String lastName, String firstName);
	public Integer insertCoopIntoJobsTable(String title, String isbn, int published, String lastName, String firstName);
	public Integer insertInternshipIntoJobsTable(String title, String isbn, int published, String lastName, String firstName);
	public List<Job> removeJobByTitle(String title);		
}
