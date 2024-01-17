package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBConnection;

@WebServlet("/AddEmployeeController")
public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddEmployeeController() {
		super();
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
		if (request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("UTF-8");
		}
		int roleID = Integer.parseInt(request.getParameter("role"));

//		User acc = new User();
//		acc.setUser(request.getParameter("username"));
//		acc.setPass(request.getParameter("password"));
//		acc.setRoleID(roleID);
//
//		Employee e = new Employee();
//		e.setName(request.getParameter("name"));
//		e.setDob(request.getParameter("birthday"));
//		e.setAddress(request.getParameter("address"));
//		e.setEmail(request.getParameter("email"));
//		e.setSalary(Double.parseDouble(request.getParameter("salary")));
//		e.setJob(roleID);
//		e.setAccount(acc);

//		int kt = EmployeeDAO.insertEmployee(conn, e);
		int kt = 1;

		if (kt > 0) {
			String message = "Thêm thành công";
			request.setAttribute("msg", message);

		} else {
			String message = "Lỗi hệ thống";
			request.setAttribute("msg", message);

		}
		request.getRequestDispatcher("view/admin/add-employee.jsp").forward(request, response);
		DBConnection.closeConnection(conn);
	}

}
