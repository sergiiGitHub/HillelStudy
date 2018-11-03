package hibernate.model;

import javax.persistence.*;

/**
 * Created by sergii on 02.11.18.
 */

@Entity
@Table(name = "TEACHER")
@SuppressWarnings("all")
public class Teacher {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//default
    private int id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "SESION")
    private String section;

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
    public boolean equals(Object obj) {
        if (obj instanceof Teacher) {
            Teacher other = (Teacher) obj;

            return other.getFirstName().equals(firstName)
                    && other.getLastName().equals(lastName)
                    && other.section.equals(section);
        }
        return false;
    }
}
