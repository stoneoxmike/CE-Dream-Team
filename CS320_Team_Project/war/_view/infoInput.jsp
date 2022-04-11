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
	
<h2>JavaScript Alert</h2>

<!-- Script for browser pop-up-->
<script>
function submitFunction() {
  alert("Form submitted successfully!");
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
	</head>
		<h4>Size</h4>
			<form>
			<select name = "ddSize">
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
			<select name = "ddAge">
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
			<select name = "ddCulture">
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
			<select name = "ddOpportunity">
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
			<select name = "ddWLBalance">
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
			<select name = "ddSalary">
		        <option value = "0" selected>Not a factor</option>
				<option value = "1">Not Important</option>
				<option value = "2">Somewhat Important</option>
				<option value = "3">Neutral</option>
				<option value = "4">Mildly Important</option>
				<option value = "5">Nice to have</option>
				<option value = "6">Deciding Factor</option>
			</select>
		</form>
<!--Submit button w/successful submission popup; want this to appear once homePage is posted -->
		<br>
		<form action="${pageContext.servletContext.contextPath}/home" method="post">
				<button onclick="submitFunction()"; class="button"; type= "Submit" name ="Submit" value="submit" >Submit</button>
			</form>
	</body>
</html>