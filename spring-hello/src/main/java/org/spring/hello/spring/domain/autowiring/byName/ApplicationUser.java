package org.spring.hello.spring.domain.autowiring.byName;

/**
 * Created by sergii on 13.11.18.
 */
public class ApplicationUser {
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + "{"+ name + "}";
    }
}
