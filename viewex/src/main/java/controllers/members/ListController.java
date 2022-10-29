package controllers.members;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import models.member.Member;

@Controller
public class ListController {
	
	@GetMapping("/members")
	public String members(Model model) {
		
		List<Member> members = new ArrayList<>();
		
		for(int i = 1; i <= 10; i++) {
			Member member =new Member();
			member.setMemId("user"+i);
			member.setMemNm("사용자"+i);
			member.setEmail("user"+i+"@test.org");
			member.setMobile("010-0000-000"+i);
			member.setRegDt(LocalDateTime.now());
			
			members.add(member);
		}
		model.addAttribute("members", members);
		
		return "member/list";
	}
}
