<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

	<head>
		<title>User Info</title>
		<link href="indexstyle.css" rel="stylesheet" type="text/css" ></link>
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
					<li><a href="${pageContext.servletContext.contextPath}/userInfo">User Info</a></li>
				</ul>
			</div>
			<div>
				<c>
					<li>Username is: ${user.username}</li><br />
					<li>Password is: ${user.password}</li><br />
				</c>
				<c:forEach items="${userlist}" var="post">
			        	Game is: ${post.game}
			        	Type is: ${post.buy}
			        	Platform is: ${post.platform}
			        	Message is: ${post.message}
			        	userid is: ${post.userId}
			        	postid is: ${post.postId}
			        	<form action="${pageContext.servletContext.contextPath}/userInfo" method="post">
							<br>Click here to view info about a new post</br>
							<input name="game" type="text" value="${post.game}" hidden />
							<input name="type" type="text" value="${post.buy}" hidden />
							<input name="platform" type="text" value="${post.platform}" hidden />
							<input name="post" type="submit" value="Create"/>
						</form>
						<form action="${pageContext.servletContext.contextPath}/userInfo" method="post">
							<br>Click here to delete this post</br>
							<input name="postID" type="text" value="${post.postId}" hidden />
							<input name="post" type="submit" value="Delete"/>
						</form>		
						<br />	            
				</c:forEach>
			</div>
		</div>
		
		<c>
			game selected is: ${gameselected}
		</c>
	</body>
	
</html>