package edu.ycp.cs320.teamProject.model;

// model class for GuessingGame
// only the controller should be allowed to call the set methods
// the JSP will call the "get" and "is" methods implicitly
// when the JSP specifies game.min, that gets converted to
//    a call to model.getMin()
// when the JSP specifies if(game.done), that gets converted to
//    a call to model.isDone()
public class InfoInput {
	private double salary;
	private double signingBonus;
	private double annualBonus;
	private String location;
	private double commuteTime;
	private boolean remote;
	private boolean insurance;
	// rate these out of 5
	private int size;
	private int age;
	private int stability;
	private int culture;
	private int opportunity;
	private int workLifeBalance;
	
	public InfoInput() {
	}
	
	// setters
	
	// getters
}
