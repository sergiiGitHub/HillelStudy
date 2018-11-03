package hibernate;

import hibernate.model.Student;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by sergii on 02.11.18.
 */
public class HibernateStandAlone {

    public static void main(String [] args) {
        int studentId1 = saveStrudent("Tom", "Dissel", "d");
        System.out.println("end");

        System.out.println(getAllStrudent());

        update(9, "ART");
        delete(studentId1);
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
