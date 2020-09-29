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
		// DB���� user�� ����� �������� �˻��Ѵ�.
		Crud crud = new Crud();
		Custom_info customer = crud.selectMember(user);
		if (customer == null) {// �Է��� ������ DB�� ���� ���, �� ��� ������ ����
			request.setAttribute("DUP", "NO"); // �ߺ��� ������ �ǹ�
		} else {// �Է��� ������ DB�� �ִ� ��� ��, �ߺ��� ����
			request.setAttribute("DUP", "YES");// �ߺ��� ������ �ǹ�
		}
		// �˻��� ����� �����ϸ� �ߺ�, ������ ��밡��
		// ID�ߺ��˻� ��� ��(idCheckResult.jsp)�� ��ȯ
		request.setAttribute("ID", user);// �Է��� ������ ����
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
