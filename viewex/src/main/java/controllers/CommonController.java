package controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("controllers")
public class CommonController {
	@ExceptionHandler(Exception.class)
	public String errorHandle(Exception e, Model model) {
		
		// System.out.println("넘어갔냐?");
		
		model.addAttribute("message", e.getMessage());
		
		return "common/errors";
	}
}
