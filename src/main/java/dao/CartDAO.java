package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.CartItem;
import bean.Product;
import db.DBConnection;

public class CartDAO {

	public static List<CartItem> getAllCartItemByUserID(Connection conn, int id_user) {
		List<CartItem> ls = new ArrayList<CartItem>();
		String sql = "SELECT id_cart, id_product, quantity FROM cart_item\r\n" + "WHERE id_cart IN (\r\n"
				+ "    SELECT id_cart\r\n" + "    FROM cart\r\n" + "    WHERE id_user = ?\r\n" + ")";

		try (PreparedStatement ptmt = conn.prepareStatement(sql)) {
			ptmt.setInt(1, id_user);

			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				int id_product = rs.getInt("id_product");

				Product product = ProductDAO.getProductById(conn, id_product);
				CartItem cart_item = new CartItem();
				cart_item.setProductID(id_product);
				cart_item.setId_cart(rs.getInt("id_cart"));
				cart_item.setQuantity_cart(rs.getInt("quantity"));
				cart_item.setName(product.getName());
				cart_item.setImage(product.getImage());
				cart_item.setQuantity(product.getQuantity());

				ls.add(cart_item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ls;
	}

	public static void main(String[] args) {
		Connection conn = DBConnection.CreateConnection();
		List<CartItem> ls = CartDAO.getAllCartItemByUserID(conn, 4);
		for (CartItem c : ls) {
			System.out.println(c.getImage());
		}
	}
}
