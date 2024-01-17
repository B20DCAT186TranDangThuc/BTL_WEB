package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Employee;

public class EmployeeDAO {
	public static List<Employee> getAllEmployee(Connection conn) {
		List<Employee> lisEmployees = new ArrayList<>();
		String sql = "SELECT U.id_user, U.name_user,U.user_name, M.dob,M.email,M.address,M.salary,P.per_user FROM permision P\r\n"
				+ "				 Join user U ON P.id_user=U.id_user\r\n"
				+ "                 LEFT Join member M  ON M.id_user= U.id_user\r\n"
				+ "				 where P.per_user!=4 and P.per_user!=1";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("id_user"));
				employee.setUsername(rs.getString("user_name"));
				employee.setNameuser(rs.getString("name_user"));
				employee.setDob(rs.getDate("dob"));
				employee.setEmail(rs.getString("email"));
				employee.setAddress(rs.getString("address"));
				employee.setPosition(rs.getInt("per_user"));
				employee.setSalary(rs.getLong("salary"));

				lisEmployees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(lisEmployees);
		return lisEmployees;
	}

	public static Employee getAllEmployeeById(Connection conn, int id_user) {
		Employee employee = new Employee();
		String sql = "SELECT * FROM permision P Join user U ON P.id_user=U.id_user LEFT Join member M  ON M.id_user= U.id_user where P.id_user= ?";
		try (PreparedStatement ptmt = conn.prepareStatement(sql)) {
			ptmt.setInt(1, id_user);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				employee.setId(rs.getInt("id_user"));
				employee.setNameuser(rs.getString("name_user"));
				employee.setUsername(rs.getString("user_name"));
				employee.setDob(rs.getDate("dob"));
				employee.setEmail(rs.getString("email"));
				employee.setAddress(rs.getString("address"));
				employee.setPhone(rs.getString("phone"));
				employee.setSalary(rs.getLong("salary"));
				employee.setPosition(rs.getInt("per_user"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("EmployeeDAO.java: " + employee);
		return employee;
	}

	public static List<Employee> getAllEmployeeWithFilter(Connection conn, int sort, String sortType, String search) {
		String tSearch;
		if (sort == 1)
			tSearch = "1";
		else if (sort == 2)
			tSearch = "name_user";
		else if (sort == 3)
			tSearch = "name_user";
		else if (sort == 4)
			tSearch = "name_user";
		else if (sort == 5)
			tSearch = "name_user";
		else if (sort == 6)
			tSearch = "name_user";
		else if (sort == 7)
			tSearch = "name_user";

		List<Employee> lisEmployees = new ArrayList<>();
		String sql = "SELECT U.id_user, U.name_user, M.dob, M.email, M.address, M.salary, P.per_user "
				+ "FROM permision P " + "JOIN user U ON P.id_user = U.id_user "
				+ "LEFT JOIN member M ON M.id_user = U.id_user " + "WHERE per_user != 4 AND ? LIKE ? ORDER BY ? ?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("id_user"));
				employee.setNameuser(rs.getString("name_user"));
				employee.setDob(rs.getDate("dob"));
				employee.setEmail(rs.getString("email"));
				employee.setAddress(rs.getString("address"));
				employee.setPosition(rs.getInt("per_user"));
				employee.setSalary(rs.getLong("salary"));

				lisEmployees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(lisEmployees);
		return lisEmployees;
	}

	public static boolean updateMember(Connection conn, Employee employee, int id_user) {
		boolean kt = false;
		String sql = "";
		if (employee.getPassword() != "") {
			sql = "UPDATE user AS m \r\n" + "		Join member AS u ON m.id_user = u.id_user \r\n"
					+ "Join permision P  ON P.id_user=m.id_user \r\n" + "				SET m.password= '"
					+ employee.getPassword() + "',m.name_user = '" + employee.getNameuser() + "', u.email = '"
					+ employee.getEmail() + "',u.salary='" + employee.getSalary() + "',m.user_name='"
					+ employee.getUsername() + "',P.per_user= '" + employee.getPosition() + "'\r\n"
					+ "				where m.id_user= " + id_user;
		} else {
			sql = "UPDATE user AS m \r\n" + "		Join member AS u ON m.id_user = u.id_user \r\n"
					+ "Join permision P  ON P.id_user=m.id_user \\r\\n" + "				SET m.name_user = '"
					+ employee.getNameuser() + "', u.email = '" + employee.getEmail() + "', u.address = '"
					+ employee.getAddress() + "', u.dob = '" + employee.getDob() + "',m.salary='" + employee.getSalary()
					+ "',u.user_name='" + employee.getUsername() + "',P.per_user= '" + employee.getPosition() + "'\r\n"
					+ "				where m.id_user= " + id_user;
		}
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			System.out.println(sql);
			int check = ptmt.executeUpdate();
			if (check > 0) {
				kt = true;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return kt;
	}

	public static int deleteEmployee(Connection conn, int id) {
		String sql = "DELETE FROM user WHERE id_user =" + id;
		int state = -1;
		try (PreparedStatement ptmt = conn.prepareStatement(sql)) {
			System.out.print(sql);
			int rowsAffected = ptmt.executeUpdate();
			if (rowsAffected > 0) {
				state = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
//	public static List<Employee> getAllEmployeeByName(Connection conn, String name) {
//		List<Employee> ls = new ArrayList<>();
//		String sql = "SELECT employee.accountID, employee.memberID, employee.salary,\r\n"
//				+ "	member.name, member.email, member.address, member.dob,\r\n"
//				+ "    account.user, account.pass, account.roleID\r\n" + "FROM employee \r\n"
//				+ "JOIN member ON employee.memberID = member.id \r\n"
//				+ "JOIN account ON employee.accountID = account.accountID \r\n" + "WHERE member.name LIKE ?";
//
//		try {
//			PreparedStatement ptmt = conn.prepareStatement(sql);
//			ptmt.setString(1, "%" + name + "%");
//			ResultSet rs = ptmt.executeQuery();
//			while (rs.next()) {
//				Employee e = new Employee();
//				int accountID = rs.getInt("accountID");
//				int memberID = rs.getInt("memberID");
//				double salary = rs.getDouble("salary");
//				String name2 = rs.getString("name");
//				String address = rs.getString("address");
//				String email = rs.getString("email");
//				String dob = rs.getString("dob");
//				int roleId = rs.getInt("roleId");
//				e.setMemberID(memberID);
//				e.setName(name2);
//				e.setSalary(salary);
//				e.setAddress(address);
//				e.setEmail(email);
//				e.setDob(dob);
//				e.setJob(roleId);
//				User acc = new User();
//				acc.setAccountID(accountID);
//				acc.setUser(rs.getString("user"));
//				acc.setPass(rs.getString("pass"));
//				acc.setRoleID(roleId);
//				e.setAccount(acc);
//				System.out.println(e);
//				ls.add(e);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return ls;
//	}

//	public static Employee selectOne(Connection conn, int memberID) {
//		Employee e = null;
//		String sql = "SELECT employee.accountID, employee.memberID, employee.salary,\r\n"
//				+ "	member.name, member.email, member.address, member.dob,\r\n"
//				+ "    account.user, account.pass, account.roleID\r\n" + "FROM employee \r\n"
//				+ "JOIN member ON employee.memberID = member.id \r\n"
//				+ "JOIN account ON employee.accountID = account.accountID\r\n" + "WHERE memberID = ?";
//		try {
//			PreparedStatement ptmt = conn.prepareStatement(sql);
//			ptmt.setInt(1, memberID);
//
//			ResultSet rs = ptmt.executeQuery();
//			if (rs.next()) {
//				e = new Employee();
//				int accountID = rs.getInt("accountID");
//				double salary = rs.getDouble("salary");
//				String name = rs.getString("name");
//				String address = rs.getString("address");
//				String email = rs.getString("email");
//				String dob = rs.getString("dob");
//				int roleId = rs.getInt("roleId");
//				e.setMemberID(memberID);
//				e.setName(name);
//				e.setSalary(salary);
//				e.setAddress(address);
//				e.setEmail(email);
//				e.setDob(dob);
//				e.setJob(roleId);
//				User acc = new User();
//				acc.setAccountID(accountID);
//				acc.setUser(rs.getString("user"));
//				acc.setPass(rs.getString("pass"));
//				acc.setRoleID(roleId);
//				e.setAccount(acc);
//			}
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		return e;
//	}

//	public static boolean updateEmployee(Connection conn, Employee e) {
//		boolean kt = false;
//		String sql = "UPDATE employee SET salary = ? WHERE memberID = ?";
//		try {
//			PreparedStatement ptmt = conn.prepareStatement(sql);
//			ptmt.setDouble(1, e.getSalary());
//			ptmt.setInt(2, e.getMemberID());
//
//			int checkEployee = ptmt.executeUpdate();
//			boolean checkMember = MemberDAO.updateMember(conn, e);
//			boolean checkAccount = AccountDAO.updateAccount(conn, e);
//			if (checkEployee > 0 && checkMember && checkAccount) {
//				kt = true;
//			}
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		return kt;
//	}
//
//	public static int insertEmployee(Connection conn, Employee e) {
//		int state = 0;
//		User acc = new User();
//		acc.setUser(e.getAccount().getUser());
//		acc.setPass(e.getAccount().getPass());
//		acc.setRoleID(e.getAccount().getRoleID());
//		int accountID = AccountDAO.insertAccount(conn, acc);
//		int memberID = MemberDAO.insertMember(conn, e, acc.getUser());
//
//		if (accountID <= 1 && memberID < 1) {
//			return state;
//		}
//		String sql = "INSERT INTO employee (accountID, memberID, salary) VALUES (?, ?, ?)";
//
//		try {
//			PreparedStatement ptmt = conn.prepareStatement(sql);
//			ptmt.setInt(1, accountID);
//			ptmt.setInt(2, memberID);
//			ptmt.setDouble(3, e.getSalary());
//
//			int kt = ptmt.executeUpdate();
//			if (kt > 0) {
//				state = 1;
//			}
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		return state;
//	}

}
