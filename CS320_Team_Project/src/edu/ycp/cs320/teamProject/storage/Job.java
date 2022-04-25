package edu.ycp.cs320.teamProject.storage;

public class Job {
		//intial fields
		private int jobID;
		private String jobName;
		private Double salary;
		private String location;
		private int housingStipend;
		private Double commuteTime;
		private boolean remote;
		
		//categories fields
		//assorted smallest to biggest etc
		private int size;
		private int age;
		private int culture;
		private int opportunity;
		private int workLifeBalance;
		
		//ranking of weights fields
		//importantance of weights
		//rank 1-6 || 6 is highest
		private int sizeWeight;
		private int ageWeight;
		private int cultureWeight;
		private int opportunityWeight;
		private int workLifeBalanceWeight;
		private int salaryWeight;
		//
		
		
		//constructor for testing rating
//		public Job(int sizeWeight, int ageWeight, int cultureWeight, int opportunityWeight, int workLifeBalanceWeight, int salaryWeight)
//		{
//			//test variables
//			this.sizeWeight = sizeWeight;
//			this.ageWeight = ageWeight;
//			this.cultureWeight = cultureWeight;
//			this.opportunityWeight = opportunityWeight;
//			this.workLifeBalanceWeight = workLifeBalanceWeight;
//			this.salaryWeight = salaryWeight;
//		}
//		
//		//general constructor
		public Job()
		{
			
		}
		
		//total rating out of 6
		public Double getRating()
		{
			//temporary variable
			double rating;
			int temp = sizeWeight + ageWeight + cultureWeight + opportunityWeight + workLifeBalanceWeight + salaryWeight;
			//divide by 36 because it is the highest possible rating 
			//which allows us to keep it as a baseline
			//then multiply by the amount of ratings (6) to get the averaged rating for the job
			
			//gets the double rating
			rating = ((double)temp)/36.0; 
			
			//multiply rating by a scale of 6.0
			rating = rating * 6.0;
			
			//create temporary variables
			double firstTemp;
			double secondTemp;
			double thirdTemp;
			int tempOne;
			int tempTwo;
			//this is where its about to get messy
			//because the rating sometimes doesn't round correctly
			//and won't pass the unit tests. As such
			//I wrote the program below to correctly round the rating
			
			//turn rating into an integer
			tempOne = (int)rating;
			//subtract the double rating by the integer rating to get the remaining decimals (tenths place)
			firstTemp = rating - tempOne;
			//turn the decimal into a whole number
			secondTemp = firstTemp * 10;
			//turn that double into an integer
			thirdTemp = (int)secondTemp;
			//subtract the double by the integer to get the hundreth's place
			firstTemp = secondTemp - thirdTemp;
			//turn that decimal into a whole number and get its integer
			tempTwo = (int)(firstTemp*10);
			//logic check to round up or down correctly
			if (tempTwo >= 5)
			{
				tempTwo = 1;
			}
			else 
			{
				tempTwo = 0;
			}
			//add the integer number with the correct rounding of 1 or 0
			secondTemp = (int)secondTemp + tempTwo;
			//divide by ten to return the whole number to a decimal in the tenths place
			secondTemp = secondTemp/10;
			//return this value to rating by adding the double value of the original
			//integer rating with the new correct rounding 
			rating = (double)tempOne + secondTemp;
			//return rating
			return rating;
			
		}
		
		public void setJobID(int jobID)
		{
			this.jobID = jobID;
		}
		public void setJobName(String jobName)
		{
			this.jobName = jobName;
		}
		public void setHousingStipend(int housingStipend)
		{
			this.housingStipend = housingStipend;
		}
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
		
		public void setSizeWeight(int sizeWeight)
		{
			this.sizeWeight = sizeWeight;
		}
		
		public void setAgeWeight(int ageWeight)
		{
			this.ageWeight = ageWeight;
		}
		
		public void setCultureWeight(int cultureWeight)
		{
			
		}
		
		public void setOpportunityWeight(int opportunityWeight)
		{
			this.opportunityWeight = opportunityWeight;
		}
		
		public void setWorkLifeBalanceWeight(int workLifeBalanceWeight)
		{
			this.workLifeBalanceWeight = workLifeBalanceWeight;
		}
		
		public void setSalaryWeight(int salaryWeight)
		{
			this.salaryWeight = salaryWeight;
		}
		// getters
		public int getJobID()
		{
			return jobID;
		}
		public String getJobName()
		{
			return jobName;
		}
		public int getHousingStipend()
		{
			return housingStipend;
		}
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
		
		public Integer getSizeWeight()
		{
			return sizeWeight;
		}
		
		public Integer getAgeWeight()
		{
			return ageWeight;
		}
		
		public Integer getCultureWeight()
		{
			return cultureWeight;
		}
		
		public Integer getOpportunityWeight()
		{
			return opportunityWeight;
		}
		
		public Integer getWorkLifeBalanceWeight()
		{
			return workLifeBalanceWeight;
		}
		
		public Integer getSalaryWeight()
		{
			return salaryWeight;
		}

		private boolean insurance;
		private boolean pension;
		private boolean pto;
		private int signingBonus;
		private int annualBonus;
		private int jobLevel;
		private int length;
		private int resumeStrength;
		private double credits;
		private boolean fullTimeOpportunity;
		
		public void setInsurance(Boolean insurance)
		{
			this.insurance = insurance;
		}

		public void setPension(Boolean pension)
		{
			this.pension = pension;
		}

		public void setPto(Boolean pto)
		{
			this.pto = pto;
		}

		public void setSigningBonus(int signingBonus)
		{
			this.signingBonus = signingBonus;
		}
		
		public  void setAnnualBonus(int annualBonus)
		{
			this.annualBonus = annualBonus;
		}

		public  void setJobLevel(int jobLevel)
		{
			this.jobLevel = jobLevel;
		}

		public  void setLength(int length)
		{
			this.length = length;
		}

		public  void setResumeStrength(int resumeStrength)
		{
			this.resumeStrength = resumeStrength;
		}

		public void setCredits(double credits)
		{
			this.credits = credits;
		}

		public void setFullTimeOpportunity(Boolean fullTimeOpportunity)
		{
			this.fullTimeOpportunity = fullTimeOpportunity;
		}
		
		
}
