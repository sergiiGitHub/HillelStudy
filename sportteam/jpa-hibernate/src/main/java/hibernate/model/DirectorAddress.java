package hibernate.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by sergii on 06.11.18.
 */

@Entity
@SuppressWarnings("all")
@Table(name = "DIRECTOR_ADDRESS")
public class DirectorAddress {
    /**
     * A GenericGenerator using the strategy "foreign" expects one parameter called "property"
     * and the expected value is an entity name.
     * This means your entity's ID will be the same as the linked entity.
     */

    @Id
    @Column(name = "ADDRESS_ID")
    @GeneratedValue(generator = "gen")//default
    @GenericGenerator(name="gen", strategy = "foreign", parameters = @Parameter(name = "property", value="director"))
    private long id;

    @Column(name = "STREET")
    private String street;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private String country;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Director director;

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

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
