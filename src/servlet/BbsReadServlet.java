package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.Crud;
import model.Bbs;

/**
 * Servlet implementation class bbsReadServlet
 */
@WebServlet("/bbsRead")
public class BbsReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BbsReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터를 불러온다.
		String seqno = request.getParameter("SEQNO");
		//SEQNO에 저장된 글번호로 게시글을 DB에서 검색한다.
		Crud crud = new Crud();
		Bbs bbs = crud.getBBSRead(Integer.parseInt(seqno));
		request.setAttribute("bbs", bbs);
		//검색결과를 뷰(bbsRead.jsp)로 전달한다.
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=bbsRead.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
