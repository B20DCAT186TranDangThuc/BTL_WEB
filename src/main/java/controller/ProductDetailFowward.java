package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Comment;
import bean.Product;
import dao.CommentDAO;
import dao.ProductDAO;
import dao.UserDAO;
import db.DBConnection;

@WebServlet("/ProductDetailFowward")
public class ProductDetailFowward extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductDetailFowward() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		int product_id = Integer.parseInt(request.getParameter("product_id"));

		Product pr = ProductDAO.getProductById(conn, product_id);
		List<Comment> listComment = getCommentUser(conn, product_id);
		double avgRate = getAvgRate(listComment);
		List<Product> listOtherProduct = getOtherProduct(conn, pr.getCategory_id());

		request.setAttribute("product", pr);
		request.setAttribute("listComment", listComment);
		request.setAttribute("avgRate", avgRate);
		request.setAttribute("listOtherProduct", listOtherProduct);

		request.getRequestDispatcher("view/product-detail/product-detail.jsp").forward(request, response);

		DBConnection.closeConnection(conn);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private List<Product> getOtherProduct(Connection con, int category_id) {
		List<Product> ls = ProductDAO.getListRandomProductbyCategoryID(con, category_id);
		ls.remove(0);
		return ls;
	}

	private double getAvgRate(List<Comment> ls) {
	    if (ls == null || ls.isEmpty()) {
	        return 0; // Tránh chia cho 0
	    }

	    double totalRate = 0;
	    for (Comment comment : ls) {
	        totalRate += comment.getRate();
	    }

	    return totalRate / ls.size();
	}

	// bug lớn
	private List<Comment> getCommentUser(Connection conn, int product_id) {

		List<Comment> listComment = CommentDAO.getAllCommentOfProduct(conn, product_id);
		
		return listComment;
	}

}
