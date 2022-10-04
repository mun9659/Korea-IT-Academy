package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lifecycle.*;

@Configuration
public class AppCtx3 { // 설정 클래스가 먼저 Bean 객체로 생성
	
	@Bean
	public Message message() { // 인스턴스 메서드 호출 되려면 객체?
		Message ms = new Message();
		ms.setName("사용자01");
		
		return ms;
	}
	
	@Bean(initMethod="init", destroyMethod="close")
	public Message2 message2() {
		Message2 ms = new Message2();
		ms.setName("사용자02");
		
		return ms;
	}
}
