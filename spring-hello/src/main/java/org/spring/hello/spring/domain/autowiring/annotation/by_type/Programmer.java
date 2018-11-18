package org.spring.hello.spring.domain.autowiring.annotation.by_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by sergii on 16.11.18.
 */

@Component("programmer")
public class Programmer {

    private final IdCard idCard;

    private Laptop laptop;

    @Autowired
    private Mobile mobile;

    @Autowired
    public Programmer(IdCard idCard) {
        this.idCard = idCard;
    }

    public IdCard getIdCard() {
        return idCard;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    @Autowired
    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public Mobile getMobile() {
        return mobile;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return laptop + "; " + mobile + "; " + idCard;
    }
}
