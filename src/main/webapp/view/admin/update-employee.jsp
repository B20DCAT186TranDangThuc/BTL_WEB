<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/update-employee.css">
<title>Cập nhật thông tin</title>
</head>
<body>
	<div class="container">
		<h1 class="title-page">Thông tin của nhân viên ${employee.id}</h1>
		<h3 class="title-page" style="color: red;"><%=request.getAttribute("msg") != null ? request.getAttribute("msg") : ""%></h3>
		<form action="UpdateEmployeeController" method="post">
			<table class="simple-info">
				<tr class="title">
					<td colspan="2">Thông tin cơ bản</td>
				</tr>
				<tr>
					<td>Họ và tên</td>
					<td><input type="text" name="name"
						value="${employee.nameuser}"></td>
				</tr>
				<tr>
					<td>Chức Vụ</td>
					<td><span>${employee.getStringPosition()}</span></td>
				</tr>
				<tr>
					<td>Địa chỉ</td>
					<td><input type="text" name="address"
						value="${employee.address}"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" value="${employee.email}"></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><input type="text" name="phone" value="${employee.phone}"></td>
				</tr>
				<tr>
					<td>Lương</td>
					<td><input type="number" name="salary"
						value="${employee.salary}"></td>
				</tr>
			</table>

			<table class="account-info">
				<tr class="title">
					<td colspan="2">Thông tin tài khoản</td>
				</tr>
				<tr>
					<td>Tên đăng nhập</td>
					<td><input type="text" name="username"
						value="${employee.username}"></td>
				</tr>
				<tr>
					<td>Mật khẩu</td>
					<td><input type="password" name="password"
						value="${employee.password}"></td>
				</tr>
				<tr>
					<td>Quyền</td>
					<td><select name="position">
								<option value="1" ${employee.position == 1 ? 'selected' : ''}>Quản
									trị viên</option>
							<option value="2" ${employee.position == 2 ? 'selected' : ''}>Nhân
								viên kho</option>
							<option value="3" ${employee.position == 3 ? 'selected' : ''}>Nhân
								viên bán hàng</option>
					</select></td>
				</tr>
			</table>
			<input type="hidden" name="id_user" value="${employee.id}">

			<div class="list-button">
				<button type="submit" class="btn btn-success">Lưu</button>
				<button type="button" class="btn btn-back"
					formaction="AdminEmployeeForward">Quay lại</button>
			</div>
		</form>
	</div>

	<script type="text/javascript">
		document.querySelector('.btn-back').addEventListener('click',
				function() {
					window.location.href = 'AdminEmployeeForward';
				});
	</script>

</body>
</html>