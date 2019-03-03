package com.student.fhms.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.student.fhms.config.AppConfig;

public class Test {

	public static void main(String[] args) {
		Test p=new Test();
		p.start(args);
		// TODO Auto-generated method stub
//		JavaConfigApplicationContext  context =new JavaConfigApplicationContext (AppConfig.class);
//		//AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
//		String message=context.getBean("showMessage",String.class);
//		System.out.println(message);

	}
	private void start(String[] args) {
		AnnotationConfigApplicationContext context = 
             new AnnotationConfigApplicationContext(AppConfig.class);
		String message=context.getBean("showMessage",String.class);
        System.out.println("The method of my Bean: " +message);
    }

}
