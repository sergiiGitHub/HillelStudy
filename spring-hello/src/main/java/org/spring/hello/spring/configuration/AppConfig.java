package org.spring.hello.spring.configuration;

import org.spring.hello.spring.domain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

/**
 * Created by sergii on 13.11.18.
 */

@Configuration
@ComponentScan("org.spring.hello.spring")
public class AppConfig {

    @Bean(name = "helloWorldBean")
    @Description("This is Sample")
    public HelloWorld helloWorld() {
        return new HelloWorldImpl();
    }

    @Bean(name = "goodByeBean")
    public GoodBye goodBye() {
        return new GoodByeImpl();
    }

    @Bean(name = "messaging")
    @Description("This will ")
    public Messaging messaging() {
        return new ActiveMessaging();
    }

    @Bean(name = "encryption")
    public Encryption encryption() {
        return new RSAEncryption();
    }

    @Bean(name = "communication")
    public Communication communication() {
        Communication communication = new Communication(encryption());
        communication.setMessaging(messaging());
        return communication;
    }

}
