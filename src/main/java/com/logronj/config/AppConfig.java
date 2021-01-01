package com.logronj.config;

import java.sql.DriverManager;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.logronj")
@PropertySources({
	@PropertySource("classpath:mail.properties"),
	@PropertySource("classpath:database.properties")
})

public class AppConfig implements WebMvcConfigurer{
	
	
	@Autowired
	private Environment env;
	
	
	@Bean
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
        .addResourceHandler("/resources/**")
        .addResourceLocations("/resources/");	
	}
	
//	@Bean
//	public DriverManagerDataSource getDriverManagerDataSource() {
//		
//		String url = "jdbc:postgresql://" + HOST + ':' + PORT + PATH + "?sslmode=require";
//		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(url, USER, PW);
//		driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
//		return driverManagerDataSource;
//	}
	
	@Bean
	public DriverManagerDataSource getDriverManagerDataSource() {
		DriverManagerDataSource driverManagerDataSource = 
				new DriverManagerDataSource(env.getProperty("db.url"), env.getProperty("db.user"), env.getProperty("db.pw"));
		driverManagerDataSource.setDriverClassName(env.getProperty("db.driverClassName"));
		return driverManagerDataSource;
	}
	

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDriverManagerDataSource());
		return jdbcTemplate;
	}
	
	
	/*
	 * Less secure app must be turned on on google account
	 * https://myaccount.google.com/lesssecureapps
	 * */
	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setHost(env.getProperty("mail.host"));
		javaMailSender.setUsername(env.getProperty("mail.username"));
		javaMailSender.setPassword(env.getProperty("mail.password"));
		javaMailSender.setPort(getIntProperty("mail.port"));
		
		Properties mailProperties = getMailProperty();
		
		javaMailSender.setJavaMailProperties(mailProperties);
		
		return javaMailSender;
	}

	private Properties getMailProperty() {
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		return mailProperties;
	}
	
	private Integer getIntProperty(String key) {
		String value = env.getProperty(key);
		return Integer.parseInt(value);
	}
	
}
