<!DOCTYPE html>

<html>
	<head>
		<title>Index view</title>
	</head>

	<body>
		<form action="${pageContext.servletContext.contextPath}/login" method="get">
			<input type="submit" name="submit" value="Login">
		</form>
		<form action="${pageContext.servletContext.contextPath}/register" method="get">
			<input type="submit" name="submit" value="Register">
		</form>	
		
		
	<select>
	  <option value="1">platform</option>
	  <option value="2">2</option>
	  <option value="3">3</option>
	  <option value="4">4</option>
	</select>
	
	<select>
	  <option value="1">game</option>
	  <option value="2">2</option>
	  <option value="3">3</option>
	  <option value="4">4</option>
	</select>
	<select>
	  <option value="1">trade/buy</option>
	  <option value="2">2</option>
	  <option value="3">3</option>
	  <option value="4">4</option>
	</select>
		
			
		<form action="${pageContext.servletContext.contextPath}/logout" method="post">
			<input type="submit" name="logout" value="Logout">
		</form>
		
		
		Temporarily show the username and password
		<br />
		Username is ${user.username}
		<br />
		Password is ${user.password}

	</body>
</html>
