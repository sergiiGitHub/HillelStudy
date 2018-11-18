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
    @Qualifier("engineer")
    Employee engineer;

    @Autowired
    @Qualifier("manager")
    Employee manager;

    public void show() {
        accounter.showPayrate();
        engineer.showPayrate();
        manager.showPayrate();
    }
}
