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
		// DB���� �̹��� �Խñ��� 5���� �˻��Ѵ�.
		UploadCrud crud = new UploadCrud();
		int count = crud.getTotalCnt();// ��ü �� ���� �˻�
		int totalPageCount = 0; // ������ ����
		String pageNum = request.getParameter("page"); // ������ ��ȣ�� �������
		if (pageNum == null)
			pageNum = "1"; // ��������ȣ�� ���� ���� 1
		/// ������ ���� �ִ� �������� �̵� ����
		String seqno = request.getParameter("seqno");
		if (seqno != null) {// seqno �Ķ���Ͱ� �����ϴ� ���
			int rownum = crud.selectRownum(Integer.parseInt(seqno));
			int page = rownum / 5; // �˻��� rownum���� �������� ���
			if (rownum % 5 != 0) page++;
			pageNum = String.valueOf(page);
		}
		/// ������ ���� �ִ� �������� �̵� ��
		int startRow = 0;
		int endRow = 0; // �̹��� �� �˻� ����
		int currentPage = Integer.parseInt(pageNum); // ������ ��ȯ
		if (count > 0) {// �̹��� �Խñ��� �����ϴ� ���
			totalPageCount = count / 5; // �� �������� 5�� �� ����
			if (count % 5 > 0)
				totalPageCount++;
			startRow = (currentPage - 1) * 5 + 1; // �˻� ���� ����
			endRow = (currentPage * 5); // �˻� ���� ����
			if (endRow > count)
				endRow = count;
		}
		Condition condition = new Condition();
		condition.setStartRow(startRow);
		condition.setEndRow(endRow);
		List<Writing> list = crud.getImageList(condition); // DB���� �̹����Խñ� �˻�
		// �˻������ request�� �����Ѵ�.
		request.setAttribute("LIST", list);
		request.setAttribute("startRow", startRow);
		request.setAttribute("endRow", endRow);
		request.setAttribute("count", count);
		request.setAttribute("pageCount", totalPageCount);
		request.setAttribute("currentPage", currentPage);
		// ��� ��� ��(imageList.jsp)�� ȭ���� ��ȯ�Ѵ�.
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
