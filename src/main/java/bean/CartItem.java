package bean;

public class CartItem extends Product{
	private int id_cart, quantity_cart;

	public int getId_cart() {
		return id_cart;
	}

	public void setId_cart(int id_cart) {
		this.id_cart = id_cart;
	}

	public int getQuantity_cart() {
		return quantity_cart;
	}

	public void setQuantity_cart(int quantity_cart) {
		this.quantity_cart = quantity_cart;
	}

	
}
