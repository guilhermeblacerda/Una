package com.una.mvp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecutiryConfig {
	
	@Bean
	public SecurityFilterChain securiryFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(auth -> 
			auth.requestMatchers("/","/index.html","/error").permitAll().anyRequest().authenticated()
		)
		.formLogin(login -> login.disable())
		.httpBasic(basic -> basic.disable());
		
		return http.build();
	}
}
