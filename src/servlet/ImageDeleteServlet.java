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
		// id�� �ִ� �� ��ȣ�� DB���� �˻�
		UploadCrud crud = new UploadCrud();
		Writing writing = crud.getImage(Integer.parseInt(id));
		// �˻��� ����� request�� �����ϰ� �� ������(deleteForm.jsp)�� ȭ�� ��ȯ
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
