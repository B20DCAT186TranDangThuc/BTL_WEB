package util;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bean.Member;
import bean.User;
import dao.UserDAO;

public class UserUtil {
	public static int Role(String role) {
		if (role.equals("quanlytoanbosieuthi")) {
			return 1;
		} else if (role.equals("nhanvienbanhangsieuthi")) {
			return 3;
		} else if (role.equals("nhanvienkhosieuthi")) {
			return 2;
		}
		return 4;
	}

	public static boolean checkLogin(Member member) {
		return member.getNameuser() != null;
	}

	public static void autoLogin(HttpServletRequest request, int permission) {
		HttpSession session = request.getSession();
		User user = new User();
		user.setId(1);
		if (permission == 1) {
			user.setName("Admin");
			user.setUser("TK_ADMIN");
		} else {
			user.setName("Khách Hàng");
			user.setUser("TK_KHACHHANG");
		}
		user.setPass("123456");
		user.setPermission(permission);
		session.setAttribute("user", user);
	}
}
