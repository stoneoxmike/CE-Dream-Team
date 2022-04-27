<!DOCTYPE html>
<html>
	<head>
		<title> Login </title>
	</head>
	<style type = "text/css">
	
		#LoginBox 
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
		#label_2 {
			text-align: left;
			text-color: #3c857d;
			font-size: 125%;
		}
		#label_3 {
			float: center;
			text-align: center;
			text-color: #3c857d;
			font-size: 150%;
			background-color: #305c54;
		}
		#Submit{
		text-align: center;
		}
	</style>
	
<!-- Script for password hiding-->
<script>
function pwShowFunction() {
	  var x = document.getElementById("pw");
	  if (x.type === "password") {
	    x.type = "text";
	  } else {
	    x.type = "password";
	  }
}
</script>
<body>
		<div id = "LoginBox">
			<h1 class = "h1"> Welcome! </h1>
				<p id = "label"> Please login with your username and password. <br> <i>If you haven't already, create an account with the link below </i></br> </p>
				<form action="${pageContext.servletContext.contextPath}/login" method="post">
					<table>
					<tr>
						<td class="label_2">Username:</td>
						<td><input type="text" name="username" value="" /></td>
					</tr>
					<tr>
						<td class="label_2">Password:</td>
						<td><input type="password" name="password" value="" id="pw"/>
						</td>
					</tr>
				</table>
					<input type="checkbox" onclick="pwShowFunction()">Show Password
				
				
					<div id = "Submit">
							<input type="Submit" name="" value="Contnue" id = "label_3">
					</div>
				</form>
				<form action="${pageContext.servletContext.contextPath}/signUp" method="get">
				<div id = "signUpButton">
					<input type ="button" name ="signUp" value = "Sign-Up Here" id ="label_3">
				</div>
				</form>
				<c:if test="${! empty errorMessage}">
					<div class="error">${errorMessage}</div>
				</c:if>
		</div>
	</body>
</html>