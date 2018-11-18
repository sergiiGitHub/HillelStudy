package org.spring.hello.spring.test.empl;

import org.springframework.stereotype.Component;

/**
 * Created by sergii on 16.11.18.
 */
@Component
public class Enginear implements Employee {

    private int payRate = 300;

    @Override
    public void showPayrate() {
        System.out.println("pr:" + payRate);
    }
}
