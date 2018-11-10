package hibernate.model;

import javax.persistence.*;

/**
 * Created by sergii on 06.11.18.
 */

@Entity
@SuppressWarnings("all")
@Table(name = "DIRECTOR")
public class Director {

    @Id
    @GeneratedValue
    @Column(name = "DIRECTOR_ID")
    private long id;

    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;

    @OneToOne(mappedBy = "director", cascade = CascadeType.ALL)
    private DirectorAddress directorAdress;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public DirectorAddress getDirectorAdress() {
        return directorAdress;
    }

    public void setDirectorAdress(DirectorAddress directorAdress) {
        this.directorAdress = directorAdress;
    }
}
