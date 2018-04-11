package com.mavenwebs.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MavenwebsDispatcherServletInitializer 
						extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses() 
	{
		
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{
		
		//config 클래스를 추가할 경우 반드시 이곳에 추가
		return new Class[] 
		{
			ServletContextConfig.class,
			HibernateConfig.class,
			TilesCofig.class,
			MavenwebsMvcConfig.class
				
		};
	}

	@Override
	protected String[] getServletMappings() 
	{
		
		return new String[] {"/"};
	}
	

}
