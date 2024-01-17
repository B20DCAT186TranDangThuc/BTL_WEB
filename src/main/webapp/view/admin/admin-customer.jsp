<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/admin-customer.css">
<title>Quản Lý Khách Hàng</title>
</head>

<body>
	<jsp:include page="../header/header-admin.jsp"></jsp:include>

	<div class="container">
		<form action="SearchCustomerForward" method="get" class="search-Admin">
		</form>
		<div class="div-action">
			<div class="div-sort">
				<select name="sort" id="sort" onchange="redirectToSortCustomer()">
					<option value="1">Tên Khách Hàng</option>
					<option value="2">Tài Khoản</option>
					<option value="3">Ngày Sinh</option>
					<option value="4">Email</option>
					<option value="5">Địa Chỉ</option>
					<option value="6">Phone</option>
				</select>
			</div>
			<div class="button-sort">
				<button class="btn-sort up choose" onclick="focusButton(this)">
					Tăng <i class="fas fa-plus"></i>
				</button>
				<button class="btn-sort down" onclick="focusButton(this)">
					Giảm <i class="fas fa-minus"></i>
				</button>
			</div>

			<input type="text" name="search" placeholder="Nhập tên khách hàng"
				class="search-admin-input">
		</div>


		<table class="list-customer">
			<thead>
				<tr>
					<th>Tên khách hàng</th>
					<th>Tên tài khoản</th>
					<th>Ngày sinh</th>
					<th>Email</th>
					<th>Địa chỉ</th>
					<th>Phone</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty customerList}">
					<tr>
						<td colspan="6">Không tìm thấy khách hàng.</td>
					</tr>
				</c:if>
				<c:forEach var="customer" items="${customerList}">
					<tr>
						<td>${customer.nameuser}</td>
						<td>${customer.username}</td>
						<td>${customer.dob}</td>
						<td>${customer.email}</td>
						<td>${customer.address}</td>
						<td>${customer.phone}</td>
						<td style="width: 300px;">
							<form action="DeleteCustomerController?id=${customer.id}"
								method="post" onsubmit="return confirmDelete()">
								<button class="delete" type="submit">
									<i class="fa-solid fa-trash"></i>
								</button>
							</form>

						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script type="text/javascript">
		var form = document.querySelector('.search-Admin');
		var selectedValue = document.getElementById("sort").value
		var searchValue = form.search.value
		form.addEventListener('submit', function(event) {

			event.preventDefault(); // Ngăn chặn gửi form mặc định
			var searchValue = form.search.value;
			if (searchValue === null)
				searchValue = ""
			sessionStorage.setItem('search', searchValue);
			selectedValue = sessionStorage.getItem('sort');
			console.log(selectedValue)
			var url = 'SortCustomerForward?sort=' + selectedValue + '&search='
					+ searchValue;
			window.location.href = url;

		});
		window.addEventListener('load', function() {
			// Thực hiện các thao tác tải dữ liệu ở đây
			document.getElementById("sort").value = sessionStorage
					.getItem('sort');
			form.search.value = sessionStorage.getItem('search');
		});
		function redirectToSortCustomer() {
			var selectedValue = document.getElementById("sort").value;
			sessionStorage.setItem('sort', selectedValue);
			searchValue = sessionStorage.getItem('search');
			if (searchValue === null)
				searchValue = ""
			var url = 'SortCustomerForward?sort=' + selectedValue + '&search='
					+ searchValue;
			window.location.href = url;
		}
		function confirmDelete() {
			return confirm("Bạn có chắc chắn muốn xóa khách hàng này không?");
		}
		function focusButton(button) {
	        var buttons = document.querySelectorAll('.btn-sort');
	        buttons.forEach(function(btn) {
	            btn.classList.remove('choose');
	        });
	        button.classList.add('choose');
		}
		 
	</script>
</body>

</html>