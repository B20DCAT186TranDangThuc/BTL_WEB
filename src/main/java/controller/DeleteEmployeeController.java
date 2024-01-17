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

@WebServlet("/DeleteEmployeeController")
public class DeleteEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteEmployeeController() {
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
		int id_user=Integer.parseInt(request.getParameter("id_user")) ;
		int kt = EmployeeDAO.deleteEmployee(conn,id_user );
		request.getRequestDispatcher("AdminEmployeeForward").forward(request, response);
		DBConnection.closeConnection(conn);
	}

}
