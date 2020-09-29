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
		if (cnt >0) {// �Է��� �ڵ尡 DB�� ���� ���, �� ��� ������ �ڵ�
			request.setAttribute("CUP", "NO"); // �ߺ��� ������ �ǹ�
		} else {// �Է��� �ڵ尡 DB�� �ִ� ��� ��, �ߺ��� �ڵ�
			request.setAttribute("CUP", "YES");// �ߺ��� ������ �ǹ�
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
