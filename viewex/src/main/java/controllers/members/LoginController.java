package controllers.members;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/member/login")
	public String form(Model model) {
		
		String[] addScript = {"member/login", "member/login2"}; // /js/member/login.js, /js/member/login2.js
		String[] addCss = {"member/login", "member/login2"}; // /css/member/login.css, /css/member/login2.css
		
		model.addAttribute("addScript", addScript);
		model.addAttribute("addCss", addCss);
		
		return "member/login";
	}
}
