package org.spring.hello.spring.test.empl;

import org.springframework.stereotype.Component;

/**
 * Created by sergii on 16.11.18.
 */
@Component
public class Manager implements Employee {

    private int payRate = 200;

    @Override
    public void showPayrate() {
        System.out.println("pr:" + payRate);
    }
}
