package controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CookieExamController {
	@GetMapping("/ex01")
	public void exam(HttpServletResponse response) {
		Cookie cookie = new Cookie("key1", "value1");
		cookie.setMaxAge(60 * 60 * 24 * 7); // 일주일 뒤 만료시간
		response.addCookie(cookie); // 응답 헤더 : Set-Cookie : key1=value1;
	
		throw new RuntimeException("에러!");
	}
	
	@GetMapping("/ex02")
	public void exam2(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie : cookies) {
			System.out.printf("key=%s, value=%s\n", cookie.getName(), cookie.getValue());
		}
	}
	
	@GetMapping("/ex03")
	public void exam3(@CookieValue("key1") String name) {
		System.out.println(name);
	}
}
