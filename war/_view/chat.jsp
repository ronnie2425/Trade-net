<!DOCTYPE HTML>
<html>
	<head>
		<title>
		Chat
		</title>
	<link type="text/css" rel="stylesheet" href="ChatStyle.css" />
	</head>
	
	<div id="background">
		
		<div id="chatwindow"></div>
		
		<form action="${pageContext.servletContext.contextPath}/chat" method="post" >
			<input name = "userinput" type = "text" id = "userinput" size = "64">
			<input name = "sendmsg" type = "submit" id = "sendmsg" value = "Send Message">
		</form>
	</div>
</html>
