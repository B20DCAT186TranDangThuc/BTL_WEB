package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import db.DBConnection;

@WebServlet("/DeleteCustomerController")
public class DeleteCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteCustomerController() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		Connection conn = DBConnection.CreateConnection();
		System.out.println(CustomerDAO.deleteCustomer(conn, id));
		response.sendRedirect("AdminCustomerForward");
	}

}
