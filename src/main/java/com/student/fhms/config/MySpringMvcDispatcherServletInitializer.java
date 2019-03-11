package com.student.fhms.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{ AppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	// Programmatic registration of Servlet 3.0 For File Uploading
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setMultipartConfig(getMultipartConfigElement());
	}
	private MultipartConfigElement getMultipartConfigElement(){
		MultipartConfigElement multipartConfigElement=
				new MultipartConfigElement(LOCATION,MAX_FILE_SIZE,MAX_REQUEST_SIZE,FILE_SIZE_THRESHOLD);
		return multipartConfigElement;
	}
	private static final String LOCATION="c:/mytemp/";
	private static final long MAX_FILE_SIZE=1024*1024*5;    // Maximum 5 MB
	private static final long MAX_REQUEST_SIZE=1024*1024*20;     //20 MB
	private static final int FILE_SIZE_THRESHOLD=0;
}
