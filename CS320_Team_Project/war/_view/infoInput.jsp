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
		</style>
	</head>
	
	<body>
	
	<div id = "background">
		<h1 id = "h1">CE Dream Team - Job Comparison Website <br> Vin Pagano; Michael Geyer; Brody Hageneder</br></h1>
	</div>
		
	<div>
		
	</div>
		<form action="${pageContext.servletContext.contextPath}/infoInput" method="post">
			<c:if test="${empty game}">
				<input name="startGame" type="submit" value="Start game" />
			</c:if>
			<c:if test="${! empty game}">
				<c:if test="${game.done}">
					<div>
						The number you are thinking of is ${game.guess}
					</div>
					<div>
						<input name="startGame" type="submit" value="Play again" />
					</div>
					<div>						
						<input name="min" type="hidden" value="${game.min}" />
						<input name="max" type="hidden" value="${game.max}" />
					</div>
				</c:if>
			</c:if>
		</form>
	</body>
</html>