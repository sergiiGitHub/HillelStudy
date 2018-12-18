package org.springmvc.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "USER")
@Table(name = "USER")
public class User {

    @Id
    private long id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "LOGIN", nullable = false)
    private String login;
    @Column(name = "AGE", nullable = false)
    private int age;
    @Column(name = "SALARY", nullable = false)
    private int salary;

    public User(long id, String login, String name, int age, int salary) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        return  Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", salary=" + salary + ", age=" + age + "]";
    }

}
