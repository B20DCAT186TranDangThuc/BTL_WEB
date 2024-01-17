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

@WebServlet("/AdminCustomerForward")
public class AdminCustomerForward extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminCustomerForward() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		request.setAttribute("customerList", CustomerDAO.getAllCustomer(conn));
		request.getRequestDispatcher("view/admin/admin-customer.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
