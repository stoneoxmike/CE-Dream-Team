<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Home Page</title>
		<style type="text/css">
			#background {
				border-style: solid;
				border-width: 10px;
				border-color: black;
				background-color: #305c54;
				padding:50px;
			}
			h1{
				text-size-adjust: 500%;
				text-align:center;
				color: black;
			}
			.button {
			  float: right;
			  border: solid;
			  color:black;
			  padding: 15px 32px;
			  text-align: center;
			  text-decoration: navajowhite;
			  display: inline-block;
			  font-size: 16px;
			  margin: 4px 2px;
			  cursor: pointer;
			}
			.button1 {background-color: #305c54;} /* Green */
		</style>
	</head>

	<body>
		<div id = "background">
		<h1 id = "h1">CE Dream Team - Job Comparison Website <br> Vin Pagano; Michael Geyer; Brody Hageneder</br></h1>
		</div>
			<div>
			<button class="button button1"; type = "submit" value="logOut">Log Out</button>
			</div>
	</body>
</html>