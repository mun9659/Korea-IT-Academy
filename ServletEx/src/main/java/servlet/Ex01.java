package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex01 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		// resp.setCharacterEncoding("utf-8"); // 이렇게 해도 되지만 기본적으로 contentType에 text/html; charset=utf-8 로 쓰는게 좋다
		PrintWriter out = resp.getWriter();
		//out.print("<h1>Hello!!</h1>");
		out.print("<h1>안녕하세요!!</h1>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId = req.getParameter("memId"); // 메서드 상관 없이 갖고오기
		String memPw = req.getParameter("memPw");
	
		System.out.printf("memId=%s, memPw= %s\n", memId, memPw);
	}
	
}
