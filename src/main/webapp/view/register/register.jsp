<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/register.css">
<title>Đăng Ký</title>
</head>
<body>
	<div class="main" style="padding-top: 100px">
		<h3 style="color: red; text-align: center;"></h3>
		<!-- Sign up form -->
		<div class="container">
			<div class="signup-content">

				<div class="signup-form">

					<h2 class="form-title">Sign up</h2>

					<form method="POST" class="register-form" id="register-form"
						action="RegisterController" autocomplete="off">
						<div class="form-group">
							<label for="nameuser" style="padding-left: 6px;"><i
								class="fa-regular fa-circle-user"></i></label> <input type="text"
								name="nameuser" id="nameuser" required=""
								placeholder="Tên Của Bạn">
						</div>
						<div class="form-group">
							<label for="username" style="padding-left: 6px;"><i
								class="fa-solid fa-user"></i></label> <input type="text" name="username"
								id="username" required="" placeholder="Tài Khoản">
						</div>
						<div class="form-group">
							<label for="password" style="padding-left: 6px;"><i
								class="fa-solid fa-lock"></i></label> <input type="password"
								name="password" id="password" required="" placeholder="Mật Khẩu">
						</div>
						<div class="form-group">
							<label for="re_password" style="padding-left: 6px;"><i
								class="fa-solid fa-lock"></i></label> <input type="password"
								name="re_password" id="re_password" required=""
								placeholder="Nhập lại mật khẩu">
						</div>
						<div class="form-group">
							<label for="code_market" style="padding-left: 6px;"><i
								class="fa-solid fa-shop"></i></label> <input type="text"
								name="code_market" id="code_market"
								placeholder="Mã siêu thị nếu có">
						</div>
						<div class="form-button">
							<c:if test="${msg!=null}">
								<div>
									<c:out value="${msg}"></c:out>
								</div>
							</c:if>
							<input type="submit" name="signup" id="signup"
								class="form-submit" value="Register">
						</div>
					</form>
				</div>
				<div class="signup-image">
					<figure>
						<img src="images/signup-image.png" alt="signup_image">
					</figure>
					<a href="LoginForward"> I am already member </a>
				</div>
			</div>
		</div>
	</div>
	<script>
	    // Lấy biểu mẫu và các trường mật khẩu
	    const form = document.getElementById("register-form");
	    const passInput = document.getElementById("password");
	    const rePassInput = document.getElementById("re_password");
	    form.addEventListener("submit", function (event) {
	        if (passInput.value !== rePassInput.value) {
	            // Nếu mật khẩu và mật khẩu lặp lại không khớp, ngăn chặn gửi biểu mẫu và hiển thị thông báo
	            event.preventDefault();
	            alert("Mật khẩu không khớp.");
	        }
	    });
	</script>

</body>
</html>