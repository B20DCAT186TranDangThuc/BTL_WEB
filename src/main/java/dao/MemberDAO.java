package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Employee;
import bean.Member;

public class MemberDAO {

	public static int getNumMember(Connection conn) {
		int name = 0;
		String sql = "SELECT COUNT(*) as usernum FROM member";

		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);

			ResultSet rs = ptmt.executeQuery();
			if (rs.next()) {
				name = rs.getInt("usernum");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return name;
	}

	public static Member getMember(Connection conn, int id_user) {
		Member member = new Member();
		String sql = "SELECT * FROM user AS m LEFT Join member AS u ON m.id_user = u.id_user WHERE m.id_user = ?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, id_user);
			ResultSet rs = ptmt.executeQuery();
			if (rs.next()) {
				member.setId_user(id_user);
				member.setNameuser(rs.getString("name_user"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));;
				member.setDob(rs.getDate("dob"));
				member.setPhone(rs.getString("phone"));
				member.setSalary(rs.getLong("salary"));
				member.setGender(rs.getString("gender"));
				System.out.println(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return member;
	}

	public static int insertMember(Connection conn, Member mem, String uname) {
		int state = 0;
//		String sql = "INSERT INTO member(name, email, address, dob, account_id) VALUES (?, ?, ?, ?, ?)";
//
//		int accountid = AccountDAO.getAccountID(conn, uname);
//		if (accountid <= 1) {
//			return state;
//		}
//
//		try {
//			PreparedStatement ptmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//			ptmt.setString(1, mem.getName());
//			ptmt.setString(2, mem.getEmail());
//			ptmt.setString(3, mem.getAddress());
//			ptmt.setString(4, mem.getDob());
//			ptmt.setInt(5, accountid);
//
//			int kt = ptmt.executeUpdate();
//
//			if (kt > 0) {
//				ResultSet generatedKeys = ptmt.getGeneratedKeys();
//				if (generatedKeys.next()) {
//					// Lấy khóa sinh tự động (nếu có)
//					int memberId = generatedKeys.getInt(1);
//					state = memberId;
//				}
//			}
//
//			ptmt.close();
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
		return state;
	}

	public static boolean updateMember(Connection conn, Employee e) {
		boolean kt = false;
//		String sql = "UPDATE member SET name = ?, email = ?, address = ?, dob = ? WHERE id = ?";
//
//		try {
//			PreparedStatement ptmt = conn.prepareStatement(sql);
//			ptmt.setString(1, e.getName());
//			ptmt.setString(2, e.getEmail());
//			ptmt.setString(3, e.getAddress());
//			ptmt.setString(4, e.getDob());
//			ptmt.setInt(5, e.getMemberID());
//
//			int check = ptmt.executeUpdate();
//			if (check > 0) {
//				kt = true;
//			}
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		return kt;
	}
}
