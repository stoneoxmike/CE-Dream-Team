package edu.ycp.cs320.teamProject.storage;

public class Information {
		//intial fields
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
		public Information(int sizeWeight, int ageWeight, int cultureWeight, int opportunityWeight, int workLifeBalanceWeight, int salaryWeight)
		{
			//test variables
			this.sizeWeight = sizeWeight;
			this.ageWeight = ageWeight;
			this.cultureWeight = cultureWeight;
			this.opportunityWeight = opportunityWeight;
			this.workLifeBalanceWeight = workLifeBalanceWeight;
			this.salaryWeight = salaryWeight;
		}
		
		//general constructor
		public Information()
		{
			
		}
		
		//total rating out of 6
		public Double getRating()
		{
			//temporary variable
			double rating;
			//divide by 36 because it is the highest possible rating 
			//which allows us to keep it as a baseline
			//then multiply by the amount of ratings (6) to get the averaged rating for the job
						//size / 36
			rating =  ((((double)sizeWeight/36.0) + ((double)ageWeight/36.0) + ((double)cultureWeight/36.0) + ((double)opportunityWeight/36.0) + ((double)workLifeBalanceWeight/36.0) + ((double)salaryWeight/36.0))*6.0);
			//take rating and change it to a precision of 1 decmial
			System.out.println(rating);
			//return rating
			return rating;
			
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
		// getters
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
		
		
}
