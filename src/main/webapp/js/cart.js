document.addEventListener("DOMContentLoaded", function() {
	var quantityElements = document.querySelectorAll(".quantity");

	quantityElements.forEach(function(quantityElement) {
		quantityElement.addEventListener("click", function(e) {
			var target = e.target;
			var input = null;

			if (
				target.classList.contains("plus") ||
				target.classList.contains("minus")
			) {
				input = quantityElement.querySelector(".qty");
				var priceElement = quantityElement.previousElementSibling;
				var totalElement = quantityElement.nextElementSibling;

				var price = parseFloat(priceElement.textContent.replace(/[^\d.]/g, ""));
				var quantity = parseInt(input.value);

				if (isNaN(quantity)) {
					quantity = 0;
				}

				if (target.classList.contains("plus")) {
					input.value = quantity + 1;
				} else if (target.classList.contains("minus") && quantity > 0) {
					input.value = quantity - 1;
				}

				var newQuantity = parseInt(input.value);
				var newTotal = (price * newQuantity * 1000).toLocaleString("vi-VN", {
					currency: "VND",
				});
				totalElement.innerHTML =
					newTotal + '<span style="margin-left: 5px;">VNĐ</span>';
			}
		});
	});
});

// Tạo một list lưu danh sách sản phẩm đã chọn
var listProduct = [];

var checkboxs = document.querySelectorAll(".product-checkbox");
var subTotal = document.querySelector(".price-subtotal");
var total = document.querySelector(".price-total-checkout");

// Lắng nghe sự kiện click vào checkbox
checkboxs.forEach((checkbox) => {
	checkbox.addEventListener("click", function(e) {
		var target = e.target;
		var product = target.parentElement.parentElement;
		var price = parseFloat(product.querySelector(".price").textContent.replace(/[^\d.]/g, ""));
		var quantity = product.querySelector(".qty").value;

		// Nếu check thì thêm vào list
		if (target.checked) {
			listProduct.push({
				id: target.value,
				price: price,
				quantity: quantity,
			});
		} else {
			// Nếu bỏ check thì xóa khỏi list
			listProduct = listProduct.filter((item) => {
				return item.id != target.value;
			});
		}

		// Cập nhật giá trị
		var newSubTotal = listProduct.reduce((total, item) => {
			return total + item.price * item.quantity * 1000;
		}, 0);
		subTotal.textContent = newSubTotal.toLocaleString("vi-VN", {
			currency: "VND",
		});

		var newTotal = newSubTotal;
		total.textContent = newTotal.toLocaleString("vi-VN", {
			currency: "VND",
		});
	});
});