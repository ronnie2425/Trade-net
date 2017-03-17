<!DOCTYPE HTML>

<html>
	<head>
		<title>Login</title>
	</head>
	
	<body>
		<form action="${pageContext.servletContext.contextPath}/login" method="post">
	
	 		<table>
  			<tr>
  				<td class="username">Username:</td>

 				<td><input type="text" name="Username" value="" /></td>
 			</tr>
 			
 			<tr>
 				<td class="password">Password:</td>
 				<td><input type="text" name="Password" value="" /></td>
  			</tr>
  		</table>
  		
  		<input name ="submit" type ="submit" name ="submit" />
 		</form>
  	</body>
  
  </html> 