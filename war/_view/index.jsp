<!DOCTYPE html>

<html>
	<head>
		<title>Index view</title>
		<link href="indexstyle.css" rel="stylesheet" type="text/css" ></link>
	</head>

	<body>
		<form action="${pageContext.servletContext.contextPath}/login" method="get">
			<input type="submit" name="submit" value="Login">
		</form>
		<form action="${pageContext.servletContext.contextPath}/register" method="get">
			<input type="submit" name="submit" value="Register">
		</form>	
		
	<form action = "${pageContext.servletContext.contextPath}/listings" method="post">
		<select name = "platform">
		  <option value="platform1">platform</option>
		  <option value="platform2">2</option>
		  <option value="platform3">3</option>
		  <option value="platform4">4</option>
		</select>
	
		<select id = "game">
		  <option value="game1">game</option>
		  <option value="game2">2</option>
		  <option value="game3">3</option>
		  <option value="game4">4</option>
		</select>
		<select name = "type">
		  <option value="type1">trade/buy</option>
		  <option value="type2">2</option>
		  <option value="type3">3</option>
		  <option value="type4">4</option>
		</select>
		<input name = "submit" type="submit" value="Listings" />		
	</form>
		
			
		<form action="${pageContext.servletContext.contextPath}/logout" method="post">
			<input type="submit" name="logout" value="Logout">
		</form>
		
		<form action="${pageContext.servletContext.contextPath}/chat" method="get">
			<input type="submit" name="chat" value="Chat">
		</form>
		
		
		Temporarily show the username and password
		<br />
		Username is ${user.username}
		<br />
		Password is ${user.password}

	</body>
</html>
