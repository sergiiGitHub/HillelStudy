package org.spring.hello.spring.domain;

/**
 * Created by sergii on 13.11.18.
 */
public class GoodByeImpl implements GoodBye {
    @Override
    public void sayGoodBye(String name) {
        System.out.println("GoodBye:" + name);
    }
}
