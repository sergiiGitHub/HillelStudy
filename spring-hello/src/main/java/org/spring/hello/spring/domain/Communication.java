package org.spring.hello.spring.domain;

/**
 * Created by sergii on 13.11.18.
 */
public class Communication {

    private Messaging messaging;

    private Encryption encryption;

    public Communication(Encryption encryption) {
        this.encryption = encryption;
    }

    public void setMessaging(Messaging messaging) {
        this.messaging = messaging;
    }

    public void communicate() {
        messaging.sendMsg();
    }

    public void encrypt() {
        encryption.ecncryptData();
    }

    public void both() {
        messaging.sendMsg();
        encryption.ecncryptData();
    }
}
