package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShootResultServlet
 */
@WebServlet("/shootResult")
public class ShootResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShootResultServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String direction = request.getParameter("shoot");
		int dir = Integer.parseInt(direction); // 정수로 변환
		int keeper = (int) (Math.random() * 5);// 0~4까지 난수 발생
		String jsp = "";// 뷰(JSP)이름이 저장될 변수
		String img = "";// 게임결과 이미지 이름이 저장될 변수
		String result = "";// 게임결과 문자열이 저장될 변수
		System.out.println("랜덤값 : " + keeper);
		System.out.println("선택값 : " + dir);
		System.out.println("---------------------");
		if (dir == keeper) {// 슛의 방향과 골키퍼의 방향이 같으므로 노골
			img = "nogoal.png";
			result = "NO";
		} else {// 골인
			img = "goal.png";
			result = "YES";
		}
		// penaltyResult.jsp로 전환, Redirect
		response.sendRedirect("template.jsp?BODY=penaltyResult.jsp?IMG=" + img + "&R=" + result);
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
