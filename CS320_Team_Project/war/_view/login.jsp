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
			textl-align: center;
			text-color: #3c857d;
			font-size: 150%;
			background-color: #305c54;
		}
		#Submit{
		text-align: center;
		}
	</style>
		
<body>
		<div id = "LoginBox">
			<h1 class = "h1"> Welcome! </h1>
				<p id = "label"> Please login with your username and password. <br> <i>If you haven't already, create an account with the link below </i></br> </p>
				<form action="${pageContext.servletContext.contextPath}/login" method="get">
					<table>
					<tr>
						<td class="label_2">Username:</td>
						<td><input type="text" name="username" size="auto" value="" /></td>
					</tr>
					<tr>
						<td class="label_2">Password:</td>
						<td><input type="text" name="password" size="auto" value="" /></td>
					</tr>
				</table>
				<div id = "Submit">
				<input type="Submit" name="submit" value="Continue" id="label_3" /></td>
				</div>
				<!link rel="New Account" href=" >
				</form>
		</div>
	</body>
</html>