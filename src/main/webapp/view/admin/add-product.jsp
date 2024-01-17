<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Thêm Sản Phẩm</title>
<link rel="stylesheet" href="css/fontawesome/css/all.min.css">
<link rel="stylesheet" type="text/css" href="css/add-product.css">
</head>


<body>
	<jsp:include page="../header/header-admin.jsp"></jsp:include>
		
		<div class="container">
			<div class="acontainer">
				<div class="content-product">
					<div class="edit-row">
						<div class="edit-title"> Tên sản phẩm</div>
						<div class="edit-main">
							<div class="input-name">
								<input type="text" placeholder="Nhập vào" maxlength="120" id="input-name" name="name" autocomplete="off" required>
								<div class="length-name">
									<span class="max-length-name">0</span><span>/120</span>
								</div>
							</div>
						</div>
					</div>
					<div class="edit-row">
						<div class="edit-title">Giá Tiền</div>
						<div class="edit-main">
							<div class="input-name">
								<input type="text" value="0" name="price" class="numInput" oninput="formatNumberInput(this)" min="0" autocomplete="off" required>
							</div>
						</div>
					</div>
					<div class="edit-row">
						<div class="edit-title">Khuyến Mãi</div>
						<div class="edit-main">
							<div class="input-name">
								<input type="number" value="0" name="sale" class="numInput" min="0">
								<div class="length-name">
									<span>%</span>
								</div>
							</div>
						</div>
					</div>
					<div class="edit-row">
						<div class="edit-title">Danh Mục</div>
						<div class="edit-main" onclick="toggleDropdown()">
							<div class="type-product">
								<input class="hint-type-product" type="text" name="category"
									id="type" placeholder="Chọn ngành hàng" autocomplete="off" required>
								<i class="img-icon"> 
									<svg
										xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16">
										<path fill-rule="evenodd"
											d="M13.7698326,4.53553391 L11.6485122,2.41421356 L9.52719188,4.53553391 L11.6485122,6.65685425 L13.7698326,4.53553391 Z M10.9414054,7.36396103 L8.8200851,5.24264069 L2.71213203,11.3505938 L2.5,13.6840461 L4.83345238,13.4719141 L10.9414054,7.36396103 Z M12.355619,1.70710678 L14.4769394,3.82842712 C14.8674636,4.21895142 14.8674636,4.8521164 14.4769394,5.24264069 L5.54055916,14.1790209 C5.37514107,14.344439 5.1569639,14.4466277 4.92398812,14.4678073 L2.59053575,14.6799393 C2.04051912,14.7299408 1.55410831,14.3245985 1.50410679,13.7745819 C1.49863107,13.7143489 1.49863107,13.6537434 1.50410679,13.5935104 L1.71623883,11.260058 C1.73741844,11.0270822 1.83960716,10.8089051 2.00502525,10.643487 L10.9414054,1.70710678 C11.3319297,1.31658249 11.9650947,1.31658249 12.355619,1.70710678 Z">
										</path>
									</svg>
								</i>
								<div class="dropdown-list" id="dropdownList">
									<div class="dropdown-list-item"
										style="color: blue; font-weight: 600;">Thêm Ngành Hàng</div>
									<c:forEach var="item" items="${category}">
										<div class="dropdown-list-item">${item.name}</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
					<div class="edit-row">
						<div class="edit-title">Số Lượng</div>
						<div class="edit-main">
							<div class="input-name">
								<input type="number" value="0" name="total" class="numInput" min="0" autocomplete="off" required>
							</div>
						</div>
					</div>
					<div class="edit-row">
						<div class="edit-title" style="margin-top: 5px;">Mô tả sản phẩm</div>
						<div class="edit-main">
							<textarea type="textarea" maxlength="3000"
								class="input-decription" rows="10"
								style="padding: 5px; height: auto;" name="description"></textarea>
							<div style="margin: 5px; float: right; margin-right: 5px;">
								<span class="max-text-decription">0</span><span>/3000</span>
							</div>
						</div>
					</div>
				</div>
				<div class="grid-container">
					<% for (int i = 1; i <= 9; i++) { %>
						<div class="grid-item">
							<div class="image-upload">
								<input type="file" class="fileInput" name="image<%=i%>"
									accept="image/*">
								<div class="img_upload">
									<i class="img-icon"> <svg viewBox="0 0 23 21"
											xmlns="http://www.w3.org/2000/svg">
											<path
												d="M18.5 0A1.5 1.5 0 0120 1.5V12c-.49-.07-1.01-.07-1.5 0V1.5H2v12.65l3.395-3.408a.75.75 0 01.958-.087l.104.087L7.89 12.18l3.687-5.21a.75.75 0 01.96-.086l.103.087 3.391 3.405c.81.813.433 2.28-.398 3.07A5.235 5.235 0 0014.053 18H2a1.5 1.5 0 01-1.5-1.5v-15A1.5 1.5 0 012 0h16.5z">
											</path>
											<path
												d="M6.5 4.5a1.5 1.5 0 110 3 1.5 1.5 0 010-3zM18.5 14.25a.75.75 0 011.5 0v2.25h2.25a.75.75 0 010 1.5H20v2.25a.75.75 0 01-1.5 0V18h-2.25a.75.75 0 010-1.5h2.25v-2.25z">
											</path>
										</svg>
									</i>
									<div class="text-image">Thêm hình ảnh (0/9)</div>
								</div>
							</div>
						</div>
		            <% } %>					
				</div>
			</div>
			<div class="footer-button">
				<button type="submit" class="button" onclick="history.back()">Hủy</button>
				<button type="submit" class="button">Lưu &amp; Ẩn</button>
				<button type="submit" class="button button-save">Lưu &amp; Hiển thị</button>
			</div>
		</div>
	</form>
	<script>
		var fileInputs = document.querySelectorAll('.fileInput');
		var data = document.querySelectorAll('.img_upload');
		var inputDecription = document.querySelector('.input-decription');
		var inputName = document.getElementById('input-name');
		var numInput = document.querySelectorAll('.numInput');
		fileInputs.forEach(function (fileInput, index) {
			fileInput.addEventListener('change', function () {
				if (fileInput.files && fileInput.files[0]) {
					var imageElement = fileInput.nextElementSibling;
					if (!imageElement || imageElement.tagName !== 'IMG') {
						imageElement = document.createElement('img');
						fileInput.parentNode.replaceChild(imageElement, data[index]);
					}
					imageElement.src = URL.createObjectURL(fileInput.files[0]);
					imageElement.alt = 'Product Image';
					imageElement.style.height = '98px';
					imageElement.style.width = '98px';
					imageElement.style.borderRadius = '4px';
					var textImage = document.querySelectorAll('.text-image');
					textImage.forEach((e) => {
						e.textContent = 'Thêm hình ảnh (' + (parseInt(e.textContent.split('/')[0].split('(')[1]) + 1) + '/9)';;
					});
				}
			});
		});
	
		inputDecription.addEventListener('input', () => {
			document.querySelector('.max-text-decription').textContent = inputDecription.value.length;
			inputDecription.style.height = "auto";
			inputDecription.style.height = (inputDecription.scrollHeight + 5) + "px";
			inputDecription.parentNode.style.height = (inputDecription.scrollHeight + 5) + "px";
		})
		inputName.addEventListener('input', () => {
			document.querySelector('.max-length-name').textContent = inputName.value.length;
		})
	
		var dropdownList = document.getElementById("dropdownList");
		var chooseCategory = document.querySelectorAll('.dropdown-list-item');

		function toggleDropdown() {
			dropdownList.style.display = dropdownList.style.display === 'block' ? 'none' : 'block';
		}
		
		window.onclick = function (event) {
			chooseCategory.forEach(function (e, index) {
				e.addEventListener('click', function () {
					var chon1 = document.getElementById('type');
					chon1.value = e.textContent;
					chon1.style.color = "black";
				});
			});
		 	if (!event.target.matches('.hint-type-product')) {
				if (dropdownList.style.display === 'block') {
					dropdownList.style.display = 'none';
				}
			}
		}		
		
		document.getElementById('myForm').addEventListener('keypress', function (e) {
			if (e.key === 'Enter') {
			    e.preventDefault();
			}
		});
		
		numInput.forEach(function (numericInput) {
			numericInput.addEventListener('click', function () {
                if (this.value === '0') {
                    this.value = '';
                }

	            numericInput.addEventListener('blur', function () {
	                if (this.value === '') {
	                    this.value = '0';
	                }
	            });
			});
		});

		function formatNumberInput(input) {
            let numericValue = input.value.replace(/[^0-9]/g, '');
            input.value = numericValue.replace(/\B(?=(\d{3})+(?!\d))/g, ',');;
        }
	</script>

</body>

</html>