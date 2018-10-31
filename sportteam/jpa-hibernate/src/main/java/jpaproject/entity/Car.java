package jpaproject.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sergii on 30.10.18.
 */

@Entity
@SuppressWarnings("all")
@Table(name = "cars")
@NamedQuery(name = "Car.getAll", query = "SELECT c from Car c")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date releaseDate;

    @Column(name = "cost")
    private float cost;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int i) {
        cost = i;
    }

    public void setReleaseDate(Date date) {
        this.releaseDate = date;
    }

    @Override
    public String toString() {
        return "id:" + id + "; name: " + name + "; d:" + releaseDate;
    }
}
