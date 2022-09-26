package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		Greet greet = ctx.getBean("greet", Greet.class);
		greet.hello();
		
		Greet greet2 = ctx.getBean("greet", Greet.class);
		greet2.hello();
		
		System.out.println(greet == greet2); // 싱글톤 패턴 (Singleton Pattern) : 같은 객체를 가지고 넘긴다 
		
		ctx.close();
		
	}
}
