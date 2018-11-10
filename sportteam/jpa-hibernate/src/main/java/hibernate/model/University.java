package hibernate.model;

import javax.persistence.*;

/**
 * Created by sergii on 06.11.18.
 */

@Entity
@Table(name = "UNIVERSITY")
@SuppressWarnings("all")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//default
    @Column(name = "UNIVERSITY_ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COUNTRY")
    private String country;

    public University(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public University() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
