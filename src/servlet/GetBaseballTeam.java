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
import model.BaseballTeam;

/**
 * Servlet implementation class GetBaseballTeam
 */
@WebServlet("/GetBaseballTeam")
public class GetBaseballTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetBaseballTeam() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// DB���� ��ϵ� �߱��� ������ �˻��Ѵ�.
		BaseballCrud crud = new BaseballCrud();
		List<BaseballTeam> team = crud.getBaseballTeam();
		// �˻��� �߱��� ������ �����Ѵ�.
		request.setAttribute("TEAM", team);
		// ����� ������ ��(inputBaseballPlayer.jsp)�� �����Ѵ�.
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=inputBaseballPlayer.jsp");
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
