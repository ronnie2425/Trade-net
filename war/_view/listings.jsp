<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Listings</title>
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
		<div style="text-align:center;">
			<form action="${pageContext.servletContext.contextPath}/post" method="get">
			<br>Click here to create a new post</br>
			<input type ="text" name ="text" />
			<input name="post" type="submit" value="Create"/>
			</form>
		</div>
		
		<div id="wrapper">	
			Please select a platform, game, and trade method:
			<form action="${pageContext.servletContext.contextPath}/listings" method="post">
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
				  <option value="3">Counter Strike:GO</option>
				  <option value="4">CS:Global Offensive</option>
				  <option value="5">C Strike:Global O</option>
				  <option value="6">DotA 2</option>
				</select>
				<select name="type">
				  <option value="null">Buy/Sell</option>
				  <option value="buy">Buy</option>
				  <option value="sell">Sell</option>
				  <option value="trade">Trade</option>
				</select>
				<input name ="submit" type ="submit" value="Search"/>
			</form>
		</div>
		<br />
		<div id="listings">
			<c:forEach items="${list}" var="post">
			        	Game is: ${post.game}
			        	Type is: ${post.buy}
			        	Platform is: ${post.platform}
			        	Message is: ${post.message}
			        	userid is: ${post.userId}
			        	postid is: ${post.postId}
			        	<br></br>		            
			</c:forEach>
		</div>
		
	</body>
</html>