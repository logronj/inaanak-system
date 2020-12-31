package com.logronj.config;

import java.sql.DriverManager;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
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
public class AppConfig implements WebMvcConfigurer{
	
	private static final String HOST = "ec2-34-196-34-158.compute-1.amazonaws.com";
	private static final String PORT = "5432";
	private static final String PATH = "postgres://edacvgrmdumvfy:a636a6a90467d5daad6c5e42c21ddbae8a9a6b48bb48205d2774dbe12eed5513@ec2-34-196-34-158.compute-1.amazonaws.com:5432/d6jn4b9fdlp9f7";
	private static final String USER = "edacvgrmdumvfy";
	private static final String PW = "a636a6a90467d5daad6c5e42c21ddbae8a9a6b48bb48205d2774dbe12eed5513";
	
	private static final String LOCALHOST_URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
	private static final String LOCALHOST_USER = "logronj";
	private static final String LOCALHOST_PW = "Logronzkie01";
	
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
	
	@Bean
	public DriverManagerDataSource getDriverManagerDataSource() {
		
		String url = "jdbc:postgresql://" + HOST + ':' + PORT + PATH + "?sslmode=require";
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(url, USER, PW);
//		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
		return driverManagerDataSource;
	}
	
//	@Bean
//	public DataSource getDriverManagerDataSource() {
//	  return new EmbeddedDatabaseBuilder()
//	    .generateUniqueName(false)
//	    .setName("testdb")
//	    .setType(EmbeddedDatabaseType.H2)
//	    .addDefaultScripts()
//	    .setScriptEncoding("UTF-8")
//	    .ignoreFailedDrops(true)
//	    .build();
//	}
	

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDriverManagerDataSource());
		return jdbcTemplate;
	}
	
}
