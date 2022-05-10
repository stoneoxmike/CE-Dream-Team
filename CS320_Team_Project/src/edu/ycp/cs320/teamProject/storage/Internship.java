package edu.ycp.cs320.teamProject.storage;

// Inheritance Call
public class Internship extends Job {
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

		//getters

		public int getLength() {
			return length; 
		}
		
		public int getResumeStrength() {
			return resumeStrength; 
		}
		
		public boolean getfullTimeOpportunity() {
			return fullTimeOpportunity;
		}
		
		//setters 
		
		@Override
		public void setLength(int length) {
			// TODO Auto-generated method stub
			this.length = length;
		}


		@Override
		public void setResumeStrength(int resumeStrength) {
			// TODO Auto-generated method stub
			this.resumeStrength = resumeStrength;
		}

		@Override
		public void setFullTimeOpportunity(Boolean fullTimeOpportunity) {
			// TODO Auto-generated method stub
			this.fullTimeOpportunity = fullTimeOpportunity;
		}
		
		
}
