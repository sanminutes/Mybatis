package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;

/**
 * Servlet implementation class ModifyCartServlet
 */
@WebServlet("/modifyCart")
public class ModifyCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String code = request.getParameter("CODE"); // ��ǰ�ڵ�
		String num = request.getParameter("NUM"); // ��ǰ����
		String btn = request.getParameter("BTN"); // ��ư�� ����
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("LOGIN");
		Cart cart = (Cart) session.getAttribute("CART");
		if (btn.equals("����")) {// ������ư�� ���� ���
			cart.modifyItem(code, Integer.parseInt(num));
		} else if (btn.contentEquals("����")) {// ������ư�� ���� ���
			cart.deleteItem(code);
		}
		//��ٱ��� ������� ��ȯ
		response.sendRedirect("cartList.do");
	}

}
