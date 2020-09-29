package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.BaseballCrud;

/**
 * Servlet implementation class GetBaseballHometown
 */
@WebServlet("/getBaseballHometown")
public class GetBaseballHometown extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetBaseballHometown() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 새 매퍼, 새 crud
		BaseballCrud crud = new BaseballCrud();
		List<String> hometowns = crud.getHometown();
		// 야구 구단 등록 뷰(inputBaseballTeam.jsp)로 전환, Forward
		request.setAttribute("TOWN", hometowns);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=inputBaseballTeam.jsp");
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
