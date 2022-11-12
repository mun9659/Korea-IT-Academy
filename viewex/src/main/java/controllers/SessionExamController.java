package controllers;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionExamController {
	@GetMapping("/ex04")
	public void ex04(HttpSession session) {
		session.setAttribute("key2", "value2");
	}
	
	@GetMapping("/ex05")
	public void ex05(HttpSession session) {
		String value = (String) session.getAttribute("key2");
		System.out.printf("key2=%s\n", value);
	}
}
