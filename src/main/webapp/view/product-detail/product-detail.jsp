<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/product-detail.css">
<title>Chi tiết sản phẩm</title>
</head>
<body>
	<jsp:include page="../../view/header/header.jsp"></jsp:include>
	
	
    <div class="container">
        <div class="product">
            <div id="slider">
                <div id="largeImageContainer">
                	<c:set var="imagePath" value="images/products/${product.getImage().get(0)}" />
                    <img id="largeImage" src="${imagePath}" alt="Large Image">
                </div>
                <div id="thumbnailContainer">
			        <c:forEach var="img" items="${product.image}" varStatus="status">
			        	<c:set var="imagePath" value="images/products/${img}" />
			            <div class="thumbnail" onmouseover="changeImage('${imagePath}')">
			                <img src="${imagePath}" alt="Thumbnail ${status.index + 1}">
			            </div>
			        </c:forEach>
			    </div>
            </div>

            <div class="product-info">
                <h1 class="product-title">${product.name}</h1>
                <div class="product-info-simple">
                    ${String.format("%.1f", avgRate)} sao | ${listComment.size()} đánh giá | 10 đã bán | còn ${product.quantity}
                </div>
				<div class="product-price">
				    <h1 class="price">
				    	<c:set var="productPrice" value="${product.price}" />
						<fmt:formatNumber value="${productPrice}" type="currency" currencyCode="VND" maxFractionDigits="0"/>
				    </h1>
				    <!-- <span class="discount">Giảm 25%</span> -->
				</div>
                <p class="product-decription">${product.description}</p>

                <div class="list-btn">
                    <c:choose>
				      <c:when test="${empty sessionScope.user}">
				        <button class="btn btn-buy-now" onclick="showLoginAlert()">Mua ngay</button>
				        <button class="btn btn-add-cart">Thêm vào giỏ hàng</button>
				      </c:when>
				      <c:otherwise>
				        <form id="buyNowForm" action="OrderForward" method="post">
				          <input type="hidden" name="id_user" value="${sessionScope.user.id}" />
				          <input type="hidden" name="id_product" value="${product.productID}" />
				          <button class="btn btn-buy-now" onclick="submitBuyNowForm()">Mua ngay</button>
				          <button class="btn btn-add-cart">Thêm vào giỏ hàng</button>
				        </form>
				      </c:otherwise>
				    </c:choose>
                </div>
            </div>
        </div>

        <div class="product-review">
            <h1 class="title">Đánh giá</h1>
            <div class="review">
            	<c:forEach var="comment" items="${listComment}">
			        <div class="review-item">
			            <h3 class="customer-name">${comment.name_comment}</h3>
			            <span class="time-comment">${comment.getTimeQuestion()}</span>
			
			            <div class="review-content">
			                <div class="review-star">${comment.rate} sao</div>
			                <p class="review-text">${comment.question}</p>
			            </div>
			
			            <c:if test="${not empty comment.answer}">
			                <div class="answer-comment">
			                    <h4>Hệ thống</h4>
			                    <span class="time-comment">${comment.getTimeAnswer()}</span>
			                    <p class="review-text">${comment.answer}</p>
			                </div>
			            </c:if>
			
			        </div>
			    </c:forEach>
            </div>
            
            <form action="CommentController" method="post" class="write-review">
                <textarea name="comment" id="" cols="30" rows="10"></textarea>
                <div class="rating">
                    <input type="radio" id="star5" name="rating" value="5" />
                    <label for="star5" title="5 stars"></label>
                    <input type="radio" id="star4" name="rating" value="4" />
                    <label for="star4" title="4 stars"></label>
                    <input type="radio" id="star3" name="rating" value="3" />
                    <label for="star3" title="3 stars"></label>
                    <input type="radio" id="star2" name="rating" value="2" />
                    <label for="star2" title="2 stars"></label>
                    <input type="radio" id="star1" name="rating" value="1" />
                    <label for="star1" title="1 star"></label>
                </div>
                <c:choose>
				      <c:when test="${empty sessionScope.user}">
				        <button class="btn btn-review" onclick="showLoginAlertBeforeComment(event)">Gửi đánh giá</button>
				      </c:when>
				      <c:otherwise>
				      	<input type="hidden" name="id_product" value="${product.productID}" />
				        <button class="btn btn-review">Gửi đánh giá</button>
				      </c:otherwise>
				    </c:choose>
            </form>
        </div>

        <div class="product-other-box">
            <div class="booth">
                <h2 class="name-booth">Sản phẩm liên quan</h2>
                <div class="list-product">
				  <c:forEach var="product" items="${listOtherProduct}">
	              	<div class="product-other">
	                       	<c:set var="imagePath" value="images/products/${product.getImage().get(0)}" />
						    <img src="${imagePath}" alt="chua co anh" width="100%">
	                        <a href="ProductDetailFowward?product_id=${product.productID}" class="btn-chitet">Xem chi tiết</a>
	                        <div class="product-info">
	                            <h2 class="product-name">${product.name}</h2>
	                            <span>
	                            	<c:set var="productPrice" value="${product.price}" />
									<fmt:formatNumber value="${productPrice}" type="currency" currencyCode="VND" maxFractionDigits="0"/>	
	                            </span>
	                        </div>
	                        <div class="list-btn">
	                            <c:choose>
							      <c:when test="${empty sessionScope.user}">
							        <button class="btn btn-buy-now" onclick="showLoginAlert()">Mua ngay</button>
							        <button class="btn btn-add-cart">Thêm vào giỏ hàng</button>
							      </c:when>
							      <c:otherwise>
							        <form id="buyNowForm" action="OrderForward" method="post" style="display: flex; width: 100%;">
							          <input type="hidden" name="id_user" value="${sessionScope.user.id}" />
							          <input type="hidden" name="id_product" value="${product.productID}" />
							          <button class="btn btn-buy-now" onclick="submitBuyNowForm()">Mua ngay</button>
							          <button class="btn btn-add-cart">Thêm vào giỏ hàng</button>
							        </form>
							      </c:otherwise>
							    </c:choose>
	                        </div>
	                    </div>
	                </c:forEach>
				</div>
                <div class="see-more">
                    <a href="">Xem thêm</a>
                </div>
            </div>
        </div>
    </div>
    <script>
        function changeImage(imageUrl) {
            document.getElementById('largeImage').src = imageUrl;
        }
        
        function showLoginAlert() {
            alert('Bạn cần đăng nhập để mua hàng!');
          }
        function showLoginAlertBeforeComment(event) {
        	event.preventDefault();
        	alert('Bạn cần đăng nhập để bình luận!')
        }

	       function submitBuyNowForm() {
	         document.getElementById('buyNowForm').submit();
	       }
    </script>
</body>
</html>