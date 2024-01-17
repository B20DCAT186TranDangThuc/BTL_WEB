package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import db.DBConnection;

@WebServlet("/AdminApprovingForward")
public class AdminApprovingForward extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminApprovingForward() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		Connection conn = DBConnection.CreateConnection();
		request.setAttribute("orderlist",OrderDAO.getPendingOrder(conn));
		System.out.println("AdminApprovedForward.java: " + OrderDAO.getPendingOrder(conn));
		request.getRequestDispatcher("view/admin/admin-approving.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
