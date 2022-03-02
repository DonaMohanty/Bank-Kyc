<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet" href="css/stylelogin.css">
</head>
<body>
	<header>
		<strong> ABC BANK</strong>
	</header>
	<div class="container">
		<h1 class="label">  SIGN IN</h1>
		<form class="login_form" action="login" method="post" name="form" onsubmit="return validated()">
			<div class="font">Username</div>
			<input autocomplete="off" type="text" name="username">
			<div id="username_error">Please fill up your Username</div>
			<div class="font font2">Password</div>
			<input type="password" name="password">
			<div id="password_error">Please fill up your Password</div>
			<button type="submit">Login</button>
		</form>
	</div>	
	<script src="js/validlogin.js"></script>
</body>
</html>