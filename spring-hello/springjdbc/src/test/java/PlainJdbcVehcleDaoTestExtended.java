
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.spring.jdbc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {VehicleConfiguration.class})
@Sql(statements = {
        "CREATE TABLE " + PlainJdbcVehicleDaoImpl.TABLE_NAME + "(\n" +
                "VEHICLE_ID SERIAL PRIMARY KEY,\n" +
                PlainJdbcVehicleDaoImpl.VEHICLE_NO + " varchar(255), \n" +
                PlainJdbcVehicleDaoImpl.COLOR + " varchar(255), \n" +
                PlainJdbcVehicleDaoImpl.WHEEL + " INTEGER, \n" +
                PlainJdbcVehicleDaoImpl.SEAT + " INTEGER \n" +
                ");"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(statements = {"DROP TABLE " + PlainJdbcVehicleDaoImpl.TABLE_NAME}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class PlainJdbcVehcleDaoTestExtended {

    @Autowired
    private PlainJdbcVehicleDaoImpl jdbcVehicleDao;

    @Test
    public void testInsertIsSuccessful() {
        Vehicle vehicle = new Vehicle("1234", "red", 4, 4);
        jdbcVehicleDao.insert(vehicle);
        int all = jdbcVehicleDao.countAll();
        System.out.println(all);
    }

}
