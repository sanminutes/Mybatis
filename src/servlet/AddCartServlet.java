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
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/addCart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("CODE"); // ��ǰ�ڵ带 ����
		// ���ǿ��� �α��� ������ �ҷ��´�.
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("LOGIN");
		// ��ٱ��� ��ü�� �����Ѵ�.
		Cart cart = (Cart) session.getAttribute("CART"); // ���ǿ��� ��ٱ��ϸ� ã�´�.
		if (cart == null)
			cart = new Cart(id); // ��ٱ��ϸ� ����

		// ��ٱ��Ͽ� ��ǰ�ڵ�� ������ �����Ѵ�.
		cart.addCart(code, 1);
		session.setAttribute("CART", cart);// ��ٱ��ϸ� ���ǿ� ����
		// ��ٱ��� ��� ��� ��(addCartResult.jsp)�� ȭ���� ��ȯ�Ѵ�. Redirect
		response.sendRedirect("addCartResult.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
