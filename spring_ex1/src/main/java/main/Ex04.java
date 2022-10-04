package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx3;
import lifecycle.*;

public class Ex04 {

	public static void main(String[] args) {
		// 1. 객체 생성 -> 2. 의존성 해결 -> 3. 초기화
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx3.class);
		
		Message ms = ctx.getBean(Message.class); // 객체 생성 X, 객체를 스프링 컨테이너 안에서 조회 -> 가져오기 기능
		ms.send();
		
		Message2 ms2 = ctx.getBean(Message2.class);
		ms2.send();
		
		ctx.close(); // 4. 소멸(소멸 전에 사용자 정의 메서드 호출)
	}

}
