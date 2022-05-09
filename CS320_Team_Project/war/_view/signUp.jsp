<!DOCTYPE html>
<html>
	<head>
		<title> Sign Up </title>
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
			text-align:left;
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
	


<body>
		<div id = "LoginBox">
			<h1 class = "h1"> Welcome! </h1>
				<p id = "label"> Please create your new account with using the fields below. </i></br> </p>
				<form action="${pageContext.servletContext.contextPath}/login" method="post">
					<table>
					<tr>
						<td class="label_2">New Username:</td>
						<td><input type="text" name="username" value="" /></td>
					</tr>
					<tr>
						<td class="label_2">New Password:</td>
						<td><input type="text" name="password" value="" id="pw"/>
						</td>
					</tr>
						<td class="label_2">Confirm New Password:</td>
						<td><input type="text" name="password" value="" id="pwconf"/>
						</td>
					</tr>
				</table>
				<br>
			
				<div id = "Submit">
							<input type="Submit" name="" value="Create Account" id = "label_3">
					</div>
				</form>
				<br>
				<form action="${pageContext.servletContext.contextPath}/login" method="post">
	<button class="button" type = "Submit" name="value" value="back">Back</button>
	</form>
				<c:if test="${! empty errorMessage}">
					<div class="error">${errorMessage}</div>
				</c:if>
		</div>
	</body>
</html>