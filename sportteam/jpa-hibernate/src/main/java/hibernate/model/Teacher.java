package hibernate.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergii on 02.11.18.
 */

@Entity
@Table(name = "TEACHER")
@SuppressWarnings("all")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//default
    @Column(name = "TEACHER_ID")
    private long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "SESION")
    private String section;

    @OneToOne
    @JoinColumn(name = "HOME_ADDRESS_ID")
    private TeacherAddress teacherAddress;

    @ManyToOne(optional = false)
    @JoinColumn(name = "UNIVERSITY_ID")
    private TeacherUniversity teacherUniversity;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TEACHER_SUBJECT",
            joinColumns = {@JoinColumn(name = "TEACHER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "SUBJECT_ID")})
    private List<Subject> subjects = new ArrayList<>();

    public Teacher(String firstName, String lastName, String section) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.section = section;
    }

    public Teacher() {

    }

    public TeacherAddress getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(TeacherAddress teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public TeacherUniversity getTeacherUniversity() {
        return teacherUniversity;
    }

    public void setTeacherUniversity(TeacherUniversity teacherUniversity) {
        this.teacherUniversity = teacherUniversity;
    }

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

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
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
