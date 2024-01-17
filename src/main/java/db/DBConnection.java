package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static void closeConnection(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			// Xử lý lỗi khi đóng kết nối
			e.printStackTrace();
		}
	}

	public static Connection CreateConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/qlst_web?useUnicode=true&characterEncoding=utf8";
		String username = "root";
		String password = "123456";
		try {
			// load driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
}
