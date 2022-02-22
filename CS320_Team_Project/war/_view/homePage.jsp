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
			#bannerRight {
				border-style: solid;
				border-width: 10px;
				border-color: black;
				width: fit-content;
				background-color: #305c54;
				padding: 25px;
				float: right;
				text-align: center;
			}
			h1{
				text-size-adjust: 500%;
				text-align:center;
				color: black;
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
			.button1 {background-color: palegoldenrod;} /* Green */
		</style>
	</head>

	<body>
		<div id = "background">
		<h1 id = "h1">CE Dream Team - Job Comparison Website <br> Vin Pagano; Michael Geyer; Brody Hageneder</br></h1>
		</div>
			<div id = "bannerRight">
			<button class="button button1"; type = "submit" value="logOut">Log Out</button>
			<br>
			<button class="button button1"; type = "submit" value="Profile">Profile</button>
			</br>
			<button class="button button1"; type = "submit" value="Job Comparison">Job Comparison</button>
			<br>
			<button class="button button1"; type = "submit" value="logOut">Info Page</button>
			</br>
			</div>
	</body>
</html>