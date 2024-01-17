<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Đăng Nhập</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
	<div class="main">
		<div class="container">
			<div class="signin-content">
				<form class="signin-image" action="RegisterForward" method="post">
					<figure>
						<img src="images/signin-image.png" alt="sing up image">
					</figure>
					<input type="submit" class="signup-image-link"
						value="Create an account"
						style="background: #fff; cursor: pointer;">
				</form>

				<div class="signin-form">
					<h2 class="form-title">Login</h2>
					<h3><%=request.getAttribute("msg") != null ? request.getAttribute("msg") : ""%></h3>
					<form method="POST" class="register-form" id="login-form"
						action="LoginController">
						<div class="form-group">
							<label for="your_name"><i class="fa-solid fa-user"></i></label> <input
								type="text" name="your_name" id="your_name" autocomplete="off"
								placeholder="Your Name" required="required" />
						</div>
						<div class="form-group">
							<label for="your_pass"><i class="fa-regular fa-envelope"></i></label>
							<input type="password" name="your_pass" id="your_pass"
								autocomplete="off" placeholder="Password" required="required" />
						</div>
						<div class="form-group form-button">
							<input type="submit" name="signin" id="signin"
								class="form-submit" value="Log in" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>
        <% Object msgAttribute = request.getAttribute("msg");
	        if (msgAttribute != null && msgAttribute.equals("Đăng Nhập Thành Công")) { %>
	        setTimeout(function () {
	            window.location.href = "HomeForward";
	        }, 700);
   		 <% }%>
	</script>
</body>
</html>