package com.samvas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	    public static void main(String[] args) {

	        ApplicationContext context =
	                new ClassPathXmlApplicationContext(
	                        "spring.xml");

	        Employee emp =
	                context.getBean(
	                        "emp",
	                        Employee.class);
	 
	        emp.display();
	    }

}
