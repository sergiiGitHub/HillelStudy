package org.spring.hello.spring.domain.autowiring.byType;

/**
 * Created by sergii on 13.11.18.
 */
public class Employee {
    private EmployeeAddress address;

    public EmployeeAddress getAddress() {
        return address;
    }
    public void setAddress(EmployeeAddress address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Employee [address=" + address + "]";
    }
}