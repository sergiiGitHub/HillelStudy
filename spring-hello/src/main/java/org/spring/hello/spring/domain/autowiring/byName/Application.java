package org.spring.hello.spring.domain.autowiring.byName;

/**
 * Created by sergii on 13.11.18.
 */
public class Application {

    ApplicationUser applicationUser;

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    @Override
    public String toString() {
        return super.toString() + "{" + applicationUser + "}";
    }
}
