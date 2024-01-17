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
import dao.UserDAO;
import db.DBConnection;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("HomeForward");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		String uname = request.getParameter("your_name");
		String upass = request.getParameter("your_pass");
//		upass = BcryptUtil.hashPassword(upass);
		HttpSession session = request.getSession();
		session.removeAttribute("msg");
		User user = UserDAO.loginUser(conn, uname, upass);
		if (user.getUser() != null) {
			user.setPermission(UserDAO.getPermission(conn, user.getId()));
			session.setAttribute("msg", "Đăng Nhập Thành Công");
			session.setAttribute("user", user);

		} else {
			session.setAttribute("msg", "Vui Lòng Đăng Nhập Lại");
			user = new User();
		}
		System.out.println("LoginController.java: " + user);
		DBConnection.closeConnection(conn);
		response.sendRedirect("LoginForward");
	}

}
