package edu.ycp.cs320.teamProject.storage;

// Inheritance Call
public class Internship extends Information {
	//Fields 
	
		private int length; 
		private int resumeStrength;
		private boolean fullTimeOpportunity;
		
		
	//Constructors 
		public Internship(int length, int resumeStrength, boolean fullTimeOpportunity){
			this.length = length;  
			this.resumeStrength = resumeStrength; 
			this.fullTimeOpportunity = fullTimeOpportunity;
		}
}
