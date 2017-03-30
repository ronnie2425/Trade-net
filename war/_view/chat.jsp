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
		
		<div id="chatwindow"></div>
		
		<form action="${pageContext.servletContext.contextPath}/chat" method="post" >
			<input name = "userinput" type = "text" id = "userinput" size = "64">
			<input name = "sendmsg" type = "submit" id = "sendmsg" value = "Send Message">
		</form>
	</div>
</body>
</html>
