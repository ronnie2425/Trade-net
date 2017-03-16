<!DOCTYPE HTML>

<html>
	<head>
		<title>Register</title>
	</head>
	
	<body>
		<form action="${pageContext.servletContext.contextPath}/register" method="post">
		
		<table>
			<tr>
				<td class="username">Username:</td>
				<td><input type="text" name="Username" value="" /></td>
			</tr>
			
			<tr>
				<td class="password">Password:</td>
				<td><input type="text" name="Password" value="" /></td>
			</tr>

			<tr>
				<td class="password">Re enter Password:</td>
				<td><input type="text" name="Password2" value="" /></td>
			</tr>
			
		</table>
		
		<input name ="submit" type ="submit" name ="submit" />
		</form>
		
	</body>
		
	

</html>