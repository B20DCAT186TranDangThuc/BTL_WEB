<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Main css -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/header.css">

</head>
<body>
	<header class="content">
		<div class="top-header">
			<a href="HomeForward" class="logo-home"> <img
				src="images/logo.png" alt="" width="50" height="50"> <span>Hệ
					thống QLST</span></a>
			<form action="#" class="search-box">
				<i class="fa-solid fa-magnifying-glass"></i> <input type="text"
					placeholder="Bạn cần gì?" name="inputSearch">
			</form>

			<c:choose>
				<c:when test="${empty sessionScope.user.name}">
					<div class="login">
						<a href="LoginForward" class="login-btn">Đăng nhập</a> <a
							href="RegisterForward" class="register-btn">Đăng ký</a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="login">
						<a href="ProfileForward" class="user-name">${sessionScope.user.name}</a> <a
							href="LogoutForward" class="logout register-btn">Đăng xuất</a>
					</div>
				</c:otherwise>
			</c:choose>
		</div>

		<div class="main-header">
			<div class="btn-default">
				<a href="HomeForward">Trang Chủ</a>
			</div>
			<div class="btn-default">
				<a href="AdminCustomerForward">Quản lý khách hàng</a>
			</div>
			<div class="btn-default">
				<a href="AdminEmployeeForward">Quản Lý Nhân Viên</a>
			</div>
			<div class="btn-default">
				<a href="AdminProductForward">Quản Lý Sản Phẩm</a>
			</div>
			<div class="btn-default">
				<a href="AdminImportForward">Quản Lý Nhập Hàng</a>
			</div>
			<div class="btn-default">
				<a href="AdminSellForward">Quản Lý Bán Hàng</a>
			</div>
			<div class="btn-default">
				<a href="AdminCommentForward">Quản Lý Bình Luận</a>
			</div>
			<div class="btn-default">
				<a href="AdminStaticForward">Thống Kê - Báo Cáo</a>
			</div>
		</div>
	</header>
</body>
</html>