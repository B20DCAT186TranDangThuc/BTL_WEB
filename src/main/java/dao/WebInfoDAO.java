package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WebInfoDAO {

	public static int addGoWeb(Connection conn, int numGo) {
		String sql = "INSERT INTO visitor (ip_address) VALUES (?)";

		try {
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setInt(1, numGo);
				int rowsAffected = preparedStatement.executeUpdate();
				return rowsAffected;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static int getGoWeb(Connection conn) {
		int numGo = 0;
		String sql = "SELECT ip_address FROM visitor order by id_visitors DESC limit 1";

		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			if (rs.next()) {
				numGo = rs.getInt("ip_address");
			}
			rs.close();
			ptmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return numGo;
	}

}
