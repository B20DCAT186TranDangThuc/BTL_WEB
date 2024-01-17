<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/search.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../header/header.jsp"></jsp:include>
	<div class="container">
		<h1 class="title">Bạn cần tìm gì?</h1>

		<form action="search.php" method="get" class="box-search">
			<input type="text" name="search" placeholder="Tìm kiếm..." autofocus>
			<button type="submit">Tìm kiếm</button>
			<img src="images/search.png" alt="">
		</form>

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
				<div class="product">
					<img src="images/categories/appliances.png" alt="" width="100%">
					<a href="" class="btn-chitet">Xem chi tiết</a>
					<div class="product-info">
						<h2>iPhone 11 Pro Max 64GB</h2>
						<span>21.990.000đ</span>
					</div>
					<div class="list-btn">
						<a href="" class="btn ">Thêm vào giỏ hàng</a> <a href=""
							class="btn btn-sell">Mua ngay</a>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>