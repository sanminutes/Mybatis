package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.BaseballCrud;
import model.BaseballTeam;

/**
 * Servlet implementation class PutBaseballTeamServlet
 */
@WebServlet("/putBaseballTeam")
public class PutBaseballTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PutBaseballTeamServlet() {
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
		String name = request.getParameter("NAME");
		String town = request.getParameter("TOWN");
		String owner = request.getParameter("OWNER");
		String birth = request.getParameter("BIRTH");
		String intro = request.getParameter("INTRO");
		BaseballCrud crud = new BaseballCrud();
		Integer id = crud.getId() + 1; // 구단번호 +1 - > 새 구단 번호
		BaseballTeam team = new BaseballTeam();
		team.setId(id);
		team.setName(name);
		team.setHometown(town);
		team.setOwner(owner);
		team.setBirth(birth);
		team.setIntro(intro);
		Integer result = crud.putBaseballTeam(team); // DB에 야구팀 등록 }
		String r = "";
		if (result > 0)
			r = "OK";
		else
			r = "NOK";
		response.sendRedirect("template.jsp?BODY=putBaseballTeam.jsp?R=" + r);
	}
}
