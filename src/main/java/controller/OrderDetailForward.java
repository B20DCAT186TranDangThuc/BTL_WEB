package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderDetail;
import dao.OrderDetailDAO;
import db.DBConnection;

/**
 * Servlet implementation class OrderDetalForward
 */
@WebServlet("/OrderDetailForward")
public class OrderDetailForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailForward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn= DBConnection.CreateConnection();
		int id_order=Integer.parseInt(request.getParameter("id_order")) ;
		request.setAttribute("OrderDetail", OrderDetailDAO.getOrderDetail(conn, id_order));
		request.getRequestDispatcher("/view/admin/OrderDetail.jsp").forward(request, response);
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
