package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import db.DBConnection;

@WebServlet("/SearchEmployeeForward")
public class SearchEmployeeForward extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchEmployeeForward() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		String search = request.getParameter("search");

//		List<Employee> list = EmployeeDAO.getAllEmployeeByName(conn, search);
		List<Employee> list = new ArrayList<>();

		if (list.size() > 0) {
			request.setAttribute("employeeList", list);
		} else {
			request.setAttribute("msg", "Không có nhân viên nàos");
		}

		request.getRequestDispatcher("view/admin/admin-employee.jsp").forward(request, response);

		DBConnection.closeConnection(conn);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
