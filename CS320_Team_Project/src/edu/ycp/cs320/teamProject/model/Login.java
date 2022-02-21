package edu.ycp.cs320.teamProject.model;

public class Login {
	private String username, password;
	
	public Login()
	{
		username = null;
		password = null;
	}
	
	public void setUsername(String inputUsername)
	{
		this.username = inputUsername;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setPassword(String inputPassword)
	{
		this.password = inputPassword;
	}
	
	public String getPassword()
	{
		return password;
	}
}
