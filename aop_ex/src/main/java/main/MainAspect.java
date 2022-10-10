package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aopex.Calculator;
import aopex.RecCalculator;
import config.AppCtx;

public class MainAspect {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		// 수정 전
		// Calculator cal = ctx.getBean("calculator", Calculator.class);
		
		// 수정 후 (import에도 RecCalculator 추가)
		// BeanNotOfRequiredTypeException 발생, 'jdk.proxy2.$Proxy18'으로 나타나는데 교육에는 Proxy17로 나타난다. 이유가 뭘까?
		// Calculator 인터페이스를 상속받은 프록시 타입이기 때문에 RecCalculator로 타입 변환을 할 수 없기에 Exception 발생
		// Bean 객체가 인터페이스를 상속 받을 때 클래스를 이용해서 만들고 싶다면 AppCtx의 @EnableAspectJAutoProxy(proxyTargetCalss = true)로 설정한다.
		// 이후 Exception 없이 정상적으로 RecCalculator를 받았다.
		RecCalculator cal = ctx.getBean("calculator", RecCalculator.class); 
		long fiveFact = cal.factorial(5);
		System.out.println("cal.factorial(5) = " + fiveFact);
		System.out.println(cal.getClass().getName());
		ctx.close();
	}

}
