<%@page import="bean.Product"%>
<%@page import="java.awt.event.ItemEvent"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quản Lý Sản Phẩm</title>
<link rel="stylesheet" href="css/fontawesome/css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/admin-product.css">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>


<body>
	<jsp:include page="../header/header-admin.jsp"></jsp:include>
	<div class="container">
		<div class="control_dash" style="display: flex;">
			<div style="font-size: 20px; margin-top: 3px;">Có tất cả <strong><c:out value="${fn:length(products)}"></c:out> </strong>sản phẩm</div>
			<div class="control_button">
				 <a
					href="DeleteProductController" class="button delete-button"><i
					class="fas fa-trash"></i> Xóa Sản Phẩm</a> <a
					href="StaticProductForward" class="button stats-button"><i
					class="fas fa-chart-bar"></i> Thống Kê</a> 
					<form action="ImportProductController" method="post" enctype="multipart/form-data" id="exelImport">
						<input type="file" id="exelInput" name="exelInput" accept=".xlsx" onchange="submitForm()">
					</form>
					<a href="ExportProductController" class="button export-button"><i
					class="fas fa-file-excel"></i> Xuất Excel</a>
			</div>
		</div>
		<div class="content_table">
			<table class="sanpham_table">
				<thead>
					<tr>
						<th style="width: 3%;">Chọn</th>
						<th style="width: 3%;">STT</th>
						<th style="width: 5%;">Ảnh</th>
						<th style="width: 17%;">Sản Phẩm</th>
						<th style="width: 10%;">Giá</th>
						<th style="width: 9%;">Khuyến Mại</th>
						<th style="width: 11%;">Giá Khuyến Mại</th>
						<th style="width: 10%;">Danh Mục</th>
						<th style="width: 8%;">Tình Trạng</th>
						<th style="width: 7%;">Hiển thị</th>
						<th style="width: 16%;">Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${products}">
						<tr>
							<td><input type="checkbox" name="chon" id="chon" value="${item.getProductID()}"></td>
							<td>${item.getProductID()}</td>
							<c:set var="imagePath" value="images/products/${item.getImage().get(0)}" />
							<td>
							    <img src="${imagePath}" alt="chua co anh">
							</td>
							<td>${item.getName()}</td>
							<td><fmt:formatNumber value="${item.getPrice()}"/></td>
							<td>5%</td>
							<td><fmt:formatNumber value="${item.getPrice()}"/></td>
							<td>${item.getCategory()}</td>
							<td>Còn hàng</td>
							<td><i class="fa-solid fa-circle-check fa-xl"
								style="color: #4cfe0b;"></i></td>
							<td>
								<div class="button-product">
									<form action="UpdateProductController?id_product=${item.getProductID()}" method="post">
										<button class="button detail-button">Chi Tiết</button>
									</form>
									
									<form action="delete-product" method="post" onsubmit="return confirmDelete(${item.getProductID()})">
										<button type="submit" name="delete" value="${item.getProductID()}" class="button delete-button">Xóa</button>
									</form>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="pagination" id="pagination"></div>
		</div>
	</div>
	<script>
		function formatNumberInput(input) {
            let numericValue = input.value.replace(/[^0-9]/g, '');
            input.value = numericValue.replace(/\B(?=(\d{3})+(?!\d))/g, ',');;
        }
		
		function confirmDelete(id) {
			if(confirm("Bạn có chắc chắn muốn xóa khách hàng này không?")){
				return true;
			}
			return false;
		}
		
		 function submitForm() {
	            var fileInput = document.getElementById('exelInput');
	            var file = fileInput.files[0];
	            if (file && file.name.endsWith(".xlsx")) {
	                document.getElementById('exelImport').submit();
	            } else {
	                alert("Vui lòng chọn một tệp Excel đúng định dạng (.xlsx).");
	            }
	        }
	</script>
</body>

</html>