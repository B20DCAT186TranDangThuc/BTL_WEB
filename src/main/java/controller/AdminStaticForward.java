package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.CommentDAO;
import dao.MemberDAO;
import dao.ProductDAO;
import dao.WebInfoDAO;
import db.DBConnection;

@WebServlet("/AdminStaticForward")
public class AdminStaticForward extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminStaticForward() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		request.setAttribute("usercount", MemberDAO.getNumMember(conn));
		request.setAttribute("productcount", ProductDAO.getCountAllProduct(conn));
		request.setAttribute("stockproductcount", ProductDAO.getCountAllQuantityProduct(conn));
		request.setAttribute("connectcount", WebInfoDAO.getGoWeb(conn));
		request.setAttribute("buycount", CommentDAO.getCountComment(conn));
		request.setAttribute("commentcount", CommentDAO.getCountComment(conn));
		request.setAttribute("category", CategoryDAO.getListCategory(conn));
		request.getRequestDispatcher("view/admin/admin-static.jsp").forward(request, response);
		DBConnection.closeConnection(conn);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
