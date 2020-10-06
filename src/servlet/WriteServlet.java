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
		request.setCharacterEncoding("UTF-8"); // 한글처리
		String savePath = "/upload"; // 업로드될 폴더 이름
		int maxLimit = 5 * 1024 * 1024; // 업로드될 파일의 최대 크기(5M)
		String encType = "UTF-8"; // 설정된 한글코드
		ServletContext context = this.getServletContext(); // 프로젝트를 관리해준다.
		String realPath = context.getRealPath(savePath);// 업로드될 폴더의 절대경로
		String filename = "";// 업로드된 파일의 이름
		System.out.println("저장된 폴더 : " + realPath);
		String result = "";// 게시글 등록 성공유무를 위한 변수
		try {
			MultipartRequest multipart = new MultipartRequest(request, realPath, maxLimit, encType,
					new DefaultFileRenamePolicy());
			filename = multipart.getFilesystemName("imagename");// 업로드 실행
			if (filename == null) {// 업로드 실패
				result = "NO_UP";
			} else {// 업로드 성공
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
		// 업로드 후 화면 전환, redirect
		response.sendRedirect("template.jsp?BODY=uploadResult.jsp?R=" + result);
	}

}
