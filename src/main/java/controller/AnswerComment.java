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

@WebServlet("/answercomment")
public class AnswerComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AnswerComment() {
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
		request.setCharacterEncoding("UTF-8");
		
		String reply = request.getParameter("reply");
        int id_comment=Integer.parseInt(request.getParameter("id_comment")) ;
        CommentDAO.answearCommnent(conn, id_comment, reply);
        response.sendRedirect("AdminCommentForward");
        DBConnection.closeConnection(conn);
	}

}
