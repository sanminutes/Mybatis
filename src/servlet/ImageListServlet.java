package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.UploadCrud;
import model.Condition;
import model.Writing;

/**
 * Servlet implementation class ImageListServlet
 */
@WebServlet("/imageList")
public class ImageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImageListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// DB에서 이미지 게시글을 5개씩 검색한다.
		UploadCrud crud = new UploadCrud();
		int count = crud.getTotalCnt();// 전체 글 갯수 검색
		int totalPageCount = 0; // 페이지 갯수
		String pageNum = request.getParameter("page"); // 페이지 번호를 누른경우
		if (pageNum == null)
			pageNum = "1"; // 페이지번호가 없는 경우는 1
		/// 수정된 글이 있는 페이지로 이동 시작
		String seqno = request.getParameter("seqno");
		if (seqno != null) {// seqno 파라미터가 존재하는 경우
			int rownum = crud.selectRownum(Integer.parseInt(seqno));
			int page = rownum / 5; // 검색된 rownum으로 페이지를 계산
			if (rownum % 5 != 0) page++;
			pageNum = String.valueOf(page);
		}
		/// 수정된 글이 있는 페이지로 이동 끝
		int startRow = 0;
		int endRow = 0; // 이미지 글 검색 범위
		int currentPage = Integer.parseInt(pageNum); // 정수로 변환
		if (count > 0) {// 이미지 게시글이 존재하는 경우
			totalPageCount = count / 5; // 한 페이지에 5개 글 기준
			if (count % 5 > 0)
				totalPageCount++;
			startRow = (currentPage - 1) * 5 + 1; // 검색 시작 범위
			endRow = (currentPage * 5); // 검색 종료 범위
			if (endRow > count)
				endRow = count;
		}
		Condition condition = new Condition();
		condition.setStartRow(startRow);
		condition.setEndRow(endRow);
		List<Writing> list = crud.getImageList(condition); // DB에서 이미지게시글 검색
		// 검색결과를 request에 저장한다.
		request.setAttribute("LIST", list);
		request.setAttribute("startRow", startRow);
		request.setAttribute("endRow", endRow);
		request.setAttribute("count", count);
		request.setAttribute("pageCount", totalPageCount);
		request.setAttribute("currentPage", currentPage);
		// 목록 출력 뷰(imageList.jsp)로 화면을 전환한다.
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=imageListView.jsp");
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
