package controllers.members;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import models.member.Member;

@Controller
public class JoinController {
	@GetMapping("/member/form")
	public String form(Model model) {
		Member member = new Member();
		member.setMemId("user01");
		member.setMemNm("사용자01");
		member.setEmail("user01@test.org");
		member.setMobile("010-0000-0000");
		member.setIntro("<h1>자기소개!</h1>");
		member.setRegDt(LocalDateTime.now());
		model.addAttribute("member", member);
		return "member/form";
	}
}
