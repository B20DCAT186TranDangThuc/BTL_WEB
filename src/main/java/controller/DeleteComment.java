package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Comment;
import bean.User;
import dao.CommentDAO;
import db.DBConnection;

@WebServlet("/deletecomment")
public class DeleteComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteComment() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processDelete(request, response);

	}

	private void processDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id_comment = request.getParameter("id_comment");
		Connection conn = DBConnection.CreateConnection();
		boolean check = CommentDAO.deleteCommentById(conn, id_comment);
		request.setAttribute("check", check);
		response.sendRedirect("AdminCommentForward");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processDelete(request, response);
	}

}
