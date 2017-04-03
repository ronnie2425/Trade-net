<!DOCTYPE HTML>

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
		<div id="wrapper">	
			Please select a platform, game, and trade method:
			<form action="${pageContext.servletContext.contextPath}/listings" method="post">
				<select>
				  <option value="1">Platform</option>
				  <option value="2">PC</option>
				  <option value="3">PS3</option>
				  <option value="4">PS4</option>
				  <option value="5">Xbox 360</option>
				  <option value="6">Xbox One</option>
				  <option value="7">Half-Life 3</option>
				</select>
				
				<select>
				  <option value="1">Game</option>
				  <option value="2">CS:GO</option>
				  <option value="3">Counter Strike:GO</option>
				  <option value="4">CS:Global Offensive</option>
				  <option value="5">C Strike:Global O</option>
				  <option value="6">DotA 2</option>
				  <option value="7">is</option>
				</select>
				<select>
				  <option value="1">Buy/Sell</option>
				  <option value="2">Buy</option>
				  <option value="3">Sell</option>
				  <option value="4">Trade</option>
				  <option value="5">Confirmed</option>
				</select>
				<input name ="submit" type ="submit" value="Search"/>
			</form>
		</div>
		<div id="listings">
			<span class="listingelem"><li> User Alpha:
			<img src="http://i3.kym-cdn.com/photos/images/newsfeed/001/015/725/eca.png" alt="PEPE" style="width:250px;height:150px;">
			This is where the listing description and things will go</span></li>
			<span class="listingelem"><li> User Omichron:
			<img src="http://s2.quickmeme.com/img/e2/e22f342d9628ce4bda4a7ca60a1ebda510e0c0608b173650ab254d6507d16326.jpg" alt="SMASHING" style="width:250px;height:150px;">
			This is where the listing description and things will go</span></li>
			<span class="listingelem"><li> User Omega:
			<img src="http://www.troll.me/images/overdrive-plankton/maximum-overdrive-thumb.jpg" alt="SMASHING" style="width:250px;height:150px;">
			This is where the listing description and things will go</span></li>
		</div>
	</div>
</body>

</html>