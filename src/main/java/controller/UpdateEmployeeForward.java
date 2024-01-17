package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import db.DBConnection;

@WebServlet("/UpdateEmployeeForward")
public class UpdateEmployeeForward extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateEmployeeForward() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id_user = Integer.parseInt(request.getParameter("id_user"));
		Connection conn = DBConnection.CreateConnection();
		request.setAttribute("employee", EmployeeDAO.getAllEmployeeById(conn, id_user));
		request.getRequestDispatcher("view/admin/update-employee.jsp").forward(request, response);
		DBConnection.closeConnection(conn);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
