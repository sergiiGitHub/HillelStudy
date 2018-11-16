package org.spring.hello.spring;

import org.spring.hello.spring.configuration.AppConfig;
import org.spring.hello.spring.domain.Communication;
import org.spring.hello.spring.domain.GoodBye;
import org.spring.hello.spring.domain.HelloWorld;
import org.spring.hello.spring.domain.autowiring.byName.Application;
import org.spring.hello.spring.domain.autowiring.byType.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sergii on 13.11.18.
 */

public class AppMain {

    public static void main(String[] args) {
//        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorldBean");
//        helloWorld.sayHello("Spring 1");
//
//        GoodBye goodBye = (GoodBye) context.getBean("goodByeBean");
//        goodBye.sayGoodBye("Spring");
//
//        Communication comm = (Communication) context.getBean("communication");
//        comm.communicate();
//        comm.encrypt();
//        comm.both();

//        AbstractApplicationContext contextXml = new ClassPathXmlApplicationContext("helloWorld-config.xml");
        AbstractApplicationContext contextDependencyInjection = new ClassPathXmlApplicationContext("helloworld-config.xml");
//        Communication communication = (Communication) contextDependencyInjection.getBean("communication");
//        communication.communicate();
//        communication.encrypt();
//        communication.both();
//
//        Application application = (Application) contextDependencyInjection.getBean("application");
//        System.out.println("app detail: " + application);

        Employee employee = (Employee) contextDependencyInjection.getBean("employee");
        System.out.println("app detail: " + employee);
    }
}
