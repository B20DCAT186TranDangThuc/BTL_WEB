<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/header.css">
</head>
<body>
	<header class="content">
		<div class="top-header">
			<a href="HomeForward" class="logo-home">
				<img src="images/logo.png" alt="" width="85" height="60"> <span>Hệ thống QLST</span>
			</a>
			<form action="#" class="search-box">
				<i class="fa-solid fa-magnifying-glass"></i>
				<input type="text" placeholder="Bạn cần gì?" name="inputSearch">
			</form>

			<c:choose>
				<c:when test="${empty sessionScope.user.name}">
					<div class="login">
						<a href="LoginForward" class="login-btn">Đăng nhập</a>
						<a href="RegisterForward" class="register-btn">Đăng ký</a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="login">
						<a href="CartForward" class="header-cart">
							<i class="fa-solid fa-cart-shopping"></i><span>Giỏ hàng</span>
						</a>
						<a	href="ProfileForward?id_user=${sessionScope.user.id}" class="user-name">${sessionScope.user.name}</a>
						<a	href="LogoutForward" class="logout register-btn">Đăng xuất</a>
					</div>
				</c:otherwise>
			</c:choose>
		</div>

		<div class="main-header">
			<div class="dropdown">
				<div class="dropdown-btn btn-default">
					<a href="#">Tất cả danh mục</a>
				</div>
				<c:choose>
					<c:when
						test="${empty sessionScope.user.user || sessionScope.user.permission == 4}">
						<div class="dropdown-content">
							<a href="SearchForward">Tìm kiếm</a>
							<a href="#">Khuyến mãi</a>
							<a href="#">Đăng ký thành viên</a>
							<a href="CategoriesForwad">Danh	mục sản phẩm</a>
							<a href="#">Review</a> <a href="#">Tin tức</a>
							<a href="#">Q&A</a> <a href="#">Khác</a>
						</div>
					</c:when>
					<c:when test="${sessionScope.user.permission == 1}">
						<div class="dropdown-content">
							<a href="AdminCustomerForward">Quản Lý Khách Hàng</a> <a
								href="AdminEmployeeForward">Quản Lý Nhân Viên</a> <a
								href="AdminProductForward">Quản Lý Sản Phẩm</a> <a
								href="AdminImportForward">Quản Lý Nhập Hàng</a> <a
								href="AdminSellForward">Quản Lý Bán Hàng</a> <a
								href="AdminCommentForward">Quản Lý Bình Luận</a> <a
								href="AdminStaticForward">Thống Kê - Báo Cáo</a>
						</div>
					</c:when>
					<c:when test="${sessionScope.user.permission == 2}">
						<div class="dropdown-content">
							<a href="">Quản Lý Sản Phẩm</a> <a href="">Quản Lý Nhập Hàng</a>
							<a href="">Thống Kê - Báo Cáo</a>
						</div>
					</c:when>
					<c:when test="${sessionScope.user.permission == 3}">
						<div class="dropdown-content">
							<a href="">Quản Lý Bán Hàng</a> <a href="">Quản Lý Bình Luận</a>
							<a href="">Thống Kê - Báo Cáo</a>
						</div>
					</c:when>
				</c:choose>


			</div>
			<div class="home btn-default">
				<a href="HomeForward">Trang chủ</a>
			</div>
			<div class="contract btn-default">
				<a href="#">Liên hệ</a>
			</div>
			<div class="about btn-default">
				<a href="#">Về chúng tôi</a>
			</div>

		</div>
	</header>
</body>
</html>