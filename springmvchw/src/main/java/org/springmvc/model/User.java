package org.springmvc.model;

public class User {

    private long id;
    private String login;
    private String name;
    private int age;
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
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User other = (User) obj;
            return other.id == id;
        }
        return false;
    }
}
