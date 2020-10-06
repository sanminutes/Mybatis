package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.Crud;
import model.Cart;
import model.CartItem;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoutServlet() {
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
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("CART");
		if (cart != null) {// 세션에 장바구니가 존재하면 장바구니 정보를 DB에 저장
			Crud crud = new Crud();
			String id = cart.getId();
			List<CartItem> item = crud.getCart(id);
			if (item != null) {// 해당 계정으로 장바구니 정보가 존재하는 경우
				cart.deleteDB(id); // 기존의 정보를 삭제
			}
			cart.saveDB();
		}
		session.invalidate();// 세션을 무효화 한다.
		// 페이지 전환 : logoutResult.jsp
		// redirect? forward?
		response.sendRedirect("template.jsp?BODY=logoutResult.jsp");
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
