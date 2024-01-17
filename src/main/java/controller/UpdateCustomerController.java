package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Member;
import dao.MemberDAO;
import db.DBConnection;
import util.DateTimeUtil;

/**
 * Servlet implementation class UpdateCustomerController
 */
@WebServlet("/UpdateCustomerController")
public class UpdateCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.CreateConnection();
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		int id_user=Integer.parseInt(request.getParameter("id_user")) ;
		System.out.println(request.getParameter("dob"));
		String name = (request.getParameter("name") != null) ? request.getParameter("name") : "";
		String address = (request.getParameter("address") != null) ? request.getParameter("address") : "";
		Date dob = (request.getParameter("dob") != "") ? Date.valueOf(request.getParameter("dob")) : Date.valueOf("2000-01-01");
		String email = (request.getParameter("email") != null) ? request.getParameter("email") : "";
		String phone = (request.getParameter("phone") != null) ? request.getParameter("phone") : "";
		String password = (request.getParameter("password") != null) ? request.getParameter("password") : "";
		Member m= new Member();
		m.setId(id_user);
		m.setNameuser(name);
		m.setAddress(address);
		m.setDob(dob);
		m.setEmail(email);
		m.setPhone(phone);
		boolean kt = true;
		kt= MemberDAO.updateMember(conn, m, password,id_user);
		
		if (kt) {
			String message = "Cập nhật thành công";
			request.setAttribute("msg", message);

		} else {
			String message = "Cập nhật thất bại";
			request.setAttribute("msg", message);

		}
		request.getRequestDispatcher("view/user/profile.jsp").forward(request, response);
	}

}
