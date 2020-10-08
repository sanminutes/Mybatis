package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.UploadCrud;
import model.Writing;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
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
		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		UploadCrud crud = new UploadCrud();
		Writing w = crud.getImage(Integer.parseInt(id));
		String url = "template.jsp?BODY=deleteResult.jsp";
		if (w.getPassword().equals(pwd)) {// 암호가 일치하는 경우
			// DB에서 삭제
			crud.deleteImage(Integer.parseInt(id));
		} else {// 일치하지 않는 경우
			url = url + "?id=" + id;
		}
		response.sendRedirect(url);
	}

}
