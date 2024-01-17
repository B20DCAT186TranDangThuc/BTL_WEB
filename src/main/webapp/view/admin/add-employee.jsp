<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/add-employee.css">
<title>Thêm nhân viên</title>
</head>
<body>
	<jsp:include page="../header/header-admin.jsp"></jsp:include>
	<div class="container">
		<h1 class="title-page">Thêm nhân viên</h1>
		<h3 class="title-page" style="color: red;"><%= request.getAttribute("msg") != null ? request.getAttribute("msg") : "" %></h3>
		<form action="AddEmployeeController" method="post">
			<table class="simple-info">
				<tr class="title">
					<td colspan="2">Thông tin cơ bản</td>
				</tr>
				<tr>
					<td class="title-a">Họ và tên</td>
					<td ><input type="text" name="name" placeholder="Tên đầy đủ" autocomplete="off" required></td>
				</tr>
				<tr>
					<td class="title-a">Ngày sinh</td>
					<td class="content-a"><input type="date" name="birthday" placeholder="yyyy-mm-dd" autocomplete="off" required></td>
				</tr>
				<tr>
					<td class="title-a">Địa chỉ</td>
					<td class="content-a"><input type="text" name="address" placeholder="Địa chỉ" autocomplete="off" required></td>
				</tr>
				<tr>
					<td class="title-a">Email</td>
					<td class="content-a"><input type="email" name="email" placeholder="Email"></td>
				</tr>
				<tr>
					<td class="title-a">Lương</td>
					<td class="content-a"><input type="number" name="salary" placeholder="Lương" autocomplete="off" required></td>
				</tr>
			</table>

			<table class="account-info">
				<tr class="title">
					<td colspan="2">Thông tin tài khoản</td>
				</tr>
				<tr>
					<td class="title-a">Tên đăng nhập</td>
					<td class="content-a"><input type="text" name="username"  placeholder="Tên tài khoản" autocomplete="off" required></td>
				</tr>
				<tr>
					<td class="title-a">Mật khẩu</td>
					<td class="content-a"><input type="password" name="password" placeholder="Mật khẩu" autocomplete="off" required></td>
				</tr>
				<tr>
					<td class="title-a">Quyền</td>
					<td class="content-a"><select name="role">
							<option value="1">Quản trị viên</option>
							<option value="2">Nhân viên kho</option>
							<option value="3">Nhân viên bán hàng</option>
					</select></td>
				</tr>
			</table>
			<div class="list-button">
				<button type="submit" class="btn btn-success">Lưu</button>
				<button type="button" class="btn btn-back"
					formaction="AdminEmployeeForward">Quay lại</button>
			</div>
		</form>
	</div>

	<script type="text/javascript">
	    document.querySelector('.btn-back').addEventListener('click', function() {
	        window.location.href = 'AdminEmployeeForward';
	    });
    </script>

</body>
</html>