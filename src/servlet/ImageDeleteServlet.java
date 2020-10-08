package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.UploadCrud;
import model.Writing;

/**
 * Servlet implementation class ImageDeleteServlet
 */
@WebServlet("/imageDelete")
public class ImageDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImageDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		// id에 있는 글 번호로 DB에서 검색
		UploadCrud crud = new UploadCrud();
		Writing writing = crud.getImage(Integer.parseInt(id));
		// 검색한 결과를 request에 저장하고 글 삭제뷰(deleteForm.jsp)로 화면 전환
		request.setAttribute("writing", writing);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=deleteForm.jsp");
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
