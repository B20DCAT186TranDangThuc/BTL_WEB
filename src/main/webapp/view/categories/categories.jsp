<%@page import="util.ImageUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/categories.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../header/header.jsp"></jsp:include>
	<div class="container">
		<h1 class="title">Danh mục sản phẩm</h1>
		<div class="menu">
			<a href="ShowThucPham" class="food active"> <img
				src="images/categories/food.png" alt="" width="100px"> <span>Thực
					phẩm</span>
			</a> <a href="" class="drink"> <img src="images/categories/drink.png"
				alt="" width="100px"> <span>Đồ uống</span>
			</a> <a href="" class="pastries"> <img
				src="images/categories/pastries.png" alt="" width="100px"> <span>Bánh
					ngọt</span>
			</a> <a href="" class="electronic"> <img
				src="images/categories/electronic.png" alt="" width="100px"> <span>Đồ
					Điện tử</span>
			</a> <a href="" class="clothing"> <img
				src="images/categories/clothing.png" alt="" width="100px"> <span>Quần
					áo</span>
			</a> <a href="" class="appliances"> <img
				src="images/categories/appliances.png" alt="" width="100px"> <span>Đồ
					gia dụng</span>
			</a>
		</div>

		<div class="products">
			<div class="sort">
				<span>Sắp xếp theo</span> <select id="sortSelect">
					<option value="default">Mặc định</option>
					<option value="priceAsc">Giá tăng dần</option>
					<option value="priceDesc">Giá giảm dần</option>
					<option value="nameAsc">Tên A-Z</option>
					<option value="nameDesc">Tên Z-A</option>
				</select>
			</div>

			<div class="list-product">
				<!-- danh sách sản phẩm lấy từ database-->
				<c:forEach var="product" items="${productList}">
					<div class="product">

						<img
							src="data:image/*;base64,${ImageUtil.encodeImage(product.image)}"
							alt="Product Image" width="100%"> <a
							href="ChiTietSanPham?${product.productID}" class="btn-chitet">Xem
							chi tiết</a>
						<div class="product-info">
							<h2>${product.name}</h2>
							<span>${product.price}</span>
						</div>
						<div class="list-btn">
							<a href="" class="btn">Thêm vào giỏ hàng</a> <a href=""
								class="btn btn-sell">Mua ngay</a>
						</div>
					</div>
				</c:forEach>

			</div>

		</div>
	</div>
</body>
</html>