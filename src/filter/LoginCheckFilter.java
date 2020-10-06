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
			throws IOException, ServletException {// 콜백메서드
		// 세션에서 LOGIN이라는 이름의 속성을 찾는다.
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		String id = (String) session.getAttribute("LOGIN");
		if (id != null) { // 속성이 있으면 로그인이 된 경우

			chain.doFilter(request, response); // 필터가 처리한 요청을 다음으로 넘겨줄 때
		} else {// 없으면 로그인이 안된 경우
			// 페이지를 바꾼다.(로그인 안내 JSP)Redirect
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
