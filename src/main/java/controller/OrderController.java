package controller;

import java.io.IOException;
import java.sql.Connection;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Order;
import dao.OrderDAO;
import db.DBConnection;

@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		request.setCharacterEncoding("UTF-8");

		int id_order = createOrder(conn, request);

		if (id_order != -1 && createOrderItems(conn, request, id_order)) {
			Order order = wrapOrder(conn, request);
			order.setIdOder(id_order);
			
			HttpSession session = request.getSession();
			session.removeAttribute("listProduct");
			session.removeAttribute("member");
			
			request.setAttribute("order", order);
			request.getRequestDispatcher("view/order-success/order-success.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "Đặt hàng không thành công!");
			request.getRequestDispatcher("view/order/order.jsp").forward(request, response);
		}

		DBConnection.closeConnection(conn);
	}

	private long fomatPrice(String price) {
		String cleanString = price.replaceAll("[^0-9.]", "").replace(".", "");

		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
		Number number;
		try {
			number = numberFormat.parse(cleanString);
			System.out.println(cleanString + " " + number.longValue());
			return number.longValue();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}

	private Order wrapOrder(Connection conn, HttpServletRequest request) {
		int customer_id = Integer.parseInt(request.getParameter("customer_id"));
		String gender = request.getParameter("gender");
		String customer_name = (gender == "Male" ? "Anh" : "Chị") + " " + request.getParameter("customer_name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		long total_price = fomatPrice(request.getParameter("total_price"));

		Order order = new Order();
		order.setIdOder(customer_id);
		order.setNameCustomer(customer_name);
		order.setPhone(phone);
		order.setAddress(address);
		order.setPrice(total_price);
		order.setStatus(false);
		System.out.println(order);
		return order;
	}

	private int createOrder(Connection conn, HttpServletRequest request) {
		Order order = wrapOrder(conn, request);
		int checkCreateOrder = OrderDAO.createOrder(conn, order);
		return checkCreateOrder;
	}

	private boolean createOrderItems(Connection conn, HttpServletRequest request, int id_order) {
		boolean check = true;
		String[] productIds = request.getParameterValues("product_id");
		String[] quantities = request.getParameterValues("quantity");
		String[] productTotals = request.getParameterValues("product_total");

		if (productIds != null && quantities != null && productTotals != null && productIds.length == quantities.length
				&& productIds.length == productTotals.length) {
			for (int i = 0; i < productIds.length; i++) {
				int productId = Integer.parseInt(productIds[i]);
				int quantity = Integer.parseInt(quantities[i]);
				long productTotal = fomatPrice(productTotals[i]);

				boolean checkCreateOrderItem = OrderDAO.createOrderItem(conn, productId, quantity, productTotal,
						id_order);

				if (checkCreateOrderItem) {
					System.out.println("Created order item for product ID: " + productId);
				} else {
					System.out.println("Failed to create order item for product ID: " + productId);
					check = false;
					break;
				}
			}
		} else {
			System.out.println("Invalid product_ids, quantities, or product_totals");
		}
		return check;
	}
}
