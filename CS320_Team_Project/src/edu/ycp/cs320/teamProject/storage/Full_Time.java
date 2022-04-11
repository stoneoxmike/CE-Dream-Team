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
	public void setInsurance(boolean insurance) {
		this.insurance = insurance;
	}
	
	public void setPension(boolean pension) {
		this.pension = pension;
	}
	
	public void setPto(boolean pto) {
		this.pto = pto;
	}
	
	public void setSigningBonus(int signingBonus) {
		this.signingBonus = signingBonus;
	}
	
	public void setAnnulBonus(int annualBonus) {
		this.annualBonus = annualBonus;
	}
	
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
}
