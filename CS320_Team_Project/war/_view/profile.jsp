<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!-- place to see jobs we have compared; no comparison happens here-->

<html>
	<head>
		<title>Profile</title>
	<style type="text/css">
	
	#background {
				border-style: solid;
				border-width: 10px;
				background-color: #305c54;
				padding:50px;
				text-align: center;
	}	
	#textCenter {
				margin-left: auto;
				margin-right: auto;
				align-items: center;
				border-style: dotted;
				padding: 20px;
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
	img{
		border: solid;
		color: black; 
		float: center; 
	}
	
	</style>
	</head>
	
	<body>
	
	<form action="${pageContext.servletContext.contextPath}/home" method="post">
	<button class="button" type = "Submit" name="value" value="back">Back</button>
	</form>
	<br>
	<div id= "textCenter">
	Welcome to your profile! This is where compared jobs will be stored. 
		</div>
	<div>
	<br>
	<br>
	<img src="Profile Pic.png" width="200" height="200">
		
	</div>
	
	<br>
	<br>
	<div id= "textCenter">
	Welcome to your profile! This is where compared jobs will be stored. 
		</div>
		
	</body>

</html>