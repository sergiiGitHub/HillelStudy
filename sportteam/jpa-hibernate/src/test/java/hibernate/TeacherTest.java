package hibernate;

import hibernate.model.Teacher;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by sergii on 02.11.18.
 */
public class TeacherTest {

    @Ignore
    @Test
    public void testSaveTeacher() throws Exception {
        Teacher teacher = new Teacher();
        teacher.setFirstName("mar");
        teacher.setLastName("myr");
        teacher.setSection("ART");

        int id = TeacherUtils.save(teacher);
        Assert.assertNotEquals(id, -1);

        Teacher teacherFromDb = TeacherUtils.get(id);
        Assert.assertEquals(teacherFromDb, teacher);
    }

    @Ignore
    @Test
    public void testDeleteTeacher() throws Exception {
        Teacher teacher = new Teacher();
        teacher.setFirstName("del");
        teacher.setLastName("del");
        teacher.setSection("ART");

        int id = TeacherUtils.save(teacher);
        Assert.assertNotEquals(id, -1);

        Teacher deleteTeacher = TeacherUtils.delete(id);
        Assert.assertEquals(deleteTeacher, teacher);
    }

    @Ignore
    @Test
    public void testUpdateTeacher() throws Exception {
        Teacher teacher = new Teacher();
        teacher.setFirstName("update");
        teacher.setLastName("update");
        teacher.setSection("ART");

        int id = TeacherUtils.save(teacher);
        Assert.assertNotEquals(id, -1);

        teacher.setSection("MUSIC");
        TeacherUtils.update(id, teacher);
        Teacher updateTeacher = TeacherUtils.get(id);
        Assert.assertEquals(updateTeacher, teacher);
    }


}
