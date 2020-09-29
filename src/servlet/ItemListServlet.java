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
import model.Item;

/**
 * Servlet implementation class ItemListServlet
 */
@WebServlet("/itemList.do")
public class ItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pageNumber = request.getParameter("PAGENO");
		Integer pageNumberInt = 1;
		if (pageNumber != null)
			pageNumberInt = Integer.parseInt(pageNumber);
		Crud crud = new Crud();
		// DB���� ��ǰ ������ �˻��Ѵ�. (��� ��ǰ ���� �˻�, 5���� ��ǰ ������ �˻�)
		List<Item> items = crud.getItems(pageNumberInt);
		// DB���� ��ǰ������ ������ �˻��Ѵ�.
		Integer pageNum = crud.getItemCount();
		// ��ǰ ���� ������ �̿��ؼ� ������ ���� ����Ѵ�.
		if (pageNum == null)
			pageNum = 0;
		else
			pageNum = (pageNum + 4) / 5;
		request.setAttribute("ITEMS", items);
		request.setAttribute("PAGES", pageNum);
		// �˻������ ��ǰ��� ��(itemList.jsp)�� �����Ѵ�.
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=itemList.jsp");
		rd.forward(request, response);
		// ��ǰ��� ��� ȭ���� ��ȯ�Ѵ�. Forward, Redirect

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
