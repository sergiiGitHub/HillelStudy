package org.spring.hello.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by sergii on 13.11.18.
 */
@Component
public class FirsClass {

    @Autowired SecondClass secondClass;

    public void sayHello() {
        System.out.println("Hello");
    }

    public void sayGb() {
        //System.out.println("bye");
        secondClass.sayGb();
    }
}
