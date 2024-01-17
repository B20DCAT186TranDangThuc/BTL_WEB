package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.OrderDetail;
import bean.Product;

public class OrderDetailDAO {
	public static OrderDetail getOrderDetail(Connection conn, int id_order) {
		String sql = "SELECT * FROM qlst_web.order_item OI\r\n" + "Join `order` O ON O.id_order=OI.id_order\r\n"
				+ "Join user U ON O.id_user=U.id_user\r\n" + "where O.id_order=" + id_order;
		OrderDetail O = new OrderDetail();
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();

			List<Product> l = new ArrayList<>();
			List<Integer> quanlitys = new ArrayList<>();
			while (rs.next()) {
				O.setIdOder(rs.getInt("id_order"));
				O.setNameCustomer(rs.getString("name_user"));
				O.setAddress(rs.getString("address"));
				int status = Integer.parseInt(rs.getString("status"));
				if (status == 0) {
//					O.setStatus("Chưa duyệt");
					O.setStatus(false);
				} else {
//					O.setStatus("Đã duyệt");
					O.setStatus(true);
				}
				O.setTimeCreate(rs.getDate("time"));
				Product p = ProductDAO.getProductById(conn, rs.getInt("id_product"));
				l.add(p);
				quanlitys.add(rs.getInt("quantity"));
			}
			O.setProducts(l);
			O.setQuanlity(quanlitys);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return O;

	}

	public static int getQuanlityProduct(Connection conn, int id_product) {
		String sql = "select sum(quantity) AS quantity from order_item where id_order=" + id_product;
		int sl = 0;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				sl = rs.getInt("quantity");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sl;

	}
}
