package commons.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import models.Member.Member;

public class MemberOnlyInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();  
		Member member = (Member)session.getAttribute("member");
		if(member == null) { // 로그인 하지 않는 경우(비회원)
			String url = request.getContextPath() + "/member/login";
							  // viewex - context_path
			response.sendRedirect(url); // 로그인 페이지로 이동
			return false;
		}
		return true;
	}
	
}
