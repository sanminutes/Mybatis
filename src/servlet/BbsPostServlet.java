package servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.Crud;
import model.Bbs;

/**
 * Servlet implementation class bbsPosetServlet
 */
@WebServlet("/bbsPost")
public class BbsPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BbsPostServlet() {
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
		// �ѱ�ó��
		request.setCharacterEncoding("UTF-8");
		// �Ķ���� ó��
		String title = request.getParameter("TITLE");
		String content = request.getParameter("CONTENT");
		// �۹�ȣ ó��
		Crud crud = new Crud();
		Integer seqno = crud.getMaxSeqno() + 1;// �ִ� �۹�ȣ + 1
		// ������ ���ǿ��� �ҷ��´�.
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("LOGIN");
		// �Խñ� �ۼ� ��¥�� �����Ѵ�.
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		int date = today.get(Calendar.DATE);
		String bbsDate = year + "/" + month + "/" + date;
		// ���� ������ �� �Խñ� �����͸� �ִ´�.
		Bbs bbs = new Bbs();
		bbs.setSeqno(seqno);
		bbs.setTitle(title);
		bbs.setContent(content);
		bbs.setId(id);
		bbs.setBbs_date(bbsDate);
		// DB�� �����Ѵ�.
		Integer r = crud.putBBS(bbs);
		String result = "";
		if (r > 0) {
			result = "OK";
		} else {
			result = "NOK";

		}
		// �������� �Խñ� ��� ��� JSP(bbsPostResult.jsp)�� �ٲ۴�.
		//response.sendRedirect("template.jsp?BODY=bbsPostResult.jsp?RE=" + result);
		response.sendRedirect("bbsList.do?RE="+result);
	}

}
