package org.spring.hello.spring.domain.autowiring.annotation.qualifier;

import org.springframework.stereotype.Component;

/**
 * Created by sergii on 16.11.18.
 */
@Component
public class Ferrari implements Car{
    @Override
    public String getCarName() {
        return "Ferrari";
    }
}
