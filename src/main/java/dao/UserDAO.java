package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Employee;
import bean.User;

public class UserDAO {
	public static int insertUser(Connection conn, User user) {
		String sql = "INSERT INTO user (name_user, user_name, password) VALUES (?, ?, ?)";
		int state = -1;
		try (PreparedStatement ptmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			ptmt.setString(1, user.getName());
			ptmt.setString(2, user.getUser());
			ptmt.setString(3, user.getPass());
			int kt = ptmt.executeUpdate();
			if (kt > 0) {
//				Lấy khóa chính sau khi insert dữ liệu vào DB
				ResultSet generatedKeys = ptmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					state = generatedKeys.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}

	public static int setRole(Connection conn, int id_user, int id_per) {
		String sql = "INSERT INTO permision_relationship (id_user_rel, id_per_rel, suspended) VALUES (?, ?, ?)";
		int state = -1;
		try (PreparedStatement ptmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			ptmt.setInt(1, id_user);
			ptmt.setInt(2, id_per);
			ptmt.setInt(3, 0);
			int kt = ptmt.executeUpdate();
			if (kt > 0) {
//				Lấy khóa chính sau khi insert dữ liệu vào DB
				ResultSet generatedKeys = ptmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					state = generatedKeys.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return state;
	}

	public static boolean checkUser(Connection conn, String uname) {
		String sql = "SELECT * FROM user WHERE user_name = ?";
		try (PreparedStatement ptmt = conn.prepareStatement(sql)) {
			ptmt.setString(1, uname);
			try (ResultSet rs = ptmt.executeQuery()) {
				return rs.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static User loginUser(Connection conn, String uname, String upass) {
		User user = new User();
		String sql = "SELECT id_user, name_user, user_name FROM user WHERE user_name = ? and password = ?";
		try (PreparedStatement ptmt = conn.prepareStatement(sql)) {
			ptmt.setString(1, uname);
			ptmt.setString(2, upass);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt("id_user"));
				user.setName(rs.getString("name_user"));
				user.setUser(rs.getString("user_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("UserDao.jaava:" + user);

		return user;
	}

	public static boolean updateAccount(Connection conn, Employee e) {
		boolean kt = false;
//		String sql = "UPDATE account SET user = ?, pass = ?, roleID = ? WHERE accountID = ?";
//
//		try {
//			PreparedStatement ptmt = conn.prepareStatement(sql);
//			ptmt.setString(1, e.getAccount().getUser());
//			ptmt.setString(2, e.getAccount().getPass());
//			ptmt.setInt(3, e.getAccount().getRoleID());
//			ptmt.setInt(4, e.getAccount().getAccountID());
//
//			int check = ptmt.executeUpdate();
//
//			if (check > 0) {
//				kt = true;
//			}
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		return kt;
	}

	public static boolean deleteAccountbyID(Connection conn, int accountID) {
		boolean kt = false;
		String sql = "DELETE FROM account WHERE accountID = ?";

		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, accountID);

			int check = ptmt.executeUpdate();
			if (check > 0) {
				kt = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return kt;
	}

	public static int getPermission(Connection conn, int id_user) {
		String sql = "SELECT per_user FROM permision WHERE id_user = ?";
		try (PreparedStatement ptmt = conn.prepareStatement(sql)) {
			ptmt.setInt(1, id_user);

			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				return rs.getInt("per_user");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 4;
	}

	public static String getNameUser(Connection conn, int id_user) {
		String name = "";
		String sql = "SELECT name_user FROM user WHERE id_user = ?";

		try (PreparedStatement ptmt = conn.prepareStatement(sql)) {
			ptmt.setInt(1, id_user);

			ResultSet rs = ptmt.executeQuery();
			if (rs.next()) {
				name = rs.getString("name_user");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
}
