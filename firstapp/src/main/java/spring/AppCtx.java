package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {
	
	@Bean
	public Greet greet() {
		Greet greet = new Greet();
		greet.setName("이름");
		return greet;
	}
}
