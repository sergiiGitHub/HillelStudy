package org.spring.hello.spring.domain.autowiring.annotation.by_name;

import org.springframework.stereotype.Component;

/**
 * Created by sergii on 16.11.18.
 */

@Component("webPageUser")
public class WebPageUser {

    private String name = "defName";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WebPageUser [name=" + name + "]";
    }
}
