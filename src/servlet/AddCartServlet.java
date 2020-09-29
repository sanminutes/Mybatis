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
		String code = request.getParameter("CODE"); // 상품코드를 수신
		// 세션에서 로그인 계졍을 불러온다.
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("LOGIN");
		// 장바구니 객체를 생성한다.
		Cart cart = (Cart) session.getAttribute("CART"); // 세션에서 장바구니를 찾는다.
		if (cart == null)
			cart = new Cart(id); // 장바구니를 생성

		// 장바구니에 상품코드와 갯수를 저장한다.
		cart.addCart(code, 1);
		session.setAttribute("CART", cart);// 장바구니를 세션에 저장
		// 장바구니 담기 결과 뷰(addCartResult.jsp)로 화면을 전환한다. Redirect
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
