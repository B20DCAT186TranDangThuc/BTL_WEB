package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Customer;
import db.DBConnection;

@WebServlet("/SearchCustomerController")
public class SearchCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchCustomerController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		String search = request.getParameter("searchCustomer");

//		List<Customer> list = CustomerDAO.getAllCustomerByName(conn, search);
		List<Customer> list = new ArrayList<>();
		if (list.size() > 0) {
			request.setAttribute("customerList", list);
		} else {
			request.setAttribute("msg", "Không có nhân viên nào");
		}

		request.getRequestDispatcher("view/admin/admin-employee.jsp").forward(request, response);

		DBConnection.closeConnection(conn);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
