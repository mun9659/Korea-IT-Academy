package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import aopex.Calculator;
import aopex.RecCalculator;
import aspect.ExeTimeAspect;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)// @Aspect 애노테이션을 붙인 클래스를 공통 기능으로 적용하려면 @EnableAspectJAutoProxy 애노태이션을 설정 클래스에 붙어야한다
public class AppCtx {
	
	@Bean
	public ExeTimeAspect exeTimeAspect() { // 주석 처리하니까 ExeTimeAspect 로 안 간다.
		return new ExeTimeAspect();
	}
	
	@Bean
	public Calculator calculator() {
		return new RecCalculator();
	}
}
