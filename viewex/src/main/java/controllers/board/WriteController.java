package controllers.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WriteController {
	@GetMapping("/board/write")
	public String form() {
		
		return "board/form";
	}
	
	@PostMapping("/board/write")
	public String form_ps() {
		
		return "board/form_ps";
	}
}
