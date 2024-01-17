package bean;

public class Cart {

	private int id_cart, id_user;

	public int getId_cart() {
		return id_cart;
	}

	public void setId_cart(int id_cart) {
		this.id_cart = id_cart;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	@Override
	public String toString() {
		return "Cart [id_cart=" + id_cart + ", id_user=" + id_user + "]";
	}

}
