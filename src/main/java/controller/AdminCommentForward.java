package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Comment;
import dao.CommentDAO;
import db.DBConnection;

@WebServlet("/AdminCommentForward")
public class AdminCommentForward extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminCommentForward() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		List<Comment> comments = CommentDAO.getAllComment(conn);
		request.setAttribute("comments", comments);
		request.getRequestDispatcher("view/admin/admin-comment.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
