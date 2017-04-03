<!DOCTYPE html>
<html>
	<head>
		<title>
		MSM Chat Room
		</title>
	<link href="chatstyle.css" rel="stylesheet" type="text/css" ></link>
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
			<li><a href="${pageContext.servletContext.contextPath}/chat">Chat</a></li>
			<li><a href="${pageContext.servletContext.contextPath}/logout">Logout</a></li>
			
		</ul>
	</div>	
		<div id="chatwindow"></div>
		
		<form action="${pageContext.servletContext.contextPath}/chat" method="post" >
			<input name = "userinput" type = "text" id = "userinput" size = "64">
			<input name = "sendmsg" type = "submit" id = "sendmsg" value = "Send Message">

		<!--
		<p>
			<label> Chat box </label>
			<textarea name="text">please type your words here, thanks</textarea>
		</p>
		<input type = "submit" name = "submit" value = "Send Message">
		-->
		
		</form>
	</div>
</body>
</html>
