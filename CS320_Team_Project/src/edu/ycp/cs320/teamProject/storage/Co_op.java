package edu.ycp.cs320.teamProject.storage;

//Inheritance call 
	class Co_op extends Information{

//Fields 
		
	private int length; 
	private int resumeStrength; 
	private int credits; 
	
	
//Constructors 
	public Co_op(int length, int resumeStrength, int credits){
		this.length = length; 
		this.credits = credits; 
		this.resumeStrength = resumeStrength; 
	}
	
//setters
	public void setLength(int length) {
		this.length = length; 
	}
	
	public void setresumeStrength(int resumeStrength) {
		this.resumeStrength = resumeStrength; 
	}
	public void setCredits(int credits) {
		this.credits = credits; 
	}
	
//getters 
	
	public int getLength() {
		return length;
	}
	
	public int getresumeStrength() {
		return resumeStrength;
	}
	
	public int getCredits() {
		return credits;
	}
		
}