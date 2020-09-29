package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.Crud;
import model.Custom_info;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		// ������ ��ȣ�� �ҷ��´�.
		String id = request.getParameter("ID");
		String pwd = request.getParameter("PWD");
		// DB���� �������� �˻��ϰ� ��ȣ�� ��ġ�ϴ��� �˻��Ѵ�.
		Crud crud = new Crud();
		Custom_info custom = crud.selectMember(id);
		// ������ ��ȣ�� ��ġ�ϸ�, ���ǿ� ������ �빮�� LOGIN���� �����Ѵ�.
		String result = "";// �α��� ����� ���� ����
		if (custom != null) {// �˻� ����� �����ϴ� ���
			if (pwd.equals(custom.getPassword())) {// ��ȣ�� ��ġ�ϴ� ���
				// �α��� ����!
				HttpSession session = request.getSession();
				session.setAttribute("LOGIN", id);
				result = "YES";
				// sessionScope.Login���� LOGIN�� �Ǵ��ϴϱ�
			} else {// ��ȣ�� ��ġ���� �ʴ� ���
				result = "NOPWD";
			}
		} else {// �˻������ ���� ���
			result = "NOID";
		}
		// �α��� ��� ��(JSP)�� ����Ѵ�.
		// ������ ��ȯ: redirect, forward
		response.sendRedirect("template.jsp?BODY=loginResult.jsp?"
				+ "RESULT=" + result);
	}

}
