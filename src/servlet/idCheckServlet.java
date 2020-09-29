package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.Crud;
import model.Custom_info;

/**
 * Servlet implementation class idCheckServlet
 */
@WebServlet("/idCheck.do")
public class idCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public idCheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("USER");
		// DB에서 user에 저장된 계정으로 검색한다.
		Crud crud = new Crud();
		Custom_info customer = crud.selectMember(user);
		if (customer == null) {// 입력한 계정이 DB에 없는 경우, 즉 사용 가능한 계정
			request.setAttribute("DUP", "NO"); // 중복이 없음을 의미
		} else {// 입력한 계정이 DB에 있는 경우 즉, 중복된 계정
			request.setAttribute("DUP", "YES");// 중복이 있음을 의미
		}
		// 검색한 결과가 존재하면 중복, 없으면 사용가능
		// ID중복검사 결과 뷰(idCheckResult.jsp)로 전환
		request.setAttribute("ID", user);// 입력한 계정을 저장
		RequestDispatcher rd = request.getRequestDispatcher("idCheckResult.jsp");
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
