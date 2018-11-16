package org.spring.hello.spring.domain;

/**
 * Created by sergii on 13.11.18.
 */
public class ActiveMessaging implements Messaging{
    @Override
    public void sendMsg() {
        System.out.println("Sending msg via" + ActiveMessaging.class.getSimpleName());
    }
}
