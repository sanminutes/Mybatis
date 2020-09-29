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
		// DB에서 상품 정보를 검색한다. (모든 상품 정보 검색, 5개의 상품 정보만 검색)
		List<Item> items = crud.getItems(pageNumberInt);
		// DB에서 상품정보의 갯수를 검색한다.
		Integer pageNum = crud.getItemCount();
		// 상품 정보 갯수를 이용해서 페이지 수를 계산한다.
		if (pageNum == null)
			pageNum = 0;
		else
			pageNum = (pageNum + 4) / 5;
		request.setAttribute("ITEMS", items);
		request.setAttribute("PAGES", pageNum);
		// 검색결과를 상품목록 뷰(itemList.jsp)로 전달한다.
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=itemList.jsp");
		rd.forward(request, response);
		// 상품목록 뷰로 화면을 전환한다. Forward, Redirect

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
