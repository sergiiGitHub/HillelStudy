package org.spring.hello.spring.test;

import org.spring.hello.spring.test.empl.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by sergii on 16.11.18.
 */

@Component
public class Company {

    @Autowired
    @Qualifier("accounter")
    Employee accounter;

    @Autowired
    @Qualifier("enginear")
    Employee enginear;

    @Override
    public String toString() {
        return super.toString();
    }
}
