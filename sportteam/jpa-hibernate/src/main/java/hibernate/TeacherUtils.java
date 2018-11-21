package hibernate;

import hibernate.model.Teacher;
import org.hibernate.Session;

/**
 * Created by sergii on 02.11.18.
 */
public class TeacherUtils {

    public static int save(Teacher teacher) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        int id = -1;

        try {
            id = (int) session.save(teacher);
            session.getTransaction().commit();
        } catch (Throwable ex) {
            session.getTransaction().rollback();
        }

        return id;
    }

    public static Teacher get(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();

        return (Teacher) session.get(Teacher.class, id);
    }

    public static Teacher delete(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();

        Teacher deleteItem = (Teacher) session.get(Teacher.class, id);
        session.delete(deleteItem);
        session.getTransaction().commit();
        return deleteItem;
    }

    public static void update(int id, Teacher teacher) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();

        Teacher teacherDb = (Teacher) session.get(Teacher.class, id);
        teacherDb.setFirstName(teacher.getFirstName());
        teacherDb.setLastName(teacher.getLastName());
        teacherDb.setSection(teacher.getSection());

        session.getTransaction().commit();
        session.close();
    }
}
