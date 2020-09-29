package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.Crud;
import model.Item;

/**
 * Servlet implementation class RegisterItemServlet
 */
@WebServlet("/registerItem")
public class RegisterItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterItemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String code = request.getParameter("CODE");
		String name = request.getParameter("NAME");
		String price = request.getParameter("PRICE");
		String origin = request.getParameter("ORIGIN");
		String info = request.getParameter("INFO");
		Item item = new Item();
		item.setCode(code);
		item.setName(name);
		item.setOrigin(origin);
		item.setInfo(info);
		item.setPrice(Integer.parseInt(price));
		Crud crud = new Crud();
		Integer result = crud.putItem(item); // DB에 상품 정보 삽입
		String r = "";
		if (result > 0)
			r = "OK";
		else
			r = "NOK";
		// 상품등록 결과 뷰(putItemResult.jsp)로 전달, Redirect
		response.sendRedirect("template.jsp?BODY=putItemResult.jsp?R=" + r);
	}

}
