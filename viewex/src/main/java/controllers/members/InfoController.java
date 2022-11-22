package controllers.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import models.Member.Member;
import models.Member.MemberDao;

@Controller
public class InfoController {
	
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/member/{id}") // /member/user01, /member/user02
	public String memberInfo(@PathVariable("id") String memId, Model model) {
		Member member = memberDao.get(memId);
		model.addAttribute("member", member);
		
		return "member/info";
	}
}
