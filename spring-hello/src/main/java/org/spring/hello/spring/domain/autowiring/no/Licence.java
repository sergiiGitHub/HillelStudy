package org.spring.hello.spring.domain.autowiring.no;

/**
 * Created by sergii on 16.11.18.
 */
public class Licence {

    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Licence [number" + number + "]";
    }
}
