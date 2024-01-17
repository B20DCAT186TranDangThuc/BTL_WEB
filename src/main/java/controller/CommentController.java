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

@WebServlet("/CommentController")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommentController() {
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
		
		String comment = request.getParameter("comment");
        String rating = request.getParameter("rating");
        int product_id = Integer.parseInt(request.getParameter("id_product"));
        HttpSession session = request.getSession();
        User user  = (User) session.getAttribute("user");
        int user_id = user.getId();
        int star = 5;
        
        if(rating != null) {
        	star = Integer.parseInt(rating);
        }
        
        Comment cmt = new Comment();
        cmt.setQuestion(comment);
        cmt.setIdProduct(product_id);
        cmt.setRate(star);
        cmt.setIdUser(user_id);

        boolean checkComment = CommentDAO.insertComment(conn, cmt);
        if(checkComment) {
            // Quay trở lại trang trước đó
            String referer = request.getHeader("referer");
            response.sendRedirect(referer);
        }
        else {
        	// quay lại trang với thông báo lỗi
        }
        
        
        DBConnection.closeConnection(conn);
	}

}
