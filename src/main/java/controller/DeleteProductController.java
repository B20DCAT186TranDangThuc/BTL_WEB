package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import db.DBConnection;

@WebServlet("/DeleteProductController")
public class DeleteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteProductController() {
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
		int id = Integer.parseInt(request.getParameter("delete"));
		Connection conn = DBConnection.CreateConnection();
		System.out.println(ProductDAO.xoaProduct(conn, id));
		response.sendRedirect("AdminProductForward");
	}

}
