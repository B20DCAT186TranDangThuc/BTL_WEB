<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/fontawesome/css/all.min.css" />
<link rel="stylesheet" type="text/css" href="css/admin-product.css">
<title>Chi tiết đơn hàng</title>
</head>
<body>
	<jsp:include page="../header/header-admin.jsp"></jsp:include>
	<div class="container">
		<h1 class="title-page">Chi tiết đơn hàng ${sessionScope.id_user}</h1>
		<h3 class="title-page" style="color: red;"><%=request.getAttribute("msg") != null ? request.getAttribute("msg") : ""%></h3>
		<form
			action="UpdateCustomerController?id_user=${sessionScope.id_user}"
			method="post" autocomplete="off" id="update">
			<table class="simple-info">
				<tr class="title">

				</tr>
				<tr>
					<td>Họ và tên</td>
					<td><input type="text" disabled
						value="${OrderDetail.name_customer}"></td>
				</tr>
				<tr>
					<td>Địa chỉ</td>
					<td><input type="text" disabled value="${OrderDetail.address}"></td>
				</tr>

				<tr>
					<td>Họ và tên</td>
					<td><input type="text" disabled name="name"
						value="${OrderDetail.status}"></td>
				</tr>
			</table>
			<table class="sanpham_table">
				<tr class="title">
					<th style="width: 3%;">STT</th>
					<th style="width: 5%;">Ảnh</th>
					<th style="width: 17%;">Sản Phẩm</th>
					<th style="width: 10%;">Giá</th>
					<th style="width: 9%;">Khuyến Mại</th>
					<th style="width: 11%;">Giá Khuyến Mại</th>
					<th>Số lượng</th>
					<th>Thành tiền</th>
				</tr>
				<c:forEach items="${OrderDetail.products}" var="product"
					varStatus="status">
					<tr>
						<td>${product.getProductID()}</td>
						<c:set var="imagePath"
							value="images/products/${product.getImage().get(0)}" />
						<td><img src="${imagePath}" alt="chua co anh"></td>
						<td>${product.getName()}</td>
						<td>${product.getPrice()}</td>
						<td>5%</td>
						<td> ${product.getPrice()*95/100} </td>
						<td>${OrderDetail.quanlity[status.index]}</td>
						<td>${product.getPrice() * OrderDetail.quanlity[status.index]*95/100}</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>