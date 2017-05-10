<!DOCTYPE HTML>

<html>
	<head>
		<title>Register</title>
		<link href="registerstyle.css" rel="stylesheet" type="text/css" ></link>
	</head>
	
<body>
	<div id="background">
	<div class="navbar">
		<ul>
			<li><img src = "MSM Trading Network Logo.png" alt= "MSM logo" style="width:75px;height:75px;">
			<li><a href="${pageContext.servletContext.contextPath}/index">Home</a></li>
			<li><a href="${pageContext.servletContext.contextPath}/login">Log in</a></li>
			<li><a href="${pageContext.servletContext.contextPath}/register">Register</a></li>
			<li><a href="${pageContext.servletContext.contextPath}/listings">Trade</a></li>
			<li><a href="${pageContext.servletContext.contextPath}/logout">Logout</a></li>
			<li><a href="${pageContext.servletContext.contextPath}/userInfo">User Info</a></li>


		</ul>
	</div>	
		<form action="${pageContext.servletContext.contextPath}/register" method="post">
		
		Create a new MSM account:
		<table>
			<tr>
				<td class="username">Username:</td>
				<td><input type="text" name="Username" value="" /></td>
			</tr>
			
			<tr>
				<td class="password">Password:</td>
				<td><input type="password" name="Password" value="" /></td>
			</tr>

			<tr>
				<td class="password">Re enter Password:</td>
				<td><input type="password" name="Password2" value="" /></td>
			</tr>
			
		</table>
		
		<input name ="submit" type ="submit" name ="submit" />
		</form>
	</div>
</body>
		
		${error}
		
	

</html>
