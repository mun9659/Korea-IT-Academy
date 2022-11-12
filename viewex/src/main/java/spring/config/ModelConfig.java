package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import commons.Utils;

@Configuration
@ComponentScan({"services", "models"})
public class ModelConfig {
	@Bean
	public Utils utils() {
		return new Utils();
	}
}
