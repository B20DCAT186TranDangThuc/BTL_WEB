<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/home.css">

<title>Trang Chủ</title>
</head>
<body>
	<jsp:include page="view/header/header.jsp"></jsp:include>

	<div class="container">

		<div class="menu">
			<a href="ShowThucPham" class="food"> <img
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

		<div class="slide-show">
			<ul class="slideshow">
				<li class="slide">
					<div class="info-slide">
						<h1 class="header-slide">Đăng Ký Thành viên</h1>
						<p>Đăng ký thành viên ngay hôm nay và nhận ngay ưu đãi đặc
							biệt. Bạn sẽ được hưởng mức giá ưu đãi độc quyền và nhận thông
							tin sớm về các chương trình khuyến mãi. Đừng bỏ lỡ cơ hội tiết
							kiệm và trải nghiệm tuyệt vời, hãy đăng ký thành viên ngay hôm
							nay!</p>
					</div> <a href="#" class="image-slide"> <img src="" alt=""></a>
				</li>
				<li class="slide">
					<div class="info-slide">
						<h1 class="header-slide">Đăng Ký Thành viên</h1>
						<p>Đăng ký thành viên ngay hôm nay và nhận ngay ưu đãi đặc
							biệt. Bạn sẽ được hưởng mức giá ưu đãi độc quyền và nhận thông
							tin sớm về các chương trình khuyến mãi. Đừng bỏ lỡ cơ hội tiết
							kiệm và trải nghiệm tuyệt vời, hãy đăng ký thành viên ngay hôm
							nay!</p>
					</div> <a href="#" class="image-slide"> <img src="" alt=""></a>
				</li>
				<li class="slide">
					<div class="info-slide">
						<h1 class="header-slide">Đăng Ký Thành viên</h1>
						<p>Đăng ký thành viên ngay hôm nay và nhận ngay ưu đãi đặc
							biệt. Bạn sẽ được hưởng mức giá ưu đãi độc quyền và nhận thông
							tin sớm về các chương trình khuyến mãi. Đừng bỏ lỡ cơ hội tiết
							kiệm và trải nghiệm tuyệt vời, hãy đăng ký thành viên ngay hôm
							nay!</p>
					</div> <a href="#" class="image-slide"> <img src="" alt=""></a>
				</li>
				<li class="slide">
					<div class="info-slide">
						<h1 class="header-slide">Đăng Ký Thành viên</h1>
						<p>Đăng ký thành viên ngay hôm nay và nhận ngay ưu đãi đặc
							biệt. Bạn sẽ được hưởng mức giá ưu đãi độc quyền và nhận thông
							tin sớm về các chương trình khuyến mãi. Đừng bỏ lỡ cơ hội tiết
							kiệm và trải nghiệm tuyệt vời, hãy đăng ký thành viên ngay hôm
							nay!</p>
					</div> <a href="#" class="image-slide"> <img src="" alt=""></a>
				</li>
				<li class="slide">
					<div class="info-slide">
						<h1 class="header-slide">Đăng Ký Thành viên</h1>
						<p>Đăng ký thành viên ngay hôm nay và nhận ngay ưu đãi đặc
							biệt. Bạn sẽ được hưởng mức giá ưu đãi độc quyền và nhận thông
							tin sớm về các chương trình khuyến mãi. Đừng bỏ lỡ cơ hội tiết
							kiệm và trải nghiệm tuyệt vời, hãy đăng ký thành viên ngay hôm
							nay!</p>
					</div> <a href="#" class="image-slide"> <img src="" alt="">
				</a>
				</li>
			</ul>
		</div>

		<div class="list-booth">
			<c:forEach var="categoryEntry" items="${categoryProduct}">
				<div class="booth">
					<h2 class="name-booth">${categoryEntry.key}</h2>
					<div class="list-product">
						<c:forEach var="product" items="${categoryEntry.value}">
							<div class="product">
								<c:set var="imagePath"
									value="images/products/${product.getImage().get(0)}" />
								<img src="${imagePath}" alt="chua co anh" width="100%"> <a
									href="ProductDetailFowward?product_id=${product.productID}"
									class="btn-chitet">Xem chi tiết</a>
								<div class="product-info">
									<h2 class="product-name">${product.name}</h2>
									<span>
										<c:set var="productPrice" value="${product.price}" />
										<fmt:formatNumber value="${productPrice}" type="currency" currencyCode="VND" maxFractionDigits="0"/>
									</span>
								</div>
								<div class="list-btn">
									<a href="" class="btn">Thêm vào giỏ hàng</a> <a href=""
										class="btn btn-sell">Mua ngay</a>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="see-more">
						<a href="">Xem thêm</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<script src="js/home.js"></script>
</body>
</html>