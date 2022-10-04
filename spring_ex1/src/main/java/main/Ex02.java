package main;

import java.time.LocalDateTime;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import member.JoinService;
import member.ListService;
import member.MemberDto;

public class Ex02 {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		// 회원가입
		JoinService joinService = ctx.getBean("joinService", JoinService.class);
		MemberDto member = new MemberDto("user01", "1234567", "사용자01", LocalDateTime.now());
		joinService.process(member);
		
		// 회원 목록 출력
		ListService listService = ctx.getBean("listService", ListService.class);
		listService.listing();
		
		ctx.close();
	}

}
