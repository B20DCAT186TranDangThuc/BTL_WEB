<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/order-success.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<title>Đặt hàng thành công</title>
</head>

<body>
	<jsp:include page="../header/header.jsp"></jsp:include>
	
	<div class="container" style="padding-top: 120px;">
		<div class="contain">
	        <div class="icon">
	            <i class="fa-solid fa-circle-check fa-xl"
	                style="color: rgb(13, 214, 13);transform: scale(2); margin:20px;"></i>
	        </div>
	        <h1 class="code-orders">Đặt hàng thành công</h1>
	        <p class="code-orders">Mã đơn hàng: #${order.id_order}</p>
	        <p class="code-orders">************************************************</p>
	        <h4>Thông tin giao hàng</h4>
	        <p>${order.name_order}</p>
	        <p>${order.phone}</p>
	        <p>${order.address}</p>
	        <h4>Phương thức thanh toán</h4>
	        <p>Thanh toán khi giao hàng (COD)</p>
	        <p style="margin-top:40px;">Bạn có thể xem chi tiết tại <a href="">danh sách đơn hàng</a></p>
	        <div class="paint">
	            <div class="child-div"></div>
	            <div class="child-div"></div>
	            <div class="child-div"></div>
	            <div class="child-div"></div>
	            <div class="child-div"></div>
	            <div class="child-div"></div>
	            <div class="child-div"></div>
	            <div class="child-div"></div>
	            <div class="child-div"></div>
	            <div class="child-div"></div>
	            <div class="child-div"></div>
	            <div class="child-div"></div>
	            <div class="child-div"></div>
	            <div class="child-div"></div>
	            <div class="child-div"></div>
	            <div class="child-div"></div>
	            <div class="child-div"></div>
	            <div class="child-div"></div>
	        </div>
	    </div>
	    
	    <div style="margin-top: 50px;width: 100%;text-align: center;">
	        <button id="continueShoppingBtn">Tiếp tục mua hàng</button>
	    </div>
	    
	    <div class="support">
	        <p>Cần hỗ trợ? <a href="">Liên hệ chúng tôi</a></p>
	    </div>
	</div>
	
	<script>
	    document.getElementById("continueShoppingBtn").addEventListener("click", function() {
	        window.location.href = "HomeForward";
	    });
	</script>
</body>
</html>