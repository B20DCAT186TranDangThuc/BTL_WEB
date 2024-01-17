package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Category;
import bean.Product;
import dao.CategoryDAO;
import dao.ProductDAO;
import dao.WebInfoDAO;
import db.DBConnection;
import util.UserUtil;

@WebServlet(urlPatterns = "/HomeForward", loadOnStartup = 1)
public class HomeForward extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeForward() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// Auto Login cho nhanh
		UserUtil.autoLogin(request, 1);
////		Đếm số lần truy cập
		Connection conn = DBConnection.CreateConnection();
		Map<String, List<Product>> categoryProduct = getListCategoryProduct(conn);
		request.setAttribute("categoryProduct", categoryProduct);
		WebInfoDAO.addGoWeb(conn, WebInfoDAO.getGoWeb(conn) + 1);
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}

	private Map<String, List<Product>> getListCategoryProduct(Connection conn) {
		Map<String, List<Product>> categoryProduct = new HashMap<String, List<Product>>();

		List<Category> lsCategory = CategoryDAO.getListCategory(conn);

		for (Category ca : lsCategory) {
			List<Product> lsProduct = ProductDAO.getListRandomProductbyCategoryID(conn, 5);
			categoryProduct.put(ca.getName(), lsProduct);
		}
		return categoryProduct;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private String getClientIP(HttpServletRequest request) {
		String ipAddress = request.getHeader("X-Forwarded-For");
		if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
		}
		return ipAddress;
	}

}
