package config;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import member.JoinService;
import member.ListService;
import member.MemberDao;

@Configuration
public class AppCtx {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public JoinService joinService() {
		JoinService joinService = new JoinService();
		return joinService;
	}
	
	@Bean
	public ListService listService() {
		return new ListService();
	}
	
	@Bean
	public DateTimeFormatter dateTimeFormatter() {
		return DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
	}
}
