<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> -->
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/admin-employee.css">
<title>Quản Lý Bán Hàng</title>
</head>

<body>
	<c:set var="currentPage" value="employee-Admin" />
	<jsp:include page="../header/header-admin.jsp"></jsp:include>

	<div class="container">
		<div class="action">
			<div class="sort">
				<label for="sort">Sắp xếp theo</label> <select name="sort" id="sort"
					onchange="redirectToSortEmployee()">
					<option value="0">----</option>
					<option value="1">Tên</option>
					<option value="2">Tuổi</option>
				</select>
			</div>
			<form action="SearchEmployeeForward" method="get"
				class="search-Admin">
				<input type="text" name="search" placeholder="Nhập tên nhân viên"
					class="search-admin-input">
			</form>
			<div class="add-employee">
				<a href="AddEmployeeForward" class="btn"> <i
					class="fa-solid fa-plus"></i> Thêm mới
				</a>
			</div>
		</div>
		<table class="list-employee">
			<thead>
				<tr>

					<th>Tên nhân viên</th>
					<th>Ngày sinh</th>
					<th>Email</th>
					<th>Địa chỉ</th>
					<th>Job</th>
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
						<td>${employee.name}</td>
						<td>${employee.dob}</td>
						<td>${employee.email}</td>
						<td>${employee.address != null ? employee.address : "_"}</td>
						<td>${employee.job}</td>
						<td style="width: 300px;">
							<div class="action-table">
								<a href="UpdateEmployeeForward?memberID=${employee.memberID}"
									class="update"><i class="fa-solid fa-pen"></i></a>
								<form action="DeleteEmployeeController" method="post"
									onsubmit="return confirmDelete()">
									<input type="hidden" name="accountID"
										value="${employee.account.accountID}"> <input
										type="hidden" name="memberID" value="${employee.memberID}">
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

	<script type="text/javascript">
        function redirectToSortEmployee() {
            var selectedValue = document.getElementById("sort").value;
            var url = "SortEmployeeForward?sort=" + selectedValue;
            window.location.href = url;
        }
        function confirmDelete() {
            return confirm("Bạn có chắc chắn muốn xóa nhân viên này không?");
        }
    </script>
</body>

</html>