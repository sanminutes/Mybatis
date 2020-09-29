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
		HttpSession session = request.getSession();// 세션을 생성
		Cart cart = (Cart) session.getAttribute("CART"); // 세션에서 장바구니를 찾음
		if (cart == null) { // 장바구니가 없는 경우
			request.setAttribute("CARTLIST", null);
		} else { // 있는 경우
			// 장바구니에서 상품코드 목록을 찾고, 목록에서 상품코드를 찾는다.
			List<CartItem> list = new LinkedList<CartItem>();
			Iterator itr = cart.getCodeList().iterator();
			List<Integer> num = cart.getNumList();
			int total = 0; // 총액을 위한 변수
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

			// 장바구니에 있는 상품코드와 갯수를 저장할 DTO를 생성한다.
			// DTO에 장바구니에 있는 상품코드와 상품갯수를 저장한다.
		}
		// 장바구니 목록을 출력하는 뷰(cartListView.jsp)로 전환, Forward
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
