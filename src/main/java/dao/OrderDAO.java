package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bean.Order;

public class OrderDAO {

	public static List<Order> getPendingOrder(Connection conn) {
		List<Order> list = new ArrayList<>();
		String sql = "SELECT * FROM qlst_web.order O Join qlst_web.user U ON O.id_user=U.id_user";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(sql);
			ResultSet resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				Order o = new Order();
				o.setId_order(resultset.getInt("id_order"));
				o.setName_customer(resultset.getString("name_user"));;
				o.setAddress(resultset.getString("address_order"));
				o.setPrice(resultset.getLong("price"));
				o.setTime(resultset.getDate("time"));
				int status = resultset.getInt("status");
				if (status == 0) {
//					o.setStatus("Chưa duyệt");
					o.setStatus(false);
				} else {
//					o.setStatus("Đã duyệt");
					o.setStatus(true);
				}
				list.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static List<Order> getOrderByFilter(Connection conn, int status1, String text) {
		List<Order> list = new ArrayList<>();
		String sql = "";
		if (status1 == 3) {
			sql = "SELECT * FROM qlst_web.order O\r\n" + "Join qlst_web.user U ON O.id_user=U.id_user\r\n"
					+ "where U.name_user like '%" + text + "%' or O.address like '%" + text + "%'";
		} else {
			sql = "SELECT * FROM qlst_web.order O\r\n" + "Join qlst_web.user U ON O.id_user=U.id_user\r\n"
					+ "where O.status=" + status1 + " and (U.name_user like '%" + text + "%' or O.address like '%"
					+ text + "%')";
		}
		PreparedStatement preparedStatement;
		System.out.println(sql);
		try {
			preparedStatement = conn.prepareStatement(sql);
			ResultSet resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				Order o = new Order();
				o.setId_order(Integer.parseInt(resultset.getString("id_order")));
				o.setName_customer(resultset.getString("name_user"));
				o.setAddress(resultset.getString("address"));
				o.setPrice(Long.parseLong(resultset.getString("price")));
				o.setTime(resultset.getDate("time"));
				int status = Integer.parseInt(resultset.getString("status"));
				if (status == 0) {
//					o.setStatus("Chưa duyệt");
					o.setStatus(false);
				} else {
//					o.setStatus("Đã duyệt");
					o.setStatus(true);
				}
				list.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static int approving(Connection conn, int id_order) {
		String sql = "UPDATE `qlst_web`.`order` SET `status` = 1 WHERE `id_order` = " + id_order;
		System.out.println(sql);
		int kt = 0;
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(sql);	
			kt = preparedStatement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kt;
	}

	public static int DeleteOrder(Connection conn, int id_order) {
		String sql = "DELETE From qlst_web.order WHERE id_order = " + id_order;
		System.out.println(sql);
		int kt = 0;
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(sql);
			kt = preparedStatement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kt;
	}

	public static int createOrder(Connection conn, Order order) {
		String sql = "INSERT INTO `qlst_web.order` (id_user, status, name_order, address_order, phone_order, price, time) VALUES (?, ?, ?, ?, ?, ?, ?);";
		int orderId = -1;

		try (PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			statement.setInt(1, order.getId_order());
			statement.setInt(2, 0);
			statement.setString(3, order.getName_customer());
			statement.setString(4, order.getAddress());
			statement.setString(5, order.getPhone());
			statement.setLong(6, order.getPrice());
			statement.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
			int rowsAffected = statement.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet generatedKeys = statement.getGeneratedKeys();
				if (generatedKeys.next()) {
					orderId = generatedKeys.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderId; // Trả về order_id, -1 nếu có lỗi hoặc không tạo được đơn hàng
	}

	public static boolean createOrderItem(Connection conn, int product_id, int quantity, long product_total,
			int order_product) {
		String sql = "INSERT INTO qlst_web.order_item (id_order, id_product, price, quantity) VALUES (?, ?, ?, ?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, order_product);
			stmt.setInt(2, product_id);
			stmt.setLong(3, product_total);
			stmt.setInt(4, quantity);

			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
				return true; // Trả về true nếu tạo mục đơn hàng thành công
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false; // Trả về false nếu có lỗi xảy ra hoặc không tạo được mục đơn hàng
	}

}
