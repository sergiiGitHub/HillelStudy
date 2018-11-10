package hibernate;

import hibernate.model.*;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergii on 02.11.18.
 */
public class HibernateStandAlone {

    public static void main(String [] args) {

        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();

        //workWithStudent(session);
        //workWithTeacher(session);
        //studentSubject(session);
        teacherSubject(session);

        session.getTransaction().commit();
        session.close();
    }

    private static void teacherSubject(Session session) {
        Teacher teacher4 = new Teacher("Sam1", "Disilva", "Maths");
        Teacher teacher5 = new Teacher("Joshua1", "Brill", "Maths");
        Subject subject4 = new Subject("Economics2");
        Subject subject5 = new Subject("Politics2");
        Subject subject6 = new Subject("Foreign Affairs2");
        TeacherAddress teacherAddress = new TeacherAddress("Independence Street1", "London", "Englang");
        TeacherUniversity teacherUniversity = new TeacherUniversity("Oxford1", "UK");

        //Teacher4 have 3 subjects
        teacher4.getSubjects().add(subject4);
        teacher4.getSubjects().add(subject5);
        teacher4.getSubjects().add(subject6);
        teacher4.setTeacherAddress(teacherAddress);
        teacher4.setTeacherUniversity(teacherUniversity);

        session.persist(teacherAddress);
        session.persist(teacherUniversity);

        //Teacher5 have 2 subjects
        teacher5.setTeacherAddress(teacherAddress);
        teacher5.getSubjects().add(subject4);
        teacher5.getSubjects().add(subject5);
        teacher5.setTeacherUniversity(teacherUniversity);

        session.persist(teacher4);
        session.persist(teacher5);
    }

    private static void studentSubject(Session session) {
        Student student4 = new Student("Sam1","Disilva", "Maths");
        Student student5 = new Student("Joshua1", "Brill", "Maths");

        Subject subject1 = new Subject("Economics");
        Subject subject2 = new Subject("Politics");
        Subject subject3 = new Subject("Foreign Affairs");

        University university = new University("Oxford1", "UK");
        student4.setUniversity(university);
        student4.getSubjects().add(subject1);
        student4.getSubjects().add(subject2);
        student4.getSubjects().add(subject3);        //Student5 have 2 subjects

        student5.setUniversity(university);        //Student4 have 3 subjects
        student5.getSubjects().add(subject1);
        student5.getSubjects().add(subject2);

        session.persist(university);
        session.persist(student4);
        session.persist(student5);
    }

    private static void workWithTeacher(Session session) {

        Teacher teacher = new Teacher("Tom", "Dissel", "Math");
        Teacher teacher1 = new Teacher("Peter", "Pan", "Sciences");

        TeacherUniversity university = new TeacherUniversity("CAMBRIDGE", "ENGLAND");
        TeacherAddress teacherAddress = new TeacherAddress("Independence Street", "London", "England" );
        List<Teacher> teachers = new ArrayList<Teacher>();
        teacher.setTeacherUniversity(university);
        teacher.setTeacherAddress(teacherAddress);

        teacher1.setTeacherUniversity(university);
        teacher1.setTeacherAddress(teacherAddress);
        teachers.add(teacher);
        teachers.add(teacher1);
        university.setTeachers(teachers);

        session.persist(teacherAddress);
        session.persist(university);
        List<Teacher> teacherList = (List<Teacher>) session.createQuery("from Teacher ").list();
        for (Teacher t : teacherList) {
            System.out.println("Teacher Details : " + t);
            System.out.println("Teacher University Details: "
                    + t.getTeacherUniversity());
        }

        List<Student> students = (List<Student>)session.createQuery("from Student ").list();
        for(Student s: students){
            System.out.println("Details : "+s);
            System.out.println("Student University Details: "+s.getUniversity());
        }
    }

    private static void workWithStudent(Session session) {

        Student student = new Student("Tom", "Dissel", "Math");
        Student student1 = new Student("Peter", "Pan", "Sciences");

        University university = new University("CAMBRIDGE", "ENGLAND");
        student.setUniversity(university);
        student1.setUniversity(university);
        //Address address = new Address("street", "NY", "USA");
        // what does it mean
        session.persist(university);
        session.persist(student);
        session.persist(student1);

        List<Student> students = (List<Student>)session.createQuery("from Student ").list();
        for(Student s: students){
            System.out.println("Details : "+s);
            System.out.println("Student University Details: "+s.getUniversity());
        }
    }

    public static void update(int id, String section) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();

        Student student = (Student) session.get(Student.class, id);
        student.setSection(section);

        session.getTransaction().commit();
    }

    public static void delete(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();

        Student student = (Student) session.get(Student.class, id);
        session.delete(student);
        session.getTransaction().commit();
    }

    public static List<Student> getAllStrudent() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();

        List<Student> studentList = session.createQuery("from Student s ORDER BY s.firstName ASC").list();

        return studentList;
    }

    public static int saveStrudent(String first, String second, String section) {
        Student st = new Student();
        st.setFirstName(first);
        st.setLastName(second);
        st.setSection(section);
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        int id = -1;

        try {
            id = (int) session.save(st);
            session.getTransaction().commit();
        } catch (Throwable ex) {
            session.getTransaction().rollback();
        }

        return id;
    }
}
