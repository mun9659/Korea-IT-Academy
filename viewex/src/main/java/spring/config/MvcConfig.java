 package spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import commons.auth.MemberOnlyInterceptor;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

@Configuration
@EnableWebMvc
@Import(DbConfig.class)
public class MvcConfig implements WebMvcConfigurer {
	
	@Value("${file.uploadPath}")
	private String uploadPath;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 정적 경로 -> 이미지, CSS, js, 파일 업로드 
		registry.addResourceHandler("/**")
				.addResourceLocations("classpath:/static/");
		
		// 파일 업로드 접근 URL
		registry.addResourceHandler("/uploads/**")
			.addResourceLocations("file:///" + uploadPath + "/");
	}
	
	
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext(applicationContext);
		templateResolver.setPrefix("/WEB-INF/view/");
		templateResolver.setSuffix(".html");
		templateResolver.setCacheable(false);
		return templateResolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.setEnableSpringELCompiler(true);
		templateEngine.addDialect(new Java8TimeDialect());
		templateEngine.addDialect(new LayoutDialect());
		return templateEngine;
	}

	@Bean
	public ThymeleafViewResolver thymeleafViewResolver() {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setContentType("text/html");
		resolver.setCharacterEncoding("utf-8");
		resolver.setTemplateEngine(templateEngine());
		return resolver;
	}
		
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.viewResolver(thymeleafViewResolver());
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasename("messages.message");
		ms.setDefaultEncoding("UTF-8");
		
		return ms;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(memberOnlyInterceptor())
			.addPathPatterns("/mypage/**");
	}
	
	@Bean
	public MemberOnlyInterceptor memberOnlyInterceptor() {
		return new MemberOnlyInterceptor();
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		configurer.setLocations(new ClassPathResource("application.properties"));
		return configurer;
	}
}
