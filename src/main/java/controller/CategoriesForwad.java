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

import bean.Product;
import db.DBConnection;

@WebServlet("/CategoriesForwad")
public class CategoriesForwad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CategoriesForwad() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
//		List<Product> list = ProductDAO.selectProductsByTypeID(conn, 5);
		List<Product> list = new ArrayList<>();

		request.setAttribute("productList", list);
		request.getRequestDispatcher("view/categories/categories.jsp").forward(request, response);
		DBConnection.closeConnection(conn);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
