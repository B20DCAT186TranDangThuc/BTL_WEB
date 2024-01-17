package bean;

import java.util.ArrayList;

public class Product {
	private int productID;
	private String name;
	private String category;
	private int category_id;
	private long price;
	private int sale;
	private String description;
	private int quantity;
	private ArrayList<String> image;

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ArrayList<String> getImage() {
		return image;
	}

	public void setImage(ArrayList<String> image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", name=" + name + ", category=" + category + ", category_id="
				+ category_id + ", price=" + price + ", sale=" + sale + ", description=" + description + ", quantity="
				+ quantity + ", image=" + image + "]";
	}

}
