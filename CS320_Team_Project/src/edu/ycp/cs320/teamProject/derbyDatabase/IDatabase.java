package edu.ycp.cs320.teamProject.derbyDatabase;

import java.util.List;


import edu.ycp.cs320.teamProject.storage.User;
import edu.ycp.cs320.teamProject.storage.Job;
import edu.ycp.cs320.teamProject.model.Pair;

public interface IDatabase {
	public User findUserByID(String id);
	public List<Pair<User, Job>> findAllJobsByUserID(String id);
	public Integer insertUser(String username, String password);
	public Integer insertJobIntoJobsTable(String title, Double salary, String location, int housingStipend, Double commuteTime, boolean remote, int size, int age, int culture, int opportunity, int workLifeBalance, boolean insurance, boolean pension, boolean pto, int signingBonus, int annualBonus, int jobLevel, int length, int resumeStrength, int credits, boolean fullTimeOpportunity, int sizeWeight, int ageWeight, int cultureWeight, int opportunityWeight, int workLifeBalanceWeight, int salaryWeight);
	public Integer removeJobByTitle(String title);	
	public void loadInitialData();
}
