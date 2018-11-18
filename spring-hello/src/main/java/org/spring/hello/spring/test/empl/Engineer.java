package org.spring.hello.spring.test.empl;

import org.springframework.stereotype.Component;

/**
 * Created by sergii on 16.11.18.
 */
@Component
public class Engineer implements Employee {

    private static final String TAG = Engineer.class.getSimpleName();

    private int payRate = 300;

    @Override
    public void showPayrate() {
        System.out.println(TAG + ": pr:" + payRate);
    }
}
