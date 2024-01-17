package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import db.DBConnection;

/**
 * Servlet implementation class SortCustomerForward
 */
@WebServlet("/SortCustomerForward")
public class SortCustomerForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortCustomerForward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.CreateConnection();
		int sort= Integer.parseInt(request.getParameter("sort"));
		String search= request.getParameter("search");
		request.setAttribute("customerList",CustomerDAO.getAllCustomerWithFilter(conn, sort, search));
		request.setAttribute("sort", sort);
		request.getRequestDispatcher("view/admin/admin-customer.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
