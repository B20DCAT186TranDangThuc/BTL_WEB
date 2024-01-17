<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quản Lý Bình Luận</title>
<link rel="stylesheet" href="css/fontawesome/css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/admin-comment.css">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>


<body>
	<c:set var="currentPage" value="web-Admin" />
	<jsp:include page="../header/header-admin.jsp"></jsp:include>
	<div class="container">
		<div class="control_dash">
			<a href="#"><button class="button stats-button">
					<i class="fas fa-chart-bar"></i> Thống Kê
				</button></a> <a href="#">
				<button class="button export-button">
					<i class="fas fa-file-excel"></i> Xuất File Excel
				</button>
			</a> <a href="#">
				<button class="button delete-button">
					<i class="fas fa-trash"></i> Xóa Tất Cả
				</button>
			</a>
		</div>
		<div class="content_table">
			<table class="binhluan_table">
				<thead>
					<tr>
						<th style="width: 4%;">STT</th>
						<th style="width: 14%;">Tên khách hàng</th>
						<th style="width: 14%;">Thời gian</th>
						<th style="width: 52%;">Nội dung</th>
						<th style="width: 10%;">Trả lời</th>
						<th style="width: 6%;">Xóa</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>John Doe</td>
						<td>2023-01-02 07:41:30</td>
						<td>This is the first comment.</td>
						<td><button class="button reply-button">Trả lời</button></td>
						<td><button class="button delete-button">Xóa</button></td>
					</tr>
				</tbody>
			</table>
			<div class="pagination" id="pagination"></div>
		</div>
	</div>
</body>

</html>