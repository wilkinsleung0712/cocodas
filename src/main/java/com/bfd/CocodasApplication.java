package com.bfd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.bfd.config.JwtFilter;

@SpringBootApplication
public class CocodasApplication {
	
	// added filter on startup application
	@Bean
	public FilterRegistrationBean jwtFilter(){
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/rest/*");
		return registrationBean;
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CocodasApplication.class, args);
	}
}
