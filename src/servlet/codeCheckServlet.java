package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.Crud;

/**
 * Servlet implementation class codeCheckServlet
 */
@WebServlet("/codeCheck")
public class codeCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public codeCheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("CODE");
		// DB
		Crud crud = new Crud();
		Integer cnt = crud.getItemID(code);
		if (cnt >0) {// 입력한 코드가 DB에 없는 경우, 즉 사용 가능한 코드
			request.setAttribute("CUP", "NO"); // 중복이 없음을 의미
		} else {// 입력한 코드가 DB에 있는 경우 즉, 중복된 코드
			request.setAttribute("CUP", "YES");// 중복이 있음을 의미
		}
		request.setAttribute("CODE", code);
		RequestDispatcher rd = request.getRequestDispatcher("codeCheckResult.jsp");
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
