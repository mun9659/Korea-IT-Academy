package controllers.members;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MembersController {
	@GetMapping
	public String members(@Valid SearchRequest request, Errors errors) {
		
		System.out.println(request);
		return "member/list";
	}
}
