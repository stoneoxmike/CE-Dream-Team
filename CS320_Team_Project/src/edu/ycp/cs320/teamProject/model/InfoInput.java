package edu.ycp.cs320.teamProject.model;

// model class for GuessingGame
// only the controller should be allowed to call the set methods
// the JSP will call the "get" and "is" methods implicitly
// when the JSP specifies game.min, that gets converted to
//    a call to model.getMin()
// when the JSP specifies if(game.done), that gets converted to
//    a call to model.isDone()
public class InfoInput {
	private Double salary;
	private String location;
	private Double commuteTime;
	private Boolean remote;
	private Boolean insurance;
	// rate these out of 5
	private Integer size;
	private Integer age;
	private Integer culture;
	private Integer opportunity;
	private Integer workLifeBalance;
	// weights
	private Integer sizeWeight;
	private Integer ageWeight;
	private Integer cultureWeight;
	private Integer opportunityWeight;
	private Integer workLifeBalanceWeight;
	private Integer salaryWeight;
	
	public InfoInput() {
		
	}
	
	// setters
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setCommuteTime(Double commuteTime) {
		this.commuteTime = commuteTime;
	}
	
	public void setRemote(Boolean remote) {
		this.remote = remote;
	}
	
	public void setInsurance(Boolean insurance) {
		this.insurance = insurance;
	}
	
	public void setSize(Integer size) {
		this.size = size;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public void setCulture(Integer culture) {
		this.culture = culture;
	}
	
	public void setOpportunity(Integer opportunity) {
		this.opportunity = opportunity;
	}
	
	public void setWorkLifeBalance(Integer workLifeBalance) {
		this.workLifeBalance = workLifeBalance;
	}
	// getters
	public Double getSalary() {
		return salary;
	}
	
	public String getLocation() {
		return location;
	}
	
	public Double getCommuteTime() {
		return commuteTime;
	}
	
	public Boolean getRemote() {
		return remote;
	}
	
	public Boolean getInsurance() {
		return insurance;
	}
	
	public Integer getSize() {
		return size;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public Integer getCulture() {
		return culture;
	}
	
	public Integer getOpportunity() {
		return opportunity;
	}
	
	public Integer getWorkLifeBalance() {
		return workLifeBalance;
	}
}
