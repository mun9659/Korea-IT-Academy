package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import commons.Utils;

@Configuration
public class ModelConfig {
	
	@Bean
	public Utils utils() {
		return new Utils();
	}
	
}
