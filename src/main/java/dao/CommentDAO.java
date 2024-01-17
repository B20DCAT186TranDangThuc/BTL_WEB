package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bean.Comment;

public class CommentDAO {

	public static List<Comment> getAllComment(Connection conn) {
		List<Comment> ls = new ArrayList<Comment>();
		String sql = "SELECT c.*, u.name_user FROM comment c JOIN user u ON c.id_user = u.id_user";
		try (PreparedStatement ptmt = conn.prepareStatement(sql)) {
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				Comment cm = new Comment();
				cm.setIdComment(rs.getInt("id_comment"));
				cm.setIdUser(rs.getInt("id_user"));
				cm.setIdProduct(rs.getInt("id_product"));
				cm.setQuestion(rs.getString("question"));
				cm.setTimeQuestion(rs.getString("time_question"));
				cm.setAnswer(rs.getString("answer"));
				cm.setTimeAnswer(rs.getString("time_answer"));
				cm.setRate(rs.getInt("rate"));
				cm.setNameComment(rs.getString("name_user"));
				ls.add(cm);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ls;
	}

	public static int getCountComment(Connection conn) {
		int commentCount = 0;
		String sql = "SELECT COUNT(*) as countCommnet FROM comment";

		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			if (rs.next()) {
				commentCount = rs.getInt("countCommnet");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return commentCount;

	}

	public static List<Comment> getAllCommentOfProduct(Connection conn, int id_product) {
		List<Comment> ls = new ArrayList<Comment>();
		String sql = "SELECT c.*, u.name_user FROM comment c JOIN user u ON c.id_user = u.id_user WHERE c.id_product = ?";

		try (PreparedStatement ptmt = conn.prepareStatement(sql)) {
			ptmt.setInt(1, id_product);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				Comment cm = new Comment();
				cm.setIdComment(rs.getInt("id_comment"));
				cm.setIdUser(rs.getInt("id_user"));
				cm.setIdProduct(rs.getInt("id_product"));
				cm.setQuestion(rs.getString("question"));
				cm.setTimeQuestion(rs.getString("time_question"));
				cm.setAnswer(rs.getString("answer"));
				cm.setTimeAnswer(rs.getString("time_answer"));
				cm.setRate(rs.getInt("rate"));
				cm.setNameComment(rs.getString("name_user"));
				ls.add(cm);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ls;
	}

	public static boolean insertComment(Connection conn, Comment cmt) {
		String sql = "INSERT INTO comment (id_user, question, id_product, time_question, rate) VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, cmt.getIdUser());
			stmt.setString(2, cmt.getQuestion());
			stmt.setInt(3, cmt.getIdProduct());
			stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			stmt.setInt(5, cmt.getRate());
			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static int answearCommnent(Connection conn,int id_comment,String reply) {
		String sql="UPDATE  comment  SET `answer` = ?, time_answer=? WHERE `id_comment` = ?;";
		int kt=0;
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, reply);
			ptmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			ptmt.setInt(3, id_comment);
			
			kt=ptmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kt;
		
	}

	public static boolean deleteCommentById(Connection conn, String id_comment) {
		String sql = "DELETE FROM comment WHERE id_comment = ?";

		try (PreparedStatement ptmt = conn.prepareStatement(sql)) {
			ptmt.setString(1, id_comment);
			int rowsAffected = ptmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

}
