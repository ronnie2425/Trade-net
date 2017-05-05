<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Create Post</title>
		<link href="listingstyle.css" rel="stylesheet" type="text/css" ></link>
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
		<div id = "wrapper">
			Please select a platform, game, and trade method:
			<form action="${pageContext.servletContext.contextPath}/post" method="post">	
				<select name="platform">
					 <option value="null">Platform</option>
					 <option value="PC">PC</option>
					 <option value="PS3">PS3</option>
					 <option value="PS4">PS4</option>
					 <option value="Xbox 360">Xbox 360</option>
					 <option value="Xbox one">Xbox One</option>
				</select>
					
				<select name="game">
				  <option value="null">Game</option>
				  <option value="CS:GO">CS:GO</option>
				  <option value="Counter Strike:GO">Counter Strike:GO</option>
				  <option value="CS:Global Offensive">CS:Global Offensive</option>
				  <option value="C Strike:Global O">C Strike:Global O</option>
				  <option value="DotA 2">DotA 2</option>
				</select>
				
				<select name="type">
				  <option value="null">Buy/Sell</option>
				  <option value="buy">Buy</option>
				  <option value="sell">Sell</option>
				  <option value="trade">Trade</option>
				</select>
				
				<br>Put your message here</br>
				<input name ="message" type="text"/>
				
				<input name ="submit" type ="submit" value="Create Post"/>				
			</form>
		</div>
		<br />
		<br />
		<br />
		<br />
		
	</body>
</html>
	