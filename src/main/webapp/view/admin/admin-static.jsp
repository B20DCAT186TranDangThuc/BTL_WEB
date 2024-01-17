<%@page import="bean.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/admin-static.css">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<title>Thống Kê - Báo Cáo</title>
</head>

<body>
	<c:set var="currentPage" value="web-Admin" />
	<jsp:include page="../header/header-admin.jsp"></jsp:include>
	<div class="container">
		<div class="dashbar">
			<div class="flex-item">
				<div class="title">
					<i class="fa-solid fa-user"></i>Tổng User
				</div>
				<div class="data">
					<%
					out.print(request.getAttribute("usercount"));
					%>
				</div>
			</div>
			<div class="flex-item">
				<div class="title">
					<i class="fa-brands fa-product-hunt"></i>Số Lượng Mặt Hàng
				</div>
				<div class="data" style="color: rgb(44, 92, 76);">
					<%
					out.print(request.getAttribute("productcount"));
					%>
				</div>
			</div>
			<div class="flex-item">
				<div class="title">
					<i class="fa-brands fa-product-hunt"></i>Tổng Sản Phẩm
				</div>
				<div class="data" style="color: rgb(228, 52, 119);">
					<%
					out.print(request.getAttribute("stockproductcount"));
					%>
				</div>
			</div>
			<div class=" flex-item">
				<div class="title">
					<i class="fa-solid fa-user"></i>Tổng Lượng Truy Cập
				</div>
				<div class="data">
					<%
					out.print(request.getAttribute("connectcount"));
					%>
				</div>
			</div>
			<div class="flex-item">
				<div class="title">
					<i class="fa-brands fa-product-hunt"></i>Tổng Đơn Đặt Hàng
				</div>
				<div class="data">
					<%
					out.print(request.getAttribute("buycount"));
					%>
				</div>
			</div>
			<div class="flex-item">
				<div class="title">
					<i class="fa-solid fa-user"></i>Tổng Số Bình Luận
				</div>
				<div class="data">
					<%
					out.print(request.getAttribute("commentcount"));
					%>
				</div>
			</div>
		</div>

		<div style="display: flex; flex-direction: column;">
			<section id="onek">
				<div class="chart_list_dash">
					<div class="chart_dash">
						<canvas id="myChart" width="950" height="600"></canvas>
					</div>
					<div class="list_dash">
						<h1>Thống kê sản phẩm chi tiết</h1>
						<div class="list_report">
							<div>Tổng số lượng sản phẩm</div>
							<div>Số lượng sản phẩm đã bán</div>
							<div>Số lượng sản phẩm còn lại</div>
							<div>Số lượng sản phẩm hết hàng</div>
							<div>Tổng đơn đặt hàng</div>
							<div>Tổng doanh thu</div>
						</div>
					</div>
				</div>
			</section>
			<section id="ok">
				<div class="visitor_dash">
					<div class="chart_list_dash">
						<div class="chart_dash">
							<canvas id="myChart1" width="950" height="600"></canvas>
						</div>
						<div class="list_dash">
							<h1>Thống kê sản phẩm chi tiết</h1>
							<div class="list_report">
								<div>Tổng số lượng sản phẩm</div>
								<div>Số lượng sản phẩm đã bán</div>
								<div>Số lượng sản phẩm còn lại</div>
								<div>Số lượng sản phẩm hết hàng</div>
								<div>Tổng đơn đặt hàng</div>
								<div>Tổng doanh thu</div>
							</div>
						</div>
					</div>
			</section>
		</div>
	</div>
	<script>
		// Dữ liệu biểu đồ
		var data = {
			labels : [
	<%List<Category> productList = (List<Category>) request.getAttribute("category");
for (Category product : productList) {
	out.print("\"" + product.getName() + "\", ");
}%>
		],
			datasets : [
					{
						label : 'Đã bán',
						yAxisID : 'left-y-axis',
						data : [ 120, 130, 170, 380, 190, 149 ],
						backgroundColor : 'rgba(120, 90, 50, 0.3)', // Màu nền cột
					},
					{
						label : 'Còn lại',
						data : [ 3698, 7824, 1785, 9654, 12000, 7890 ],
						yAxisID : 'left-y-axis',
						backgroundColor : 'rgba(72, 190, 100, 0.3)', // Màu nền cột
					},
					{
						label : 'Doanh Thu',
						data : [ 1000000000, 2000011515, 1056516156,
								2561613616, 3331310300, 44400000 ],
						yAxisID : 'right-y-axis',
						backgroundColor : 'rgba(30, 60, 162, 0.3)', // Màu nền cột
					} ]
		};

		// Cấu hình biểu đồ
		var options = {
			responsive : false,
			plugins : {
				title : {
					display : true,
					text : 'Biểu Đồ Thống Kê Theo Danh Mục',
					font : {
						size : 20,
					}
				}
			},
			scales : {
				'left-y-axis' : {
					type : 'linear',
					position : 'left',
					beginAtZero : true,
					max : 14000,
					scaleLabel : {
						display : true,
						labelString : 'Số lượng'
					}
				},
				'right-y-axis' : {
					type : 'linear',
					position : 'right',
					beginAtZero : true,
					max : 3500000000,
					scaleLabel : {
						display : true,
						labelString : 'Doanh Thu'
					}
				}
			}
		};

		// Lấy thẻ canvas và vẽ biểu đồ
		var ctx = document.getElementById('myChart').getContext('2d');
		var ctx1 = document.getElementById('myChart1').getContext('2d');
		var myChart = new Chart(ctx, {
			type : 'bar',
			data : data,
			options : options
		});
		var myChart1 = new Chart(ctx1, {
			type : 'bar',
			data : data,
			options : options
		});
	</script>
</body>

</html>