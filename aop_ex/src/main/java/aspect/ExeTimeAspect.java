package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
// @Order(1) // AppCtxWithCache의 실행 순서를 바꿀 수 있게 하는 Order 애노테이션
public class ExeTimeAspect {
	
	// 공통 기능을 적용할 대상을 결정
	// execution(수식어패턴? 리턴타입패턴 클래스이름패턴?메서드이름패턴(매개변수패턴))
	// 수식어패턴은 생략 가능 / public, protected 등이 온다. 스프링 AOP에는 public 메서드에만 적용할 수 있어서 사실상 public 만 의미있음
	@Pointcut("execution(public * aopex..*(..))")
	private void publicTarget() {
		
	}
	
	// Around Advice 설정
	@Around("publicTarget()") // publicTarget() 메서드에 정의한 Pointcut에 공통 기능을 적용
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable { // ProceedingJoinPoint 타입 매개변수는 프록시 대상 객체의 메서드를 호출할 때 사용
		long start = System.nanoTime();
		try {
			Object result = joinPoint.proceed(); // 실제 대상 객체의 메서드를 호출
			return result;
		} finally {
			long end = System.nanoTime();
			Signature sig = joinPoint.getSignature(); // 메서드의 시그니쳐(메서드 이름과 매개변수를 합친것), 호출되는 메서드에 대한 정보를 구한다.
			// Object getTarget() : 대상 객체를 구한다. | Object[] getArgs() : 매개변수 목록을 구한다.
			System.out.printf("%s.%s(%s) 실행 시간 : %d ns \n", joinPoint.getTarget().getClass().getSimpleName(), sig.getName(), Arrays.toString(joinPoint.getArgs()), end - start);
		}
	}
}
