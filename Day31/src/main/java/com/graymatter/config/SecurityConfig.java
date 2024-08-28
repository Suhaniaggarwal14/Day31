package com.graymatter.config;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
//@EnableOAuth2Sso
public class SecurityConfig {
	
	@Autowired
	UserDetailsService service;
	
//	@Bean
//	public AuthenticationProvider authProvider()
//	{
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(service);
//		provider.setPasswordEncoder(new BCryptPasswordEncoder());
//		return provider;
//	}
	
	
//	public void myconfiguration(HttpSecurity http) throws Exception
//	{
//		http.csrf().disable()
//		.authorizeHttpRequests().requestMatchers("/login")
//		.permitAll()
//		.anyRequest()
//		.authenticated();
//		.and()
//		.formLogin().loginPage("/login")
//		.permitAll();
//	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.oauth2Login();
		return http.build();
	}

}
