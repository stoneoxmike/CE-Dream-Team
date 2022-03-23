<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Information Input</title>
		<style type="text/css">
		#background {
				border-style: solid;
				border-width: 10px;
				border-color: black;
				background-color: #305c54;
				padding:50px;
			}	
			#label_2 {
			text-align: left;
			text-color: #3c857d;
			font-size: 125%;
		}
		
	    #textCenter {
				margin-left: auto;
				margin-right: auto;
				align-items: center;
				border-style: solid;
				padding: 10px;
				width: auto;
			}
		</style>
	</head>
	
	<body>
    
	<div id = "background">
		<h1 id = "h1">CE Dream Team - Job Comparison Website <br> Vin Pagano; Michael Geyer; Brody Hageneder</br></h1>
	</div>
	
	<div id = "textCenter">
				<h2 id = "h1"> Information Input: </h2>
				<p class = text>
					 Here is where you can enter your personal information, as well as your ratings for various things a position offers.
					 Please rate these from 0-6, 6 being the most important to you.
					<br> 
				</p>
			</div>
		<!--5 entry boxes for information input; none are functional currently-->
		<form action="${pageContext.servletContext.contextPath}/home" method="post">
					<table>
					<tr>
						<td class="label_2">Rating1:</td>
						<td><input type="text" name="r1" value="" /></td>
					</tr>
					<tr>
						<td class="label_2">Rating2:</td>
						<td><input type="text" name="r2" value="" /></td>
					</tr>
					<tr>
						<td class="label_2">Rating3:</td>
						<td><input type="text" name="r3" value="" /></td>
					</tr>
					<tr>
						<td class="label_2">Rating4:</td>
						<td><input type="text" name="r4" value="" /></td>
					</tr>
					<tr>
						<td class="label_2">Rating5:</td>
						<td><input type="text" name="r5" value="" /></td>
					</tr>
				</table>
				<br>
				<button class="button button1"; type= "Submit" name ="value" value="submit">Submit</button>
				</form>
				
	
	
	
	

	</body>
</html>