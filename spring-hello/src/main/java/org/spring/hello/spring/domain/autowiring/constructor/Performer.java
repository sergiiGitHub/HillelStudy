package org.spring.hello.spring.domain.autowiring.constructor;

/**
 * Created by sergii on 16.11.18.
 */
public class Performer {

    private Instrument instrument;

    public Performer(Instrument instrument) {
        this.instrument = instrument;
    }

    @Override
    public String toString() {
        return "Performer: {instrument" + instrument + "}";
    }
}
