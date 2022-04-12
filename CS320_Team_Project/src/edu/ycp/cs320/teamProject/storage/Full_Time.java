package edu.ycp.cs320.teamProject.storage;

public class Full_Time extends Job {
	// full time fields
	private boolean insurance;
	private boolean pension;
	private boolean pto;
	private int signingBonus;
	private int annualBonus;
	private int jobLevel;
	
	public Full_Time(boolean insurance, boolean pension, boolean pto, int signingBonus, int annualBonus, int jobLevel) {
		this.insurance = insurance;
		this.pension = pension;
		this.pto = pto;
		this.signingBonus = signingBonus;
		this.annualBonus = annualBonus;
		this.jobLevel = jobLevel;
	}
	
	// setters
	@Override
	public void setInsurance(Boolean insurance) {
		this.insurance = insurance;
	}
	
	@Override
	public void setPension(Boolean pension) {
		this.pension = pension;
	}
	
	@Override
	public void setPto(Boolean pto) {
		this.pto = pto;
	}
	
	@Override
	public void setSigningBonus(int signingBonus) {
		this.signingBonus = signingBonus;
	}
	
	@Override
	public void setAnnualBonus(int annualBonus) {
		this.annualBonus = annualBonus;
	}
	
	@Override
	public void setJobLevel(int jobLevel) {
		this.jobLevel = jobLevel;
	}
	
	// getters
	public boolean getInsurance() {
		return insurance;
	}
	
	public boolean getPension() {
		return pension;
	}
	
	public boolean getPto() {
		return pto;
	}
	
	public int getSigningBonus() {
		return signingBonus;
	}
	
	public int getAnnualBonus() {
		return annualBonus;
	}
	
	public int getJobLevel() {
		return jobLevel;
	}

	@Override
	public void setLength(int length) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setResumeStrength(int resumeStrength) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCredits(int credits) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFullTimeOpportunity(Boolean fullTimeOpportunity) {
		// TODO Auto-generated method stub
		
	}
}
