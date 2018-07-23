package com.accenture.lkm.web.webxml;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.accenture.lkm.spring.web.config.SpringWebContextConfigurator;

public class JavaWebIntializerOrWebXml extends AbstractAnnotationConfigDispatcherServletInitializer {

	// for root context
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {};
	}

	// for web context
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{SpringWebContextConfigurator.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/","*.html" };
	}
	

}
//equivalent to the web.xml
