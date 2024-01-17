<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/update-customer.css">
<title>Cập nhật thông tin</title>
</head>
<body>
	<jsp:include page="../header/header.jsp"></jsp:include>
	<div class="container">
		<h1 class="title-page">Thông tin của khách hàng
			${sessionScope.id_user}</h1>
		<h3 class="title-page" style="color: red;"><%=request.getAttribute("msg") != null ? request.getAttribute("msg") : ""%></h3>
		<form
			action="UpdateCustomerController?id_user=${sessionScope.id_user}"
			method="post" autocomplete="off" id="update">
			<table class="simple-info">
				<tr class="title">

				</tr>
				<tr>
					<td>Họ và tên</td>
					<td><input type="text" name="name"
						value="${customer.nameuser}"></td>
				</tr>
				<tr>
					<td>Ngày sinh</td>
					<td><input type="date" name="dob" value="${customer.dob}"></td>
				</tr>
				<tr>
					<td>Địa chỉ</td>
					<td><input type="text" name="address"
						value="${customer.address}"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" value="${customer.email}"></td>
				</tr>
				<tr>
					<td>Số điện thoại</td>
					<td><input type="text" name="phone" value="${customer.phone}"></td>
				</tr>
				<tr>
					<td>Mật khẩu</td>
					<td><input type="password" name="password" id="password"
						required="" placeholder="Mật Khẩu"></td>
				</tr>
				<tr>
					<td>Nhập lại mật khẩu</td>
					<td><input type="password"
								name="re_password" id="re_password" required=""
								placeholder="Nhập lại mật khẩu"></td>
				</tr>
			</table>

			<div class="list-button">
				<button type="submit" class="btn btn-success">Lưu</button>
				<button type="button" class="btn btn-back">Quay lại</button>
			</div>
		</form>
	</div>

	<script type="text/javascript">
		document.querySelector('.btn-back').addEventListener('click',
				function() {
					window.location.href = 'HomeForward';
				});
		
		const form = document.getElementById("update");
	    const passInput = document.getElementById("password");
	    const rePassInput = document.getElementById("re_password");
	    console.log(form)
	    form.addEventListener("submit", function (event) {
	    	console.log("abc")
	        if (passInput.value !== rePassInput.value) {
	            // Nếu mật khẩu và mật khẩu lặp lại không khớp, ngăn chặn gửi biểu mẫu và hiển thị thông báo
	            event.preventDefault();
	            alert("Mật khẩu không khớp.");
	        }
	    });
	</script>

</body>
</html>