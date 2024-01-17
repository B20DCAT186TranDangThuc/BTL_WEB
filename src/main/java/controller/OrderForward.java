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
import javax.servlet.http.HttpSession;

import bean.Member;
import bean.Product;
import dao.MemberDAO;
import dao.ProductDAO;
import db.DBConnection;

@WebServlet("/OrderForward")
public class OrderForward extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderForward() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		int id_user = Integer.parseInt(request.getParameter("id_user"));
		String[] idProductValues = request.getParameterValues("id_product");
		
		Member member = MemberDAO.getMember(conn, id_user);
		List<Product> listProduct = getListProduct(conn, idProductValues);
		
	    HttpSession session = request.getSession();
	    session.setAttribute("listProduct", listProduct);
	    session.setAttribute("member", member);
	    
		request.getRequestDispatcher("view/order/order.jsp").forward(request, response);
		DBConnection.closeConnection(conn);
	}
	
	private List<Product> getListProduct(Connection conn, String[] idProductValues) {
		int[] idProducts;

		idProducts = new int[idProductValues.length];
		for (int i = 0; i < idProductValues.length; i++) {
			idProducts[i] = Integer.parseInt(idProductValues[i]);
		}
		List<Product> listProduct = new ArrayList<Product>();
		for(int id: idProducts) {
			Product product = ProductDAO.getProductById(conn, id);
			listProduct.add(product);
		}
		return listProduct;
	}
}
