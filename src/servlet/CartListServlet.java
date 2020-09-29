package servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.CartItem;

/**
 * Servlet implementation class CartListServlet
 */
@WebServlet("/cartList")
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();// ������ ����
		Cart cart = (Cart) session.getAttribute("CART"); // ���ǿ��� ��ٱ��ϸ� ã��
		if (cart == null) { // ��ٱ��ϰ� ���� ���
			request.setAttribute("CARTLIST", null);
		} else { // �ִ� ���
			// ��ٱ��Ͽ��� ��ǰ�ڵ� ����� ã��, ��Ͽ��� ��ǰ�ڵ带 ã�´�.
			List<CartItem> list = new LinkedList<CartItem>();
			Iterator itr = cart.getCodeList().iterator();
			List<Integer> num = cart.getNumList();
			int total = 0; // �Ѿ��� ���� ����
			int index = 0;
			while (itr.hasNext()) {
				String code = (String) itr.next();
				CartItem item = new CartItem();
				item.setCode(code);
				item.setNum(num.get(index));
				list.add(item);
				index++;

			}
			request.setAttribute("CARTLIST", list);

			// ��ٱ��Ͽ� �ִ� ��ǰ�ڵ�� ������ ������ DTO�� �����Ѵ�.
			// DTO�� ��ٱ��Ͽ� �ִ� ��ǰ�ڵ�� ��ǰ������ �����Ѵ�.
		}
		// ��ٱ��� ����� ����ϴ� ��(cartListView.jsp)�� ��ȯ, Forward
		RequestDispatcher rd = request.getRequestDispatcher("tmplate.jsp?BODY=cartListView.jsp");
		rd.forward(request, response);

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
