package org.spring.hello.spring.domain.autowiring.annotation.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by sergii on 16.11.18.
 */
@Component
public class Bond {

    @Autowired
    @Qualifier("ferrari")
    private Car car;

    public void showCar() {
        System.out.println(car.getCarName());
    }
}
