package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aopex.*;
import config.AppCtxWithCache;

public class MainAspectWithCache {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtxWithCache.class);
		
		Calculator cal = ctx.getBean("calculator", Calculator.class);
		cal.factorial(7); // CacheAspect 실행 -> ExeTimeAspect 실행 -> 대상 객체 실행
		cal.factorial(7); // 
		cal.factorial(5);
		cal.factorial(5); // 
		ctx.close();
	}
}
