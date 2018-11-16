package org.spring.hello.spring.domain;

/**
 * Created by sergii on 13.11.18.
 */
public class HelloWorldImpl implements HelloWorld {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello:" + name);
    }
}
