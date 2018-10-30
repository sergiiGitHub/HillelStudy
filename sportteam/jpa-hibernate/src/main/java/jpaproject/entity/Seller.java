package jpaproject.entity;

import javax.persistence.*;

/**
 * Created by sergii on 30.10.18.
 */
@Entity
@SuppressWarnings("all")
@Table(name = "sellers")
@NamedQuery(name = "Seller.getAll", query = "SELECT s from Seller s")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "full_name", length = 32)
    private String fullName;

    @Column(name = "age")
    private int age;

    @Column(name = "salary")
    private float salary;

    public Seller(String fullName, int age, float salary) {
        this.fullName = fullName;
        this.age = age;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
