package servlet;

import java.io.IOException;
import java.util.Iterator;
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
import model.Custom_info;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		// 계정과 암호를 불러온다.
		String id = request.getParameter("ID");
		String pwd = request.getParameter("PWD");
		// DB에서 계정으로 검색하고 암호가 일치하는지 검사한다.
		Crud crud = new Crud();
		Custom_info custom = crud.selectMember(id);
		// 계정과 암호가 일치하면, 세션에 계정을 대문자 LOGIN으로 저장한다.
		String result = "";// 로그인 결과를 위한 변수
		if (custom != null) {// 검색 결과가 존재하는 경우
			if (pwd.equals(custom.getPassword())) {// 암호가 일치하는 경우
				// 로그인 성공!
				HttpSession session = request.getSession();
				session.setAttribute("LOGIN", id);
				result = "YES";
				// DB에서 장바구니 정보를 검색한다. 시작//
				List<CartItem> items = crud.getCart(id);
				if (items != null) {// 장바구니에 정보가 있는 경우
					Cart cart = new Cart(id);// 장바구니 객체를 생성한다.
					Iterator it = items.iterator();
					while (it.hasNext()) {
						CartItem item = (CartItem) it.next();
						cart.getCodeList().add(item.getCode());//
						cart.getNumList().add(item.getNum());
					}
					session.setAttribute("CART", cart);// 장바구니 객체를 세션에 저장
				}
				// DB에서 장바구니 정보를 검색한다. 끝//
				// sessionScope.Login으로 LOGIN을 판단하니까
			} else {// 암호가 일치하지 않는 경우
				result = "NOPWD";
			}
		} else {// 검색결과가 없는 경우
			result = "NOID";
		}
		// 로그인 결과 뷰(JSP)를 출력한다.
		// 페이지 전환: redirect, forward
		String param = request.getParameter("CART");
		if (param == null) {
			response.sendRedirect("template.jsp?BODY=loginResult.jsp?RESULT=" + result);
		}else {
			response.sendRedirect("cartLoginResult.jsp?RESULT="+result);
		}
	}

}
