package edu.ycp.cs320.teamProject.storage;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserJob {
	// fields
	private int userID;
	private int jobID;
	
	public UserJob() {
		//initialize both ID's to -1 so that it will return null in queries
		userID = -1;
		jobID = -1;
		
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	
	public int getJobID() {
		return jobID;
	}
}
