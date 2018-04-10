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
		
		return new Class[] 
		{
			ServletContextConfig.class,
			HibernateConfig.class
				
		};
	}

	@Override
	protected String[] getServletMappings() 
	{
		
		return new String[] {"/"};
	}
	

}
