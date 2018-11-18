package org.spring.hello.spring.domain.autowiring.no;

/**
 * Created by sergii on 16.11.18.
 */
public class Driver {
    private Licence licence;

    public Licence getLicence() {
        return licence;
    }

    public void setLicence(Licence licence) {
        this.licence = licence;
    }

    @Override
    public String toString() {
        return "Driver [licence=" + licence + "]";
    }
}
