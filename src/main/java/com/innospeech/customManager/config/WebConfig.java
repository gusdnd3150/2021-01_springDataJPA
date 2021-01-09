package com.innospeech.customManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport  {
	
	 @Override
	   protected void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(new Intercepter())
	            .addPathPatterns("/admin/**");
	            //.excludePathPatterns("/admin/myPage");
	      
	      registry.addInterceptor(new Intercepter())
	            .addPathPatterns("/user/**");
	   }
}
