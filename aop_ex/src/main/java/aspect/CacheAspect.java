package aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
// @Order(2) // AppCtxWithCache의 실행 순서를 바꿀 수 있게 하는 Order 애노테이션
public class CacheAspect {
	private Map<Long, Object> cache = new HashMap<>();
	
	// 주어진 교육과 달리 수식어패턴을 생략
	@Pointcut("execution(* aopex..*(long))")
	public void cacheTarget() {
		
	}
	
	// @Around("aspect.ExeTimeAspect.publicTarget()") // 다른 클래스에 위치한 @Pointcut 애노테이션으로 정의된 클래스 이름을 갖고와 사용할 수 있다.
	@Around("cacheTarget()") // @Around 애노테이션에 execution 명시자를 직접 지정 가능
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		Long num = (Long) joinPoint.getArgs()[0];
		if(cache.containsKey(num)) {
			System.out.printf("CacheAspect: Cache에서 구함[%d]\n" , num);
			return cache.get(num);
		}
		
		Object result = joinPoint.proceed();
		cache.put(num, result);
		System.out.printf("CacheAspect: Cache에 추가[%d]\n", num);
		return result;
	}
	
		
}
