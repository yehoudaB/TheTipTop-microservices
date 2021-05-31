package com.dsp.theTipTop;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
		 .antMatcher("/**").authorizeRequests()
         .antMatchers("/").permitAll()
         .anyRequest().authenticated()
         .and().oauth2Login()
         .defaultSuccessUrl("/users/oauth2LoginSuccess")
         .and().formLogin() 
         .defaultSuccessUrl("/users/formLoginSuccess");
	}
	
	
}