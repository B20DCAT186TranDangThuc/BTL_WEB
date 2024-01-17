package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Product;

public class ProductDAO {
	public static int getCountAllProduct(Connection conn) {
		int count = 0;
		String sql = "SELECT count(*) as count FROM product";

		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public static int getCountAllQuantityProduct(Connection conn) {
		int count = 0;
		String sql = "SELECT SUM(quantity_product) as sum FROM product";

		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("sum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public static List<Product> getAllProduct(Connection conn) {
		List<Product> ls = new ArrayList<>();
		String sql = "SELECT id_product,name_product,price_product,quantity_product,name_category,description_product FROM product JOIN category on product.id_category = category.id_category;";

		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				int id = rs.getInt("id_product");
				p.setProductID(id);
				p.setName(rs.getString("name_product"));
				p.setCategory(rs.getString("name_category"));
				p.setPrice(rs.getLong("price_product"));
				p.setQuantity(rs.getInt("quantity_product"));
				p.setDescription(rs.getString("description_product"));
				p.setImage(imageSrcs(conn, id));
				ls.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(ls);
		return ls;
	}

	public static ArrayList<String> imageSrcs(Connection conn, int id) {
		ArrayList<String> listImage = new ArrayList<>();
		String sql = "SELECT image_link FROM image_product WHERE id_product = ?";
		try (PreparedStatement ptmt = conn.prepareStatement(sql)) {
			ptmt.setInt(1, id);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				listImage.add(rs.getString("image_link"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listImage;
	}

	public static int themProduct(Connection conn, Product product) {
		String sql = "INSERT INTO product (name_product, price_product, id_category, quantity_product, description_product) VALUES (?,?,?,?,?)";
		int state = -1;
		try (PreparedStatement ptmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			ptmt.setString(1, product.getName());
			ptmt.setLong(2, product.getPrice());
			int id_category = CategoryDAO.getIdCategory(conn, product.getCategory());
			ptmt.setInt(3, id_category);
			ptmt.setInt(4, product.getQuantity());
			ptmt.setString(5, product.getDescription());
			int kt = ptmt.executeUpdate();
			if (kt > 0) {
				ResultSet generatedKeys = ptmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					int sk = generatedKeys.getInt(1);
					state = themImage(conn, sk, product.getImage());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}

	public static int themImage(Connection conn, int id_product, ArrayList<String> listImage) {
		String sql = "INSERT INTO image_product (id_product, image_link) VALUES (?, ?)";
		ArrayList<Integer> state = new ArrayList<>();
		for (String imageSrc : listImage) {
			try (PreparedStatement ptmt = conn.prepareStatement(sql)) {
				ptmt.setInt(1, id_product);
				ptmt.setString(2, imageSrc);
				int rowsAffected = ptmt.executeUpdate();
				if (rowsAffected <= 0) {
					state.add(listImage.indexOf(imageSrc) + 1);
				}
				System.out.println("Thêm ảnh: " + imageSrc);
			} catch (SQLException e) {
				e.printStackTrace();
				state.add(listImage.indexOf(imageSrc) + 1);
			}
		}
		if (state.size() > 0) {
			System.out.println(state);
			return -1;
		}
		return 1;
	}

	public static int xoaProduct(Connection conn, int id_product) {
		int state = -1;
		String sql = "DELETE FROM product WHERE id_product = ?";
		try (PreparedStatement ptmt = conn.prepareStatement(sql)) {
			ptmt.setInt(1, id_product);
			int rowsAffected = ptmt.executeUpdate();
			if (rowsAffected > 0) {
				state = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}

	public static List<Product> getListRandomProductbyCategoryID(Connection conn, int id_category) {
		List<Product> ls = new ArrayList<>();
		String sql = "SELECT id_product,name_product,price_product FROM product JOIN category on product.id_category = category.id_category WHERE product.id_category = ? ORDER BY RAND() LIMIT 5";

		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, id_category);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				int id = rs.getInt("id_product");
				p.setProductID(id);
				p.setName(rs.getString("name_product"));
				p.setPrice(rs.getLong("price_product"));
				p.setImage(imageSrcs(conn, id));
				ls.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(ls);
		return ls;
	}

	public static Product getProductById(Connection conn, int product_id) {
		Product pr = null;
		String sql = "SELECT * FROM product WHERE id_product = ?";
		try (PreparedStatement ptmt = conn.prepareStatement(sql)) {
			ptmt.setInt(1, product_id);
			ResultSet rs = ptmt.executeQuery();
			if (rs.next()) {
				pr = new Product();
				pr.setProductID(product_id);
				pr.setName(rs.getString("name_product"));
				pr.setCategory_id(rs.getInt("id_category"));
				;
				pr.setPrice(rs.getLong("price_product"));
				pr.setQuantity(rs.getInt("quantity_product"));
				pr.setDescription(rs.getString("description_product"));
				pr.setImage(imageSrcs(conn, product_id));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(pr);
		return pr;

	}

	public static int updateProduct(Connection conn, Product P, int product_id) {
		int kt = 0;
		String sql = "UPDATE product SET name_product = ?, price_product  = ?, quantity_product = ?, description_product = ? WHERE id_product = ?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, P.getName());
			ptmt.setLong(2, P.getPrice());
			ptmt.setInt(3, P.getQuantity());
			ptmt.setString(4, P.getDescription());
			ptmt.setInt(5, product_id);
			System.out.println(ptmt.toString());
			kt = ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kt;
	}
}
