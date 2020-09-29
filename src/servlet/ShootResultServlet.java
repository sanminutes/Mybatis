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
		int dir = Integer.parseInt(direction); // ������ ��ȯ
		int keeper = (int) (Math.random() * 5);// 0~4���� ���� �߻�
		String jsp = "";// ��(JSP)�̸��� ����� ����
		String img = "";// ���Ӱ�� �̹��� �̸��� ����� ����
		String result = "";// ���Ӱ�� ���ڿ��� ����� ����
		System.out.println("������ : " + keeper);
		System.out.println("���ð� : " + dir);
		System.out.println("---------------------");
		if (dir == keeper) {// ���� ����� ��Ű���� ������ �����Ƿ� ���
			img = "nogoal.png";
			result = "NO";
		} else {// ����
			img = "goal.png";
			result = "YES";
		}
		// penaltyResult.jsp�� ��ȯ, Redirect
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
