package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutForward")
public class LogoutForward extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogoutForward() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session != null) {
			session.removeAttribute("fullname"); // Xóa session fullname
			session.removeAttribute("roleID"); // Xóa session roleID
			session.invalidate(); // Hủy bỏ toàn bộ session
		}
		response.sendRedirect("HomeForward");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
