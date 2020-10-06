package servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import crud.UploadCrud;
import model.Writing;

/**
 * Servlet implementation class writeServlet
 */
@WebServlet("/write.do")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WriteServlet() {
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
		request.setCharacterEncoding("UTF-8"); // �ѱ�ó��
		String savePath = "/upload"; // ���ε�� ���� �̸�
		int maxLimit = 5 * 1024 * 1024; // ���ε�� ������ �ִ� ũ��(5M)
		String encType = "UTF-8"; // ������ �ѱ��ڵ�
		ServletContext context = this.getServletContext(); // ������Ʈ�� �������ش�.
		String realPath = context.getRealPath(savePath);// ���ε�� ������ ������
		String filename = "";// ���ε�� ������ �̸�
		System.out.println("����� ���� : " + realPath);
		String result = "";// �Խñ� ��� ���������� ���� ����
		try {
			MultipartRequest multipart = new MultipartRequest(request, realPath, maxLimit, encType,
					new DefaultFileRenamePolicy());
			filename = multipart.getFilesystemName("imagename");// ���ε� ����
			if (filename == null) {// ���ε� ����
				result = "NO_UP";
			} else {// ���ε� ����
				UploadCrud crud = new UploadCrud();
				Writing writing = new Writing();
				writing.setParent_id(0);
				writing.setOrder_no(0);
				writing.setWriting_id(crud.getMaxId() + 1);
				writing.setGroup_id(crud.getMaxId() + 1);
				writing.setTitle(multipart.getParameter("title"));
				writing.setWriter_name(multipart.getParameter("writer_name"));
				writing.setEmail(multipart.getParameter("email"));
				writing.setPassword(multipart.getParameter("password"));
				writing.setContent(multipart.getParameter("content"));
				writing.setImage_name(filename);
				Calendar today = Calendar.getInstance();
				int year = today.get(Calendar.YEAR);
				int month = today.get(Calendar.MONTH) + 1;
				int date = today.get(Calendar.DATE);
				String mon = "";
				String dte = "";
				String hh = "";
				String mm = "";
				String ss = "";
				if (month < 10)
					mon = "0" + month;
				else
					mon = month + "";
				if (date < 10)
					dte = "0" + date;
				else
					dte = date + "";
				int hour = today.get(Calendar.HOUR_OF_DAY);
				int min = today.get(Calendar.MINUTE);
				int sec = today.get(Calendar.SECOND);
				if (hour < 10)
					hh = "0" + hour;
				else
					hh = hour + "";
				if (min < 10)
					mm = "0" + min;
				else
					mm = min + "";
				if (sec < 10)
					ss = "0" + sec;
				else
					ss = sec + "";
				String registerDate = year + "/" + mon + "/" + dte + " " + hh + ":" + mm + ":" + ss;
				writing.setRegister_date(registerDate);
				int r = crud.putImageWriting(writing);
				if (r > 0)
					result = "OK";
				else
					result = "NOK";

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// ���ε� �� ȭ�� ��ȯ, redirect
		response.sendRedirect("template.jsp?BODY=uploadResult.jsp?R=" + result);
	}

}
