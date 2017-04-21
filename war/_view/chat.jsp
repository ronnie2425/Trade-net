<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
		<div id="chatwindow">
			<c:forEach items="${messages}" var="message">
			        	${message}
			        	<br></br>		            
			    </c:forEach>
		</div>
		
		<form action="${pageContext.servletContext.contextPath}/chat" method="post" >
			<div id="wrapper">
				<input name = "userinput" type = "text" id = "userinput" size = "64">
				<input name = "sendmsg" type = "submit" id = "sendmsg" value = "Send Message">
			</div>
		</form>
	</div>
</body>
</html>