<!DOCTYPE HTML>

<html>
	<head>
		<title>
		Chat
		</title>
	</head>
	
	<body>
		Last message: ${text}
	
		<form action="${pageContext.servletContext.contextPath}/chat" method="post" >
		
		<p>
			<label> Chat box </label>
			<textarea name="text">please type your words here, thanks</textarea>
		</p>
		<input type = "submit" name = "submit" value = "Send Message">
		</form>
	</body>
</html>
