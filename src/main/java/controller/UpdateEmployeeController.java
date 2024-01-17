package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import dao.EmployeeDAO;
import db.DBConnection;

@WebServlet("/UpdateEmployeeController")
public class UpdateEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateEmployeeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("HomeForward");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();

		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Employee e= new Employee();
		int id_user=Integer.parseInt(request.getParameter("id_user")) ;
		System.out.println(request.getParameter("dob"));
		String name = (request.getParameter("name") != null) ? request.getParameter("name") : "";
		String address = (request.getParameter("address") != null) ? request.getParameter("address") : "";

		String email = (request.getParameter("email") != null) ? request.getParameter("email") : "";
		String password = (request.getParameter("password") != null) ? request.getParameter("password") : "";
		String username = request.getParameter("username");
		Long salary = Long.parseLong(request.getParameter("salary"));
		int roleID = Integer.parseInt(request.getParameter("role"));
		e.setNameuser(name);
		e.setAddress(address);
		e.setEmail(email);
		e.setUsername(username);
		e.setPassword(password);
		e.setRole(roleID);
		e.setSalary(salary);
		e.setId_user(id_user);

//		User acc = new User();
//		acc.setAccountID(accountID);
//		acc.setUser(username);
//		acc.setPass(password);
//		acc.setRoleID(roleID);
//
//		Employee e = new Employee();
//		e.setMemberID(memberID);
//		e.setName(name);
//		e.setDob(birthday);
//		e.setAddress(address);
//		e.setEmail(email);
//		e.setSalary(salary);
//		e.setJob(roleID);
//		e.setAccount(acc);
		boolean kt=false;
		kt = EmployeeDAO.updateMember(conn, e,id_user);

		if (kt) {
			String message = "Cập nhật thành công";
			request.setAttribute("msg", message);
			request.getRequestDispatcher("HomeForward").forward(request, response);

		} else {
			String message = "Cập nhật thất bại";
			request.setAttribute("msg", message);
			request.getRequestDispatcher("view/admin/update-employee.jsp").forward(request, response);
		}

		DBConnection.closeConnection(conn);
	}

}
