package org.spring.hello.spring.domain.autowiring.constructor;

/**
 * Created by sergii on 16.11.18.
 */
public class Instrument {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Instrument: [name: " + name + "]";
    }
}
