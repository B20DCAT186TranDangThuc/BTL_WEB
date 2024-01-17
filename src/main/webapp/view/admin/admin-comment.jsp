<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quản Lý Bình Luận</title>
<link rel="stylesheet" href="css/fontawesome/css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/admin-comment.css">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<style>
.form-overlay {
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	background-color: rgba(0, 0, 0, 0.5);
	display: flex;
	align-items: center;
	justify-content: center;
}

.reply-form {
	background-color: white;
	padding: 20px;
	border-radius: 5px;
	width: 300px;
}

.reply-form input[type="text"], .reply-form textarea {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

.reply-form input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	border: none;
	padding: 10px 20px;
	border-radius: 5px;
	cursor: pointer;
}
</style>
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
						<th style="width: 14%;">Khách hàng</th>
						<th style="width: 14%;">Sản Phẩm</th>
						<th style="width: 17%;">Câu Hỏi</th>
						<th style="width: 11%;">Thời Gian</th>
						<th style="width: 17%;">Trả Lời</th>
						<th style="width: 11%;">Thời Gian</th>
						<th style="width: 4%;">Rate</th>
						<th style="width: 8%;">Hành Động</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="comment" items="${comments}">
						<tr>
							<td>${comment.idComment }</td>
							<td>${comment.idUser }</td>
							<td>${comment.idProduct }</td>
							<td>${comment.question }</td>
							<td>${comment.timeQuestion }</td>
							<td>${comment.answer }</td>
							<td>${comment.timeAnswer }</td>
							<td>${comment.rate}</td>
							<td>
								<div class="btn-action">
									<button class="button reply-button"
										onclick="createReplyForm(${comment.idComment})"
										${not empty comment.answer ? 'disabled' : '' } style="${not empty comment.answer ? 'background-color: gray;' : '' }">Trả lời</button>
									<button onclick="confirmDelete(${comment.idComment})"
										class="button delete-button">Xóa</button>
								</div>
							<td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="pagination" id="pagination"></div>
		</div>
	</div>
	<script>
		function confirmDelete(id) {
			if(confirm("Bạn có chắc chắn muốn xóa khách hàng này không?")){
				window.location.href="deletecomment?id_comment="+id;
			}
		}
		
		function createReplyForm(commentId) {
			  var formOverlay = document.createElement("div");
			  formOverlay.classList.add("form-overlay");
			  formOverlay.addEventListener("click", function(event) {
				    if (event.target === formOverlay) {
				      formOverlay.remove();
				    }
				  });
			  var form = document.createElement("form");
			  form.classList.add("reply-form");
			  form.setAttribute("method", "POST");
			  form.setAttribute("action", "answercomment?id_comment=" + commentId);

			  var input = document.createElement("input");
			  input.setAttribute("type", "text");
			  input.setAttribute("name", "reply");
			  
			  var submitButton = document.createElement("input");
			  submitButton.setAttribute("type", "submit");
			  submitButton.setAttribute("value", "Gửi");
			  
			  form.appendChild(input);
			  form.appendChild(submitButton);
			  
			  formOverlay.appendChild(form);
			  document.body.appendChild(formOverlay);
			}
		
	</script>
</body>

</html>