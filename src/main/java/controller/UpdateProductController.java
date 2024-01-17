package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDetailDAO;
import dao.ProductDAO;
import db.DBConnection;

@WebServlet("/UpdateProductController")
public class UpdateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateProductController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Connection conn= DBConnection.CreateConnection();
		int id_product=Integer.parseInt(request.getParameter("id_product")) ;
		request.setAttribute("product", ProductDAO.getProductById(conn, id_product));
		request.setAttribute("quantity", OrderDetailDAO.getQuanlityProduct(conn, id_product));
		request.getRequestDispatcher("view/admin/update-product.jsp").forward(request, response);
		
	}

}
