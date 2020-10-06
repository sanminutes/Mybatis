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
		String code = request.getParameter("CODE"); // 상품코드
		String num = request.getParameter("NUM"); // 상품갯수
		String btn = request.getParameter("BTN"); // 버튼의 제목
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("LOGIN");
		Cart cart = (Cart) session.getAttribute("CART");
		if (btn.equals("수정")) {// 수정버튼을 누른 경우
			cart.modifyItem(code, Integer.parseInt(num));
		} else if (btn.contentEquals("삭제")) {// 삭제버튼을 누른 경우
			cart.deleteItem(code);
		}
		//장바구니 목록으로 전환
		response.sendRedirect("cartList.do");
	}

}
