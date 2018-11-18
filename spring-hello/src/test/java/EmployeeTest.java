import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.hello.spring.configuration.AppConfig;
import org.spring.hello.spring.test.empl.Accounter;
import org.spring.hello.spring.test.empl.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by sergii on 16.11.18.
 */

@ContextConfiguration(classes = {Accounter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeTest {

    @Autowired
    @Qualifier("accounter")
    Employee employee1;

    @Test
    public void testEmployee() {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(employee1);

        for (Employee e : employeeList) {
            e.showPayrate();
        }

    }



}
