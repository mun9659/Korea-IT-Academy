package main;

import java.time.LocalDateTime;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx2;
import member.JoinService;
import member.ListService;
import member.MemberDto;

public class Ex03 {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx2.class);
		
		// 회원가입
		// JoinService joinService = ctx.getBean("joinService", JoinService.class);
		JoinService joinService = ctx.getBean(JoinService.class); // 클래스 안에 한 개의 객체만 있다면 굳이 이름을 적지 않아도 된다.
		MemberDto member = new MemberDto("user01", "1234567", "사용자01", LocalDateTime.now());
		joinService.process(member);
		
		// 회원 목록 출력
		// ListService listService = ctx.getBean("listService", ListService.class);
		ListService listService = ctx.getBean(ListService.class);
		listService.listing();
		
		ctx.close();
	}
}
