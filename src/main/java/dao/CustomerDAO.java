package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Customer;

public class CustomerDAO {
	public static List<Customer> getAllCustomer(Connection conn) {
		List<Customer> list = new ArrayList<>();
		String sql = "SELECT U.id_user, U.name_user,U.user_name, M.dob, M.email, M.address, M.phone FROM permision P Join user U ON P.id_user=U.id_user LEFT Join member M  ON M.id_user= U.id_user where P.per_user=4";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				Customer p = new Customer();
				p.setId(rs.getInt("id_user"));
				p.setNameuser(rs.getString("name_user"));
				p.setUsername(rs.getString("user_name"));
				p.setDob(rs.getDate("dob"));
				p.setEmail(rs.getString("email"));
				p.setAddress(rs.getString("address"));
				p.setPhone(rs.getString("phone"));

				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(list);
		return list;
	}

	public static int deleteCustomer(Connection conn, int id) {
		String sql = "DELETE FROM user WHERE id_user =" + id;
		int state = -1;
		try (PreparedStatement ptmt = conn.prepareStatement(sql)) {
			System.out.println("CustomerDAO.java: DELETE:" + id);
			int rowsAffected = ptmt.executeUpdate();
			if (rowsAffected > 0) {
				state = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}

	public static List<Customer> getAllCustomerWithFilter(Connection conn, int sort, String search,String sort_type) {
		String text = "";
		switch (sort) {
		case 1: 
			text="name_user";
			break;
		case 2: 
			text="user_name";
			break;
		case 3: 
			text="dob";
			break;
		case 4: 
			text="email";
			break;
		case 5: 
			text="address";
			break;
		case 6: 
			text="phone";
			break;	
		}
			

		List<Customer> listCustomer = new ArrayList<>();
		String sql = "SELECT * FROM qlst_web.permision PR\r\n"
				+ "Join qlst_web.user U LEFT Join qlst_web.member M ON M.id_user= U.id_user\r\n"
				+ "where per_user=4 and PR.id_user=U.id_user and U.name_user LIKE ? ORDER BY "+text+" "+sort_type;
		
		try (PreparedStatement ptmt = conn.prepareStatement(sql)) {
			ptmt.setString(1, "%"+search+"%");
		
			
			ResultSet rs = ptmt.executeQuery();
			System.out.println(ptmt.toString());
			while (rs.next()) {
				Customer p = new Customer();
				p.setId(rs.getInt("id_user"));
				p.setNameuser(rs.getString("name_user"));
				p.setUsername(rs.getString("user_name"));
				p.setDob(rs.getDate("dob"));
				p.setEmail(rs.getString("email"));
				p.setAddress(rs.getString("address"));
				p.setPhone(rs.getString("phone"));
				listCustomer.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("CustomerDAO.java: " + listCustomer);
		return listCustomer;
	}
}
