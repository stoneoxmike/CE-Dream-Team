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
			#textCenter {
				margin-left: auto;
				margin-right: auto;
				align-items: center;
				border-style: dotted;
				padding: 20px;
				width: auto;
			}
			#photo {
				image-rendering: auto;
				image-rendering: crisp-edges;
				image-resolution: from-image;
				/*trying to center inage*/
				margin-left: auto;
  				margin-right: auto;
  				width: 75%; 
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
			.text{
				color: black;
				block-size: 150px;
			}
			.button1 {background-color: palegoldenrod;} /* pinkish */
			.photo1 {
				width: 35%;
				height: 30%;
				align-items: center;
			}
		</style>
	</head>

	<body>
		<div id = "background">
		<h1 id = "h1">CE Dream Team - Job Comparison Website <br> Vin Pagano; Michael Geyer; Brody Hageneder</br></h1>
		</div>
		<form action="${pageContext.servletContext.contextPath}/home" method="post">
			<div id = "bannerRight">
			<button class="button button1"; type = "Submit" name="value" value ="logOut">Log Out</button>
			<br>
			<button class="button button1"; type = "Submit" name="value" value = "Profile">Profile</button>
			</br>
			<button class="button button1"; type = "Submit" name="value" value="Job Comparison">Job Comparison</button>
			<br>
			<button class="button button1"; type = "Submit" name="value" value="Info Input">Info Input</button>
			</br>
			</div>
		</form>
			<div id = "textCenter">
				<h2 id = "h1"> What to do next: </h2>
				<p class = text>
					This is the current home view. From this page you are able to access your profile page, info input page, and compare current input jobs with the
					buttons on the right. You are also able to leave securely using the <i>Log Out</i> button also located on the right.<br> </br> If this is your first 
					time accessing this webpage, please configure your first job comparison page. To do this, click on the <i>Info Input</i> button and proceed through the questionaire.
					After completing the questions with the correct information, click submit and proceed to your profile page to ensure it was recorded correctly.
					Complete a second job input and compare the two using the <i>Job Comparison</i> button. 
					<br> </br>
				</p>
			</div>
			<div> <br> </br> </div>
			<img src = "Job_1.png" alt = "Cool Job Photo" class = "photo photo1">
	</body>
</html>