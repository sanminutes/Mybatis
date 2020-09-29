package servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.Crud;
import model.Bbs;

/**
 * Servlet implementation class bbsPosetServlet
 */
@WebServlet("/bbsPost")
public class BbsPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BbsPostServlet() {
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
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		// 파라미터 처리
		String title = request.getParameter("TITLE");
		String content = request.getParameter("CONTENT");
		// 글번호 처리
		Crud crud = new Crud();
		Integer seqno = crud.getMaxSeqno() + 1;// 최대 글번호 + 1
		// 계정을 세션에서 불러온다.
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("LOGIN");
		// 게시글 작성 날짜를 생성한다.
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		int date = today.get(Calendar.DATE);
		String bbsDate = year + "/" + month + "/" + date;
		// 모델을 생성한 후 게시글 데이터를 넣는다.
		Bbs bbs = new Bbs();
		bbs.setSeqno(seqno);
		bbs.setTitle(title);
		bbs.setContent(content);
		bbs.setId(id);
		bbs.setBbs_date(bbsDate);
		// DB에 삽입한다.
		Integer r = crud.putBBS(bbs);
		String result = "";
		if (r > 0) {
			result = "OK";
		} else {
			result = "NOK";

		}
		// 페이지를 게시글 등록 결과 JSP(bbsPostResult.jsp)로 바꾼다.
		//response.sendRedirect("template.jsp?BODY=bbsPostResult.jsp?RE=" + result);
		response.sendRedirect("bbsList.do?RE="+result);
	}

}
