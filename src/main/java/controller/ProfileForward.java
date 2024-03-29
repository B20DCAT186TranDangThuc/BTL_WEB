package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.MemberDAO;
import db.DBConnection;

@WebServlet("/ProfileForward")
public class ProfileForward extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProfileForward() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection conn = DBConnection.CreateConnection();
		User user = (User) session.getAttribute("user");
		request.setAttribute("customer", MemberDAO.getMember(conn, user.getId()));
		request.getRequestDispatcher("view/user/profile.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
