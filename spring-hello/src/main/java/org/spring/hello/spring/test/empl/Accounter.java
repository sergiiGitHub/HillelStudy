package org.spring.hello.spring.test.empl;

import org.springframework.stereotype.Component;

/**
 * Created by sergii on 16.11.18.
 */
@Component
public class Accounter implements Employee {

    private static final String TAG = Accounter.class.getSimpleName();

    private int payRate = 100;

    public Accounter() {

    }

    @Override
    public void showPayrate() {
        System.out.println(TAG + ": pr:" + payRate);
    }
}
