package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import db.DBConnection;

@WebServlet("/StaticProductController")
public class StaticProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StaticProductController() {
		super();
		// TODO Auto-generated constructor stub
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

		Product e = new Product();
		e.setName(request.getParameter("name_product"));
		long price = Long.parseLong(request.getParameter("price").replaceAll(",", ""));
		e.setPrice(price);
		e.setDescription(request.getParameter("description_product"));

		System.out.println(e);
//		int kt = EmployeeDAO.insertEmployee(conn, e);
//
//		if (kt > 0) {
//			String message = "Thêm thành công";
//			request.setAttribute("msg", message);
//
//		} else {
//			String message = "Lỗi hệ thống";
//			request.setAttribute("msg", message);
//
//		}
		request.getRequestDispatcher("view/admin/admin-product.jsp").forward(request, response);
//		DBConnection.closeConnection(conn);
	}

}
