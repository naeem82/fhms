package com.student.fhms.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.student.fhms.aop.FHMSLoggingAspect;

//implement WebMvcConfigurer to load resources from webjar lik bootstrap
//and override its method addResourceHandlers
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan("com.student.fhms")
public class AppConfig implements WebMvcConfigurer {

	// define a bean for viewResolver

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;

	}
    // define a bean for aop
	@Bean
	public FHMSLoggingAspect fHMSLoggingAspect(){
		return new FHMSLoggingAspect();
	}
	
	// laod webjars for bootstrap framework
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
		// WebMvcConfigurer.super.addResourceHandlers(registry);
	}

	//////////////////////handle exception generated by repository class/////////////////////////////////////////////////

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	//
	@Bean(name="multipartResolver")
	public StandardServletMultipartResolver resolver (){
		return new StandardServletMultipartResolver();
		
	}
	/**
     * Configure MessageSource to lookup any validation/error message in internationalized property files
     */
	@Bean
	public MessageSource messageSource(){
		ResourceBundleMessageSource messageSource= new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

}
