package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import dao.ProductDAO;
import db.DBConnection;

@WebServlet("/AddProductController")
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddProductController() {
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
		if (request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("UTF-8");
		}
		HttpSession session = request.getSession();
		ArrayList<String> listImage = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			String imageSrc = request.getParameter("image" + i);
			if (imageSrc.length() > 0) {
				listImage.add(imageSrc);
			}
		}
		Product product = new Product();
		product.setName(request.getParameter("name"));
		product.setCategory(request.getParameter("category"));
		long price = Long.parseLong(request.getParameter("price").replaceAll(",", ""));
		product.setPrice(price);
		product.setSale(Integer.parseInt(request.getParameter("sale")));
		product.setImage(listImage);
		product.setQuantity(Integer.parseInt(request.getParameter("total")));
		product.setDescription(request.getParameter("description"));
		System.out.println(product);
		Connection conn = DBConnection.CreateConnection();
		if (ProductDAO.themProduct(conn, product) == 1) {
			session.setAttribute("addProduct", "Thêm Thành Công");
		} else {
			session.setAttribute("addProduct", "Thêm Thất Bại");
		}
		listImage.clear();
		response.sendRedirect("AdminProductForward");
	}
}
