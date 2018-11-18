package org.spring.hello.spring.domain.autowiring.annotation.by_type;

import org.springframework.stereotype.Component;

/**
 * Created by sergii on 16.11.18.
 */
@Component
public class Mobile {

    private String number = "213817381287";

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Mobile [number=" + number + "]";
    }
}
