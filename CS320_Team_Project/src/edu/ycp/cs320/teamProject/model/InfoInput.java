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
	private Double signingBonus;
	private Double annualBonus;
	private String location;
	private Double commuteTime;
	private Boolean remote;
	private Boolean insurance;
	// rate these out of 5
	private Integer size;
	private Integer age;
	private Integer stability;
	private Integer culture;
	private Integer opportunity;
	private Integer workLifeBalance;
	
	public InfoInput() {
		
	}
	
	// setters
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	// getters
}
