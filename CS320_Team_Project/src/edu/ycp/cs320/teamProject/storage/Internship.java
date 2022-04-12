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


		@Override
		public void setInsurance(Boolean insurance) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void setPension(Boolean pension) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void setPto(Boolean pto) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void setSigningBonus(int signingBonus) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void setAnnualBonus(int annualBonus) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void setJobLevel(int jobLevel) {
			// TODO Auto-generated method stub
			
		}


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
		public void setCredits(int credits) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void setFullTimeOpportunity(Boolean fullTimeOpportunity) {
			// TODO Auto-generated method stub
			this.fullTimeOpportunity = fullTimeOpportunity;
		}
		
		
}
