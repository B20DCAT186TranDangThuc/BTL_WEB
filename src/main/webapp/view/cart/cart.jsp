<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/cart.css">
<title>Giỏ hàng</title>
</head>
<body>
	<jsp:include page="../header/header.jsp"></jsp:include>
	<div class="container">
		<h1 class="title">Giỏ hàng (4 Items)</h1>
		<table class="cart">
			<thead>
				<tr>
					<th class="select"><label for="select-all">Chọn</label></th>
					<th class="product">Sản phẩm</th>
					<th class="price">Giá</th>
					<th class="quantity">Số lượng</th>
					<th class="total">Tổng</th>
					<th class="remove">Xóa</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="select"><input type="checkbox"
						class="product-checkbox" value="001"></td>
					<td class="product">
						<div class="product-image">
							<img src="images/aothun.jpg" alt="product">
						</div>
						<div class="product-info">
							<h4 class="product-name">Áo thun nam trắng Việt Nam</h4>
						</div>
					</td>
					<td class="price">250.000 <span style="margin-left: 5px;">VNĐ</span></td>
					<td class="quantity"><input type='button' value='-'
						class='qtyminus minus' field='quantity' /> <input type='text'
						name='quantity' readonly value='1' class='qty' /> <input type='button'
						value='+' class='qtyplus plus' field='quantity' /></td>
					<td class="total" style="width: 200px;">250.000 <span
						style="margin-left: 5px;">VNĐ</span></td>
					<td class="remove"><a href="">Xóa</a></td>
				</tr>
				<tr>
					<td class="select"><input type="checkbox"
						class="product-checkbox" value="002"></td>
					<td class="product">
						<div class="product-image">
							<img src="images/aothun.jpg" alt="product">
						</div>
						<div class="product-info">
							<h4 class="product-name">Áo thun nam trắng Việt Nam</h4>
						</div>
					</td>
					<td class="price">200.000 <span style="margin-left: 5px;">VNĐ</span></td>
					<td class="quantity"><input type='button' value='-'
						class='qtyminus minus' field='quantity' /> <input type='text'
						name='quantity' readonly value='1' class='qty' /> <input type='button'
						value='+' class='qtyplus plus' field='quantity' /></td>
					<td class="total" style="width: 200px;">250.000 <span
						style="margin-left: 5px;">VNĐ</span></td>
					<td class="remove"><a href="">Xóa</a></td>
				</tr>
			</tbody>
		</table>

		<form class="check-out" action="" method="post">
			<div class="subtotal">
				<span class="text">Tổng tiền</span>
				<div style="border: none;">
					<span class="price-subtotal">0 </span> <span
						style="margin-left: 6px;">VNĐ</span>
				</div>
			</div>
			<div class="total-checkout">
				<span class="text">Tổng cộng</span>
				<div style="border: none;">
					<span class="price-total-checkout">0 </span> <span
						style="margin-left: 6px;">VNĐ</span>
				</div>
			</div>
			<div class="checkout-btn">
				<input type="submit" value="Đặt hàng" class="btn">
			</div>
		</form>

	</div>
	<script src="js/cart.js"></script>
</body>
</html>