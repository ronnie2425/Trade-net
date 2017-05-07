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
			        	<t />Type is: ${post.buy}
			        	<t />Platform is: ${post.platform}
			        	<t />Message is: ${post.message}
			        	<form action="${pageContext.servletContext.contextPath}/chat" method="get">
							<br>Click here to view info about the post</br>
							<input name="game" type="text" value="${post.game}" hidden />
							<input name="type" type="text" value="${post.buy}" hidden />
							<input name="platform" type="text" value="${post.platform}" hidden />
							<input name="postid" type="text" value="${post.postId}" hidden />
							
							<input name="post" type="submit" value="View"/>
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
	</body>
	
</html>