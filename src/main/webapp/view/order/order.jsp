<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/order.css">
<title>Xác nhận đặt hàng</title>
</head>
<body>

	<jsp:include page="../header/header.jsp"></jsp:include>

    <div class="container">
        <div class="header-title">
            <div class="icon">
                <img src="images/checkout-icon.png" alt="">
            </div>
            <h1 class="title">Thanh toán</h1>
            <p>Vui lòng kiểm tra thông tin Khách hàng, thông tin Đơn hàng trước khi Đặt hàng.</p>
            <p style="color: red;">${msg != null ? mgs : ""}</p>
        </div>
        <form action="OrderController" method="post" class="infomation">
            <div style="display: flex;">
                <div class="customer-info">
				    <h2>Thông tin Khách Hàng:</h2>
				    <div class="box-input">
				    	<input type="hidden" name="customer_id" value="${sessionScope.member.id_user}">
				        <label for="name">Họ và tên:</label>
				        <input type="text" name="customer_name" placeholder="Nhập họ và tên" required value="${sessionScope.member.nameuser}">
				        
				        <label for="gender">Giới tính:</label>
				        <select name="gender">
				            <option value="male" ${sessionScope.member.gender eq 'Male' ? 'selected' : ''}>Nam</option>
				            <option value="female" ${sessionScope.member.gender eq 'Female' ? 'selected' : ''}>Nữ</option>
				        </select>
				        
				        <label for="phone">Số điện thoại:</label>
				        <input type="text" name="phone" placeholder="Nhập số điện thoại" required value="${sessionScope.member.phone}">
				        
				        <label for="email">Email:</label>
				        <input type="email" name="email"  placeholder="Nhập email" value="${sessionScope.member.email}">
				        
				        <label for="address">Địa chỉ:</label>
				        <input type="text" name="address" placeholder="Nhập địa chỉ" required value="${sessionScope.member.address}">
				    </div>
				</div>
                <div class="order-info">
                    <div class="order-info-title">
                        <h2 class="title">Giỏ hàng</h2>
                        <div class="quantity">${sessionScope.listProduct.size()}</div>
                    </div>
                    <div class="list-order">
                    	<c:forEach var="product" items="${sessionScope.listProduct}">
					        <div class="order-info__item">
					            <div class="product-info">
					                <div class="name-product">${product.name}</div>
					                <input type="hidden" name="product_id" value="${product.productID}">
					                <input type="text" class="price" readonly value="${product.price}">
						            <div class="quantity-box">
	                                    <div class="decrease" onclick="decreaseQuantity()">-</div>
	                                    <input type="text" readonly name="quantity" id="quantity" min="1" value="${sessionScope.quantity != null ? sessionScope.quantity: 1}">
	                                    <div class="increase" onclick="increaseQuantity(${product.quantity})">+</div>
	                                </div>
					            </div>
					            <input type="text" readonly name="product_total" class="product-total" value="0">
					        </div>
					    </c:forEach>
                    </div>
                    <div class="order-total">
                        <div class="total-title">Tổng tiền:</div>
                        <input type="text" readonly name="total_price" class="total-price" value="0">
                    </div>
                </div>
            </div>

            <div class="list-btn">
                <button type="button" class="btn btn-back" onclick="goBack()" formnovalidate="formnovalidate">Quay lại</button>
                <input type="submit" class="btn btn-order" value="Đặt hàng">
            </div>
        </form>
    </div>

		
    <script>
	    window.addEventListener('load', function() {
	        // Gọi hàm updateTotal() khi trang và tất cả các tài nguyên đã được tải hoàn toàn
	        updateTotal();
	    });
    
	    function formatCurrency(amount) {
	        // Sử dụng hàm toLocaleString để định dạng số thành chuỗi có định dạng tiền tệ
	        // 'vi-VN' là mã ngôn ngữ của Việt Nam
	        return amount.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' });
	    }
	
	    // Hàm cập nhật tổng và định dạng giá trị tiền
	    function updateTotal() {
	        var productList = document.querySelectorAll('.order-info__item');
	        var totalProductValue = 0;
	
	        productList.forEach(function(product) {
	            var price = parseFloat(product.querySelector('.price').value);
	            var quantity = parseInt(product.querySelector('.quantity-box input[name="quantity"]').value);
	            var productTotal = price * quantity;
	
	            // Cập nhật input "product-total" và định dạng giá trị VND
	            product.querySelector('.product-total').value = formatCurrency(productTotal);
	
	            totalProductValue += productTotal;
	        });
	
	        // Cập nhật input "total-price" và định dạng giá trị VND
	        document.querySelector('.total-price').value = formatCurrency(totalProductValue);
	    }
    	
    
	    function increaseQuantity(maxQuantity) {
	        var quantityInput = document.getElementById("quantity");
	        var quantity = parseInt(quantityInput.value);
	        
	        // Kiểm tra nếu quantity chưa đạt giới hạn tối đa
	        if (quantity < maxQuantity) {
	            quantity += 1; // Tăng quantity lên 1
	            quantityInput.value = quantity; // Cập nhật giá trị mới vào input quantity
	        }
	        updateTotal();
	    }
        
	    function decreaseQuantity() {
	        var quantityInput = document.getElementById("quantity");
	        var quantity = parseInt(quantityInput.value);
	        
	        // Kiểm tra nếu quantity lớn hơn 1
	        if (quantity > 1) {
	            quantity -= 1; // Giảm quantity đi 1
	            quantityInput.value = quantity; // Cập nhật giá trị mới vào input quantity
	        }
	        updateTotal();
	    }
	    
        function goBack() {
            window.history.back();
        }
    </script>

</body>
</html>