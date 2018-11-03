package hibernate.model;

import java.io.Serializable;

/**
 * Created by sergii on 02.11.18.
 */
public class Student implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private String section;

    public Student(String first, String last, String section) {
        firstName = first;
        lastName = last;
        this.section = section;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + section;
    }
}
