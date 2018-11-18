package org.spring.hello.spring.domain.autowiring.annotation.by_name;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by sergii on 16.11.18.
 */
@Component("webPage")
public class WebPage {
    @Resource(name = "webPageUser")
    private WebPageUser webPageUser;

    @Override
    public String toString() {
        return "Application [user=" + webPageUser + "]";
    }
}
