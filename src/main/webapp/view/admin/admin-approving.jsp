<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/fontawesome/css/all.min.css" />
<link rel="stylesheet" type="text/css" href="css/admin-customer.css">
<title>Insert title here</title>
</head>
<body>
<body>
	<jsp:include page="../header/header-admin.jsp"></jsp:include>

	<div class="container">
		<div class="action">
			<div class="status">
				<label for="status">Trạng thái</label> <select name="status"
					id="status" onchange="redirectTostatusorder()">
					<option value="3" selected>Tất cả </option>
					<option value="0">Chưa duyệt</option>
					<option value="1">Đã duyệt </option>
					
				</select>
			</div>
			<form action="SearchOrderForward" method="get" class="search-Admin">
				<input type="text" name="search" placeholder="Nhập từ khóa muốn tìm"
					class="search-admin-input">
			</form>

		</div>
		<table class="list-order">
			<thead>
				<tr>
					<th>Mã đơn hàng</th>
					<th>Tên khách hàng</th>
					<th>Địa chỉ</th>
					<th>Tổng giá trị</th>
					<th>Thời gian</th>
					<th>Trạng thái</th>
					<th>Tùy chỉnh</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty orderlist}">
					<tr>
						<td colspan="6">Không tìm thấy khách hàng.</td>
					</tr>
				</c:if>
				<c:forEach var="order" items="${orderlist}">
					<tr>
						<td>${order.id_order}</td>
						<td><a href=OrderDetailForward?id_order=${order.id_order}> ${order.name_customer}</a></td>
						<td>${order.address}</td>
						<td>${order.price}</td>
						<td>${order.time}</td>
						<td >${order.status}</td>
         
						<td style="width: 300px;">
							<div class="action-table">
								<c:if test="${order.status eq '0'}">
									<form action="ApprovingForward" method="post"
									onsubmit="return confirmApproving()">
										<input type="hidden" name="id_order" value="${order.id_order}">
									   <button 
										class="update"><i class="fa-solid fa-pen"></i></button>
									   </form>
								</c:if>
							 	<button class="order-detail-button" onclick=""><i class="fas fa-bars"></i></button>
							 
								<form action="DeleteOrderController" method="post"
									onsubmit="return confirmDelete()">
									<input type="hidden" name="id_order" value="${order.id_order}">
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
		var form = document.querySelector('.search-Admin');
		var selectedValue = document.getElementById("status").value
		var searchValue = form.search.value
		form.addEventListener('submit', function(event) {

			event.preventDefault(); // Ngăn chặn gửi form mặc định
			var searchValue = form.search.value;
			if (searchValue === null)
				searchValue = ""
			sessionStorage.setItem('search', searchValue);
			selectedValue = sessionStorage.getItem('status');
			console.log(selectedValue)
			var url = 'FilterForward?status=' + selectedValue + '&search='
					+ searchValue;
			window.location.href = url;

		});
		window.addEventListener('load', function() {
			// Thực hiện các thao tác tải dữ liệu ở đây
			document.getElementById("status").value = sessionStorage
					.getItem('status');
			form.search.value = sessionStorage.getItem('search');
		});
		function redirectTostatusorder() {
			var selectedValue = document.getElementById("status").value;
			sessionStorage.setItem('status', selectedValue);
			searchValue = sessionStorage.getItem('search');
			if (searchValue === null)
				searchValue = ""
			var url = 'FilterForward?status=' + selectedValue + '&search='
					+ searchValue;
			window.location.href = url;
		}
		function confirmDelete() {
			return confirm("Bạn có chắc chắn muốn xóa đon hàng này không?");
		}
		function confirmApproving() {
		    return confirm("Bạn có chắc chắn muốn duyệt đơn hàng này không?");
		}
		 function OrderDetail(button) {
			 var orderDetailContent = button.nextElementSibling;
			 orderDetailContent.style.display = orderDetailContent.style.display === 'none' ? 'block' : 'none';
         }
	</script>
</body>

</body>
</html>