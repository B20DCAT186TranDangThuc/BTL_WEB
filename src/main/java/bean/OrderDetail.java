package bean;

import java.util.List;

public class OrderDetail extends Order{
	private long price;
	private List<Integer> quanlity;
	private List<Product> products;
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	public List<Integer> getQuanlity() {
		return quanlity;
	}
	public void setQuanlity(List<Integer> quanlity) {
		this.quanlity = quanlity;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}

