package org.spring.hello.spring.domain.autowiring.byType;

/**
 * Created by sergii on 13.11.18.
 */
public class EmployeeAddress {
    private String Street;
    private String city;

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "EmployeeAddress [Street=" + Street + ", city=" + city + "]";
    }
}
