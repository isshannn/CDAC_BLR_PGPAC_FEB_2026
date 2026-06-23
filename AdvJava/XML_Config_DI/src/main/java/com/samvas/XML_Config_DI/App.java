package com.samvas.XML_Config_DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        Library lib_obj = (Library) context.getBean("lib");
        lib_obj.displayLib();
    }
}
