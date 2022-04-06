package edu.ycp.cs320.teamProject.derbyDatabase;

import java.util.List;


import edu.ycp.cs320.teamProject.storage.User;
import edu.ycp.cs320.teamProject.storage.Job;
import edu.ycp.cs320.teamProject.model.Pair;

public interface IDatabase {
	public List<Pair<User, Job>> findAuthorAndBookByTitle(String title);
	public List<Pair<User, Job>> findAuthorAndBookByAuthorLastName(String lastName);
	public Integer insertBookIntoBooksTable(String title, String isbn, int published, String lastName, String firstName);
	public List<Pair<User, Job>> findAllBooksWithAuthors();
	public List<User> findAllAuthors();
	public List<Job> removeBookByTitle(String title);		
}
