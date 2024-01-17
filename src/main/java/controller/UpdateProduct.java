package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.DbDoc;

import bean.Product;
import dao.ProductDAO;
import db.DBConnection;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		Connection conn = DBConnection.CreateConnection();
		int id_product = Integer.parseInt(request.getParameter("id_product"));
		Product product = new Product();
		product.setName(request.getParameter("name"));
		product.setPrice(Long.parseLong(request.getParameter("price")));
		product.setDescription(request.getParameter("description"));
		product.setQuantity(Integer.parseInt(request.getParameter("inventory")));
		System.out.println("UpdateProduct.java: " + product);
		ProductDAO.updateProduct(conn, product, id_product);
		response.sendRedirect("AdminProductForward");
	}

}
