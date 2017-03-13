<!DOCTYPE html>

<html>
	<head>
		<title>Index view</title>
	</head>

	<body>
		<form action="${pageContext.servletContext.contextPath}/addNumbers" method="get">
			<input type="submit" name="submit" value="Add Numbers">
		</form>
		<form action="${pageContext.servletContext.contextPath}/multiplyNumbers" method="get">
			<input type="submit" name="submit" value="Multiply Numbers">
		</form>
		<form action="${pageContext.servletContext.contextPath}/guessingGame" method="get">
			<input type="submit" name="startGame" value="Guessing Game">
		</form>
	</body>
</html>
