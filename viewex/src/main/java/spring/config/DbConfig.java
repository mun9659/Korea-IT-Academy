package spring.config;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DbConfig {
	
	@Configuration
	@Profile("local")
	public static class DbConfigLocal {
		@Value("${db.driver-class-name}")
		private String driverClassName;
		@Value("${db.database}")
		private String database;
		@Value("${db.username}")
		private String username;
		@Value("${db.password}")
		private String password;
		
		@Bean(destroyMethod = "close")
		public DataSource dataSource() {
			System.out.println("===== local =====");
			DataSource ds = new DataSource();
			ds.setDriverClassName(driverClassName);
			ds.setUrl("jdbc:mysql://localhost:3306/"+ database+"?characterEncoding=utf8");
			ds.setUsername(username);
			ds.setPassword(password);
			ds.setInitialSize(2);
			ds.setMaxActive(10);
			ds.setTestWhileIdle(true);
			ds.setMinEvictableIdleTimeMillis(1000 * 60 * 3);
			ds.setTimeBetweenEvictionRunsMillis(1000 * 10); // db에 연결이 되어있는지 확인 체크
			
			return ds;
		}
		

		@Bean
		public JdbcTemplate jdbcTemplate() {
			JdbcTemplate jdbcTemplate = new JdbcTemplate();
			jdbcTemplate.setDataSource(dataSource());
			
			return jdbcTemplate;
		}
	}
	
	@Configuration
	@Profile("prod")
	public static class DbConfigProd {
		@Bean(destroyMethod = "close")
		public DataSource dataSource() {
			System.out.println("===== production =====");
			DataSource ds = new DataSource();
			ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost:3306/springStudy?characterEncoding=utf8");
			ds.setUsername("root1");
			ds.setPassword("aA!123456");
			ds.setInitialSize(2);
			ds.setMaxActive(10);
			ds.setTestWhileIdle(true);
			ds.setMinEvictableIdleTimeMillis(1000 * 60 * 3);
			ds.setTimeBetweenEvictionRunsMillis(1000 * 10); // db에 연결이 되어있는지 확인 체크
			
			return ds;
		}
		

		@Bean
		public JdbcTemplate jdbcTemplate() {
			JdbcTemplate jdbcTemplate = new JdbcTemplate();
			jdbcTemplate.setDataSource(dataSource());
			
			return jdbcTemplate;
		}
	}
	
	/*
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springStudy?characterEncoding=utf8");
		ds.setUsername("root");
		ds.setPassword("aA!123456");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		ds.setTestWhileIdle(true);
		ds.setMinEvictableIdleTimeMillis(1000 * 60 * 3);
		ds.setTimeBetweenEvictionRunsMillis(1000 * 10); // db에 연결이 되어있는지 확인 체크
		
		return ds;
	}
	*/
}
