package hibernate.model;

import javax.persistence.*;

/**
 * Created by sergii on 02.11.18.
 */

@Entity
@Table(name = "TEACHER_ADDRESS")
@SuppressWarnings("all")
public class TeacherAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//default
    @Column(name = "TEACHER_ADDRESS_ID")
    private long id;

    @Column(name = "STREET")
    private String street;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private String country;

    public TeacherAddress(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
