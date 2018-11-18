import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.hello.spring.test.Company;
import org.spring.hello.spring.test.empl.Accounter;
import org.spring.hello.spring.test.empl.Employee;
import org.spring.hello.spring.test.empl.Engineer;
import org.spring.hello.spring.test.empl.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by sergii on 16.11.18.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Accounter.class, Manager.class, Engineer.class, Company.class})
@EnableAutoConfiguration
public class CompanyTest {

    @Autowired
    @Qualifier("company")
    Company company;

    @Test
    public void testEmployee() {
        company.show();
    }
}
