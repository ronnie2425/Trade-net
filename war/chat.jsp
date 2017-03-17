<!DOCTYPE HTML>
 
 <html>
 	<head>
 		<title>
 		Chat
 		</title>
 	</head>
 	
 	<body>
 		<form action="${pageContext.servletContext.contextPath}/chat" method="post" >
 		
 		<p>
 			<label> Chat box </label>
 			<textarea>please type your words here, thanks</textarea>
 		</p>
 		<input type = "submit" value = "Send Message">
 		</form>
 	</body>
 </html> 