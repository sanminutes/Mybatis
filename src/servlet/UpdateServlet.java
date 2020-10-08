package servlet;

import java.io.IOException;

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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String savePath = "/upload"; // 이미지가 저장될 폴더 이름
		int maxLimit = 5 * 1024 * 1024; // 최대 이미지 크기 5M
		ServletContext context = this.getServletContext();
		String realPath = context.getRealPath(savePath); // 절대경로 획득
		String filename = ""; // 업로드가 성공하면 파일이름이 저장될 변수
		String encType = "UTF-8";// 업로드에 사용할 언어코드
		String url = ""; // 화면전환에 사용될 url주소
		try {
			MultipartRequest multipart = new MultipartRequest(request, realPath, maxLimit, encType,
					new DefaultFileRenamePolicy());
			UploadCrud crud = new UploadCrud();
			String id = multipart.getParameter("id");
			String pwd = multipart.getParameter("password");
			Writing writing = crud.getImage(Integer.parseInt(id));
			if (writing.getPassword().contentEquals(pwd)) {// 암호가 일치하는 경우
				writing.setTitle(multipart.getParameter("title"));
				writing.setWriter_name(multipart.getParameter("name"));
				writing.setEmail(multipart.getParameter("email"));
				writing.setContent(multipart.getParameter("content"));
				filename = multipart.getFilesystemName("image_name");
				if (filename != null) {// 새 이미지 파일을 선택한 경우, 즉 이미지를 변경한 경우
					writing.setImage_name(filename);// 이미지 파일이름 설정
				}
				// DB에서 변경
				crud.updateImage(writing);
				url = "template.jsp?BODY=updateResult.jsp?seqno=" + id;
			} else { // 암호가 일치하지 않는 경우
				url = "template.jsp?BODY=updateResult.jsp?id=" + id;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(url);
	}

}
