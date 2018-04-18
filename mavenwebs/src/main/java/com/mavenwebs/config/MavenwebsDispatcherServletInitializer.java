package com.mavenwebs.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MavenwebsDispatcherServletInitializer 
						extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses() 
	{
		
		return new Class[]
				{
						HibernateConfig.class,
						MavenwebsLoginSuccessHandler.class,
						MavenwebsSecurityConfig.class	
				};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{
		
		//config 클래스를 추가할 경우 반드시 이곳에 추가
		return new Class[] 
		{
			ServletContextConfig.class,
			TilesCofig.class,
			MavenwebsMvcConfig.class
				
		};
	}

	@Override
	protected String[] getServletMappings() 
	{
		
		return new String[] {"/"};
	}
	
	//한글 깨지지 않게 설정
		public Filter characterEncondingFilter()
		{
			CharacterEncodingFilter filter = new CharacterEncodingFilter();
			filter.setEncoding("UTF-8");
			filter.setForceEncoding(true);
			
			return filter;
		}
	
	//필터 사용 설정
	@Override
	protected Filter[] getServletFilters() 
	{
		
		return new Filter[]
				{
					characterEncondingFilter()
				};
	}

}
