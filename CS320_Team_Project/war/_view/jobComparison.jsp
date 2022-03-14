<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Home Page</title>
		<style type="text/css">
			#BorderBox 
		{
			float: center;
			border-style: solid;
			border-width: 5px;
			width:600px;
			margin: auto;
			margin-top: 200px;
			padding: 15px;
			background-color: #4c9484;
			border-color: #b8b9c0;
		}
		h1 {
			text-align:center;
			text-color: #3c857d;
		}
		#label {
			text-align: center;
			text-color: #3c857d
		}
		.dropbtn {
			background-color: #b9b9b9e3;
			color: white;
			padding: 16px;
			font-size: 16px;
			border: none;
			}

			/* The container <div> - needed to position the dropdown content */
			.dropdown {
			position: center;
			display: inline-block;
			}

			/* Dropdown Content (Hidden by Default) */
			.dropdown-content {
			display: none;
			position: absolute;
			background-color: #f1f1f1;
			min-width: 160px;
			box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
			z-index: 1;
			}

			/* Links inside the dropdown */
			.dropdown-content a {
			color: black;
			padding: 12px 16px;
			text-decoration: none;
			display: block;
			}

			/* Change color of dropdown links on hover */
			.dropdown-content a:hover {background-color: #ddd;}

			/* Show the dropdown menu on hover */
			.dropdown:hover .dropdown-content {display: block;}

			/* Change the background color of the dropdown button when the dropdown content is shown */
			.dropdown:hover .dropbtn {background-color: #000000b7;}

			.dropbtn_1 {
				float: left;
			}
			.dropbtn_2 {
				float: right;
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
		<form action="${pageContext.servletContext.contextPath}/home" method="post">
			<div id = "bannerRight">
			<button class="button" type = "Submit" name="value" value="back">Back</button>
			</div>
		</form>
		<div id = "BorderBox">
			<h1 class = "h1"> This is the Job Comparison Webpage</h1>
				<p id = "label">This is where it would nicely display the current chosen job application <br>as well as the additional job it would be compared to
				if applicable</br></p>
				<form action="${pageContext.servletContext.contextPath}/jobComparison" method="post">
					<div class="dropdown">
						<button class="dropbtn dropbtn_1">Dropdown</button>
						<div class="dropdown-content">
						  <a src="Example.png" alt="Example Photo Here">Example Photo</a> 
						  <a src = "JobExample1.png" alt = "First Job Example Photo">First Job Example Photo</a>
						  <a src = "JobExample2.jpg" alt = "Second Job Example Photo">Second Job Example Photo</a>
						</div>
					</div>
					<div class="dropdown">
						<button class="dropbtn dropbtn_2">Dropdown</button>
						<div class="dropdown-content">
						  <a src="Example.png" alt="Example Photo Here">Example Photo</a> 
						  <a src = "JobExample1.png" alt = "First Job Example Photo">First Job Example Photo</a>
						  <a src = "JobExample2.jpg" alt = "Second Job Example Photo">Second Job Example Photo</a>
						</div>
					</div>
				</form>
		</div>
	</body>
</html>