package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import db.DBConnection;

@WebServlet("/AddProductForward")
public class AddProductForward extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddProductForward() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection conn = DBConnection.CreateConnection();
		request.setAttribute("category", CategoryDAO.getListCategory(conn));
		request.getRequestDispatcher("view/admin/add-product.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
