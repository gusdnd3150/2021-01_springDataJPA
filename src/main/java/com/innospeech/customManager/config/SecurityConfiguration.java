package com.innospeech.customManager.config;

import org.aspectj.weaver.ast.And;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	public void configure(WebSecurity web) {

		web.ignoring().antMatchers("/resources/**");
		web.ignoring().antMatchers("/css/**", "/js/**", "image/**", "/fonts/**", "/favicon.ico", "/manifest.json");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/h2-console/**").permitAll()
			.and()
			.csrf().ignoringAntMatchers("/h2-console/**", "/");
		
		
		 http.csrf().disable(); 
		 http.headers().frameOptions().disable();
		 	

	}
}
