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
		String savePath = "/upload"; // �̹����� ����� ���� �̸�
		int maxLimit = 5 * 1024 * 1024; // �ִ� �̹��� ũ�� 5M
		ServletContext context = this.getServletContext();
		String realPath = context.getRealPath(savePath); // ������ ȹ��
		String filename = ""; // ���ε尡 �����ϸ� �����̸��� ����� ����
		String encType = "UTF-8";// ���ε忡 ����� ����ڵ�
		String url = ""; // ȭ����ȯ�� ���� url�ּ�
		try {
			MultipartRequest multipart = new MultipartRequest(request, realPath, maxLimit, encType,
					new DefaultFileRenamePolicy());
			UploadCrud crud = new UploadCrud();
			String id = multipart.getParameter("id");
			String pwd = multipart.getParameter("password");
			Writing writing = crud.getImage(Integer.parseInt(id));
			if (writing.getPassword().contentEquals(pwd)) {// ��ȣ�� ��ġ�ϴ� ���
				writing.setTitle(multipart.getParameter("title"));
				writing.setWriter_name(multipart.getParameter("name"));
				writing.setEmail(multipart.getParameter("email"));
				writing.setContent(multipart.getParameter("content"));
				filename = multipart.getFilesystemName("image_name");
				if (filename != null) {// �� �̹��� ������ ������ ���, �� �̹����� ������ ���
					writing.setImage_name(filename);// �̹��� �����̸� ����
				}
				// DB���� ����
				crud.updateImage(writing);
				url = "template.jsp?BODY=updateResult.jsp?seqno=" + id;
			} else { // ��ȣ�� ��ġ���� �ʴ� ���
				url = "template.jsp?BODY=updateResult.jsp?id=" + id;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(url);
	}

}
