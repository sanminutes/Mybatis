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
		// DB에서 게시글을 검색한다. (1. 모든 게시글을 검색, 2. 5개의 게시글만 검색)
		Crud crud = new Crud();
		// 페이지번호를 파라미터(PAGENO)로 수신한다.
		String pageno= request.getParameter("PAGENO");
		if(pageno == null) pageno = "1";
		List<Bbs> bbsList = crud.getBBS(Integer.parseInt(pageno));
		// 페이지 갯수를 계산한다. (전체 글 갯수 + 4) / 5
		Integer pageCount = (crud.getBBSCount() + 4) / 5;
		// 검색된 게시글을 뷰(bbsListView.jsp)로 전달하면서 페이지를 전환한다. Forward방식
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
