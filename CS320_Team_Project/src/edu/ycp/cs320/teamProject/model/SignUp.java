package edu.ycp.cs320.teamProject.model;

public class SignUp{
	 private String newUsername;
	 private String newPassword;
	 
	 public SignUp()
	 {
		 newUsername = null;
		 newPassword = null; 
	 }
	 
	 public String getUsername() {
		 return newUsername;
	 }
	 
	 public String getPassword() {
		 return newPassword;
	 }
	 
	 public void setUsername(String newUser) {
		 this.newUsername = newUser; 
	 }
	 
	 public void setPassword(String newPW) {
		 this.newPassword = newPW;
	 }
	 
	 }