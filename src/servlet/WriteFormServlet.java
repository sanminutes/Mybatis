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
 * Servlet implementation class WriteFormServlet
 */
@WebServlet("/writeFormServlet")
public class WriteFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WriteFormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parentId = request.getParameter("parentid");
		String groupId = request.getParameter("groupid");
		if (parentId != null) {// 답글인 경우
			String title = "";// 답글의 제목을 위한 변수
			UploadCrud crud = new UploadCrud();
			Writing writing = crud.getImage(Integer.parseInt(parentId));// 원글검색
			if (writing != null) { 
				title = "RE]" + writing.getTitle();
				request.setAttribute("writing", writing);
				request.setAttribute("title", title);
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=writerForm.jsp");
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
