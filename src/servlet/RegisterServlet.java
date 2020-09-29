package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.Crud;
import model.Custom_info;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");
		String name = request.getParameter("NAME");
		String pwd = request.getParameter("PWD");
		String gender = request.getParameter("GENDER");
		String email = request.getParameter("EMAIL");
		String addr = request.getParameter("ADDR");
		String job = request.getParameter("JOB");
		Custom_info custom = new Custom_info();
		custom.setId(id);
		custom.setName(name);
		custom.setPassword(pwd);
		custom.setGender(gender);
		custom.setEmail(email);
		custom.setAddr(addr);
		custom.setJob(job);
		// DB에 삽입
		Crud crud = new Crud();
		Integer result = crud.putMember(custom);
		String r = "";
		if (result > 0)
			r = "OK";
		else
			r = "NOK";
		// 가입자 등록 결과 뷰(registerResult.jsp)로 전환, Forward, Redirect
		response.sendRedirect("template.jsp?BODY=registerResult.jsp?R=" + r);
	}
}
