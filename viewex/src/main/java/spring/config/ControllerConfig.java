package spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan({"controllers", "restcontrollers"})
public class ControllerConfig {

}
