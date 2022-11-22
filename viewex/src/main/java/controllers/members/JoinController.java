package controllers.members;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import services.member.JoinService;

@Controller
@RequestMapping("/member")
public class JoinController {
	
	@Autowired
	private JoinService joinService;
	
	@GetMapping("/join") // /member/join
	public String join(Model model) {
		 
		JoinRequest joinRequest = new JoinRequest();
		model.addAttribute("joinRequest", joinRequest);
		return "member/join";
	 }
	
	@PostMapping("/join") // /member/join_ps
	public String joinPs(@Valid JoinRequest joinRequest, Errors errors) { // @Valid 애노테이션 
		
		// javax.validation에서 체크할 수 없는 것을 넣어놓는다.
		new JoinValidator().validate(joinRequest, errors);
		
		if(errors.hasErrors()) { // 검증 실패가 1개 이상 있다면
			return "member/join";
		}
		
		// 검증 성공 -> 가입 처리
		joinService.process(joinRequest);
		
		return "redirect:/member/login";
	}
}
