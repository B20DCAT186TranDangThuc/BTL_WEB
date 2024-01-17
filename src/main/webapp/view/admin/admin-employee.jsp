<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/fontawesome/css/all.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/admin-employee.css">
<title>Quản Lý Nhân Viên</title>
</head>

<body>
	<c:set var="currentPage" value="employee-Admin" />
	<jsp:include page="../header/header-admin.jsp"></jsp:include>

	<div class="container">
		<div class="div-action">
			<div class="div-filter">
				<div class="div-sort">
					<div>
						<label for="sort">Sắp xếp </label> <select name="sort" id="sort"
							onchange="redirectToSortEmployee(this)">
							<option value="1">Tên Nhân Viên</option>
							<option value="2">Chức Vụ</option>
							<option value="3">Ngày Sinh</option>
							<option value="4">Email</option>
							<option value="5">Địa Chỉ</option>
							<option value="6">Phone</option>
							<option value="7">Lương</option>
						</select>
					</div>
				</div>
				<div class="button-sort">
					<button class="btn-sort up choose" onclick="focusButton(this,'ASC')" id="btn-up">
						Tăng <i class="fas fa-plus"></i>
					</button>
					<button class="btn-sort down" onclick="focusButton(this,'DESC')" id="btn-down">
						Giảm <i class="fas fa-minus"></i>
					</button>
				</div>

				<input type="text" placeholder="Nhập tên nhân viên"
					class="search-admin-input" autocomplete="off">
				<button class="btn search">Tìm Kiếm</button>
			</div>
			<div class="add-employee">
			<button class="btn" onclick="window.location.href='AddEmployeeForward'"><i class="fa-solid fa-plus"></i> Thêm mới</button>
			</div>
		</div>
		<table class="list-employee">
			<thead>
				<tr>
					<th>Tên nhân viên</th>
					<th>Chức vụ</th>
					<th>Ngày sinh</th>
					<th>Email</th>
					<th>Địa chỉ</th>
					<th>Phone</th>
					<th>Lương</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty employeeList}">
					<tr>
						<td colspan="6">Không tìm thấy nhân viên.</td>
					</tr>
				</c:if>
				<c:forEach var="employee" items="${employeeList}">
					<tr>
						<td>${employee.nameuser}</td>
						<td>${employee.getStringPosition()}</td>
						<td>${employee.dob != null ? employee.dob  : "-"}</td>
						<td>${employee.email != null ? employee.email : "-"}</td>
						<td>${employee.address != null ? employee.address : "-"}</td>
						<td>${employee.phone != null ? employee.phone : "-"}</td>
						<td>${employee.salary}</td>
						<td style="width: 300px;">
							<div class="action-table">
								<a href="UpdateEmployeeForward?id_user=${employee.id}"
									class="update"><i class="fa-solid fa-pen"></i></a>
								<form action="DeleteEmployeeController" method="post"
									onsubmit="return confirmDelete()">
									<input type="hidden" name="id_user" value="${employee.id}">
									<button class="delete" type="submit">
										<i class="fa-solid fa-trash"></i>
									</button>
								</form>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script>
		function redirectToSortEmployee(selected) {
			var selectedValue = selected.value;
			sessionStorage.setItem('selectedValue', selectedValue);
			var searchValue = document.querySelector(".search-admin-input").value;
			if (searchValue) {
				searchValue = '&search=' + searchValue;
			}
			selectedValue = "sort=" + selectedValue;
			window.location.href = "SortEmployeeForward?" + selectedValue + searchValue;
		}
	
		function confirmDelete() {
			return confirm("Bạn có chắc chắn muốn xóa nhân viên này không?");
		}
	
		function focusButton(button, sType) {
			var buttons = document.querySelectorAll('.btn-sort');
			buttons.forEach(function(btn) {
				btn.classList.remove('choose');
			});
			button.classList.add('choose');
			sessionStorage.setItem("sortType", sType);
			sessionStorage.setItem("button", button);
		}
	</script>
</body>

</html>