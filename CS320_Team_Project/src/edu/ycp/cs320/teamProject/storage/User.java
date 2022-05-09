package edu.ycp.cs320.teamProject.storage;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
	// fields
	private String username;
	private String password;
	private String encrypted;
	private int userID;
	
	// Constructor
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.encrypted = getMd5(password);
	}
	
	public User() {
	}

	public static String getMd5(String input)
    {
        try {
  
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
  
            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());
  
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
  
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } 
  
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        	}
    }
	
	// compare input md5 to set md5
	public Boolean login(String input) {
		if (getMd5(input).contentEquals(encrypted)) {
			return true;
		}
		return false;
	}
	
	public int getUserID()
	{
		return userID;
	}
	public void setUserID(int userID)
	{
		this.userID = userID;
	}
	public void setPassword(String password) {
		this.password = password;
		if (password != null)
		{
		this.encrypted = getMd5(password);
		}
	}
	public String getPassword() {
		return password;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public String getEncrypted() {
		return encrypted;
	}
}
