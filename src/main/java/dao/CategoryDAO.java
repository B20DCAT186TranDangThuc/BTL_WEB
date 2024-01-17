package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Category;

public class CategoryDAO {

	public static List<Category> getListCategory(Connection conn) {
		List<Category> ls = new ArrayList<>();
		String sql = "SELECT * FROM category";

		try (PreparedStatement ptmt = conn.prepareStatement(sql)) {
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				Category p = new Category();
				p.setId(rs.getInt("id_category"));
				p.setName(rs.getString("name_category"));
				ls.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ls;
	}

	public static int getIdCategory(Connection conn, String nameCategory) {
		int id = -1;
		String sql = "SELECT id_category FROM category WHERE name_category like ?";

		try (PreparedStatement ptmt = conn.prepareStatement(sql)) {
			ptmt.setString(1, nameCategory);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt("id_category");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}
}
