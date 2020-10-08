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
 * Servlet implementation class ImageUpdateServlet
 */
@WebServlet("/imageUpdate")
public class ImageUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImageUpdateServlet() {
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
		UploadCrud crud = new UploadCrud();
		Writing writing = crud.getImage(Integer.parseInt(id));
		request.setAttribute("writing", writing);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=updateForm.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * String id = request.getParameter("id"); UploadCrud crud = new UploadCrud();
		 * Writing writing = crud.getImage(Integer.parseInt("id"));
		 * request.setAttribute("writing", writing); RequestDispatcher rd =
		 * request.getRequestDispatcher("template.jsp?BODY=updateForm.jsp");
		 * rd.forward(request, response);
		 */
	}

}
