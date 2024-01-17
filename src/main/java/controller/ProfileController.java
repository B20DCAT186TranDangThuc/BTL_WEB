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
import util.UserUtil;

@WebServlet("/ProfileController")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProfileController() {
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
		if (request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("UTF-8");
		}

		User user = new User();
		user.setName(request.getParameter("nameuser"));
		user.setUser(request.getParameter("username"));
		user.setPass(request.getParameter("password"));
		String code = request.getParameter("code_market");
		HttpSession session = request.getSession();

//		Kiểm tra tài khoản tồn tại trong hệ thống chưa
		if (!UserDAO.checkUser(conn, request.getParameter("username"))) {
			int state = UserDAO.insertUser(conn, user);
			if (state > 1) {
				int state2 = UserDAO.setRole(conn, state, UserUtil.Role(code));
				System.out.println(state2);
				if (state2 > 1) {
					session.setAttribute("msg", "Đăng Ký Thành Công");
				} else {
					session.setAttribute("msg", "Lỗi Hệ Thống");
				}
			}
		} else {
			session.setAttribute("msg", "Tài Khoản Tồn Tại!");
		}

		response.sendRedirect("RegisterForward");
		DBConnection.closeConnection(conn);
	}

}
