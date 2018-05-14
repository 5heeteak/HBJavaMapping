package com.mavenwebs.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
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
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry)
	{
		registry
		.addViewController("/")
		.setViewName("redirect:/index");
		
		// TODO Auto-generated method stub
		//WebMvcConfigurer.super.addViewControllers(registry);
	}
	
	//UTF-8 설정
	@Override
	   public void configureMessageConverters(List<HttpMessageConverter<?>> converters) 
	{

	      final StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(
	            Charset.forName("UTF-8"));
	      stringHttpMessageConverter.setWriteAcceptCharset(false);

	      converters.add(stringHttpMessageConverter);

	      WebMvcConfigurer.super.configureMessageConverters(converters);
	   }
}
