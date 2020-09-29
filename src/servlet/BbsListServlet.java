package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.Crud;
import model.Bbs;

/**
 * Servlet implementation class bbsListServlet
 */
@WebServlet("/bbsList.do")
public class BbsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BbsListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = request.getParameter("RE");
		// DB���� �Խñ��� �˻��Ѵ�. (1. ��� �Խñ��� �˻�, 2. 5���� �Խñ۸� �˻�)
		Crud crud = new Crud();
		// ��������ȣ�� �Ķ����(PAGENO)�� �����Ѵ�.
		String pageno= request.getParameter("PAGENO");
		if(pageno == null) pageno = "1";
		List<Bbs> bbsList = crud.getBBS(Integer.parseInt(pageno));
		// ������ ������ ����Ѵ�. (��ü �� ���� + 4) / 5
		Integer pageCount = (crud.getBBSCount() + 4) / 5;
		// �˻��� �Խñ��� ��(bbsListView.jsp)�� �����ϸ鼭 �������� ��ȯ�Ѵ�. Forward���
		request.setAttribute("RESULT", result);
		request.setAttribute("LIST", bbsList);
		request.setAttribute("PAGES", pageCount);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=bbsListView.jsp");
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
