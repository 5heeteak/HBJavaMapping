package com.mavenwebs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc //MVC 설정 파일 사용
public class MavenwebsMvcConfig implements WebMvcConfigurer
{
	//resources 폴더 예외처리
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) 
	{
		registry
		.addResourceHandler("/resources/**")
		.addResourceLocations("/resources/");
		
		
	}
	

}
