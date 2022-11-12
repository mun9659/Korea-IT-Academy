package controllers.members;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	@RequestMapping("/member/logout")
	public String process(HttpSession session) {
		
		session.invalidate(); // 세션 데이터 비우기
		
		return "redirect:/member/login";
	}
}
