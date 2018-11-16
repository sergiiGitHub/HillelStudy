package org.spring.hello.spring.domain;

/**
 * Created by sergii on 13.11.18.
 */
public class RSAEncryption implements Encryption {
    @Override
    public void ecncryptData() {
        System.out.println("Encription data using RSA");
    }
}
