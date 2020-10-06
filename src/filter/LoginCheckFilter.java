package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter("/bbsPost")
public class LoginCheckFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginCheckFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {// �ݹ�޼���
		// ���ǿ��� LOGIN�̶�� �̸��� �Ӽ��� ã�´�.
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		String id = (String) session.getAttribute("LOGIN");
		if (id != null) { // �Ӽ��� ������ �α����� �� ���

			chain.doFilter(request, response); // ���Ͱ� ó���� ��û�� �������� �Ѱ��� ��
		} else {// ������ �α����� �ȵ� ���
			// �������� �ٲ۴�.(�α��� �ȳ� JSP)Redirect
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("template.jsp?BODY=introLogin.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
