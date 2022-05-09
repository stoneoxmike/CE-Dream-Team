<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!--More div ids might be needed-->
<!--Info input for each job listing -->
<!--Need input for rating each aspect of a job, how important each is to them, and how much they like what each category from each company offers-->

<html>
	<head>
		<title>Information Input</title>
		<style type="text/css">
		
		#background {
				border-style: solid;
				border-width: 10px;
				background-color: #305c54;
				padding:50px;
		}	
		
		#h4 {
				text-align: left;
				text-color: #3c857d;
				font-size: 125%;
		}
		#h5{
				float: right;
		}
		
		h1 {
				text-align:center;
				text-color: #3c857d;
		}
		
	    #textCenter {
				margin-left: auto;
				margin-right: auto;
				align-items: center;
				border-style: solid;
				padding: 10px;
				width: auto;
		}
		#label_2 {
				text-align: left;
				text-color: #3c857d;
				font-size: 125%;
		}
		.button {
			  float: none;
			  border: solid;
			  color:black;
			  padding: 15px 32px;
			  text-align: center;
			  text-decoration: none;
			  display: inline-block;
			  font-size: 16px;
			  margin: 4px 2px;
			  cursor: pointer;
			}
		</style>
	</head>
	
	<body>
	
<!--<h2>JavaScript Alert</h2>  -->

<!-- Script for browser pop-up-->
<script>
function submitFunction() {
  alert("Your form is being submitted. You will now be taken back to the homepage.");
}
</script>

	<!-- Back button and submit takes you back to homepage; no other interaction -->
	<form action="${pageContext.servletContext.contextPath}/home" method="post">
				<button class="button"; type= "Submit" name ="Submit" value="submit">Back</button>
			</form>
	
	<div id = "textCenter">
				<h2 id = "h1"> Information Input: </h2>
				<p class = text>
				<!--Short description of infoInput-->
					 Here is where you can enter your personal information, as well as your ratings for various things a position offers.
					 Please rate these from 0-6, 6 being the most important to you.
					<br> 
				</p>
			</div>
			
			<div>
				<h2 id = "h1"> How much do you value... </h2>

				</p>
			</div>
			
		<!--5 drop-down boxes for information input-->
		<title>DropDown List</title>
		<h5>
			<form>
				<table name = "valueinputs">
					<tr>
						<td class="label_2">Salary:</td>
						<td><input type="text" name="salary" value="" /></td>
					</tr>
					<tr>
						<td class="label_2">Location:</td>
						<td><input type="text" name="location" value="" /></td>
					</tr>
					<tr>
						<td class="label_2">Housing Stipend Amount:</td>
						<td><input type="text" name="housingStipend" value="" /></td>
					</tr>
					<tr>
						<td class="label_2">Time to Commute: </td>
						<td><input type="text" name="commuteTime" value="" /></td>
					</tr>
					<tr>
						<td class="label_2">Remote work:</td>
						<form>
							<select name = "remote">
								<option value = "false" selected>False</option>
								<option value = "true">True</option>
							</select>
						</form>
					</tr>
				</table>
			</form>
			</h5>
		<h4>Size</h4>
			<form>
			<select id = "ddSize">
				<option value = "0" selected>Not a factor</option>
				<option value = "1">Not Important</option>
				<option value = "2">Somewhat Important</option>
				<option value = "3">Neutral</option>
				<option value = "4">Mildly Important</option>
				<option value = "5">Nice to have</option>
				<option value = "6">Deciding Factor</option>
			</select>
		</form>
		<h4>Age</h4>
			<form>
			<select id = "ddAge">
            	<option value = "0" selected>Not a factor</option>
				<option value = "1">Not Important</option>
				<option value = "2">Somewhat Important</option>
				<option value = "3">Neutral</option>
				<option value = "4">Mildly Important</option>
				<option value = "5">Nice to have</option>
				<option value = "6">Deciding Factor</option>
			</select>
		</form>
		<h4>Culture</h4>
			<form>
			<select id = "ddCulture">
                <option value = "0" selected>Not a factor</option>
				<option value = "1">Not Important</option>
				<option value = "2">Somewhat Important</option>
				<option value = "3">Neutral</option>
				<option value = "4">Mildly Important</option>
				<option value = "5">Nice to have</option>
				<option value = "6">Deciding Factor</option>
			</select>
		</form>
		<h4>Opportunity</h4>
			<form>
			<select id = "ddOpportunity">
			    <option value = "0" selected>Not a factor</option>
				<option value = "1">Not Important</option>
				<option value = "2">Somewhat Important</option>
				<option value = "3">Neutral</option>
				<option value = "4">Mildly Important</option>
				<option value = "5">Nice to have</option>
				<option value = "6">Deciding Factor</option>
			</select>
		</form>
		<h4>Work-Life Balance</h4>
			<form>
			<select id = "ddWLBalance">
				<option value = "0" selected>Not a factor</option>
				<option value = "1">Not Important</option>
				<option value = "2">Somewhat Important</option>
				<option value = "3">Neutral</option>
				<option value = "4">Mildly Important</option>
				<option value = "5">Nice to have</option>
				<option value = "6">Deciding Factor</option>
			</select>
		</form>
		<h4>Salary</h4>
			<form>
			<select id = "ddSalary">
		        <option value = "0" selected>Not a factor</option>
				<option value = "1">Not Important</option>
				<option value = "2">Somewhat Important</option>
				<option value = "3">Neutral</option>
				<option value = "4">Mildly Important</option>
				<option value = "5">Nice to have</option>
				<option value = "6">Deciding Factor</option>
			</select>
		</form>
<!--Submit button w/submission in progress popup -->
		<br>
		<form action="${pageContext.servletContext.contextPath}/home" method="post">
				<button onclick="submitFunction()"; class="button"; type= "Submit" name ="Submit" value="submit" >Submit</button>
			</form>
	</body>
	
<script>

var Sizew = document.getElementById("ddSize").value; 
var Agew = document.getElementById("ddAge").value; 
var Culturew = document.getElementById("ddCulture").value; 
var Opportunityw = document.getElementById("ddOpportunity").value; 
var Balancew = document.getElementById("ddBalance").value; 
var Salaryw = document.getElementById("ddSalary").value; 

</script>
</html>