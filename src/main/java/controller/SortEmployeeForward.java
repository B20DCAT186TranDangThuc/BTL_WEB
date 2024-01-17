package controller;

import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import db.DBConnection;

/**
 * Servlet implementation class SortEmployee
 */
@WebServlet("/SortEmployeeForward")
public class SortEmployeeForward extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SortEmployeeForward() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		Connection conn = DBConnection.CreateConnection();
		int sort= Integer.parseInt(request.getParameter("sort"));
		String search= request.getParameter("search");
		request.setAttribute("employeeList",EmployeeDAO.getAllEmployeeWithFilter(conn, sort, search));
		request.setAttribute("sort", sort);
		request.getRequestDispatcher("view/admin/admin-employee.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private static Date parseDate(String dateString) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			return dateFormat.parse(dateString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
