<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/update-employee.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1 class="title-page">Thông tin sản phẩm</h1>
		<form action="UpdateProduct?id_product=${product.productID}" method="post">
			<table class="simple-info">
				<tr>
					<td>Tên sản phẩm </td>
					<td><input type="text" name="name"
						value="${product.name}"></td>
				</tr>
				<tr>
					<td>Giá sản phẩm </td>
					<td><input type="text" name="price"
						value="${product.price}"></td>
				</tr>
				<tr>
					<td>Thông tin sản phẩm </td>
					<td><input type="text" name="description"
						value="${product.description}"></td>
				</tr>
				<tr>
					<td>Tồn kho </td>
					<td><input type="text" name="inventory"
						value="${product.quantity}"></td>
				</tr>
				<tr>
					<td>Số lượng đã bán </td>
					<td><input type="text" name="quantity" disabled
						value="${quantity}"></td>
				</tr>
			</table>
				<div class="list-button">
					<button type="submit" class="btn btn-success">Lưu</button>
					<button type="button" class="btn btn-back" formaction="AdminProductForward">Quay lại</button>
				</div>
		</form>
	</div>
</body>
</html>