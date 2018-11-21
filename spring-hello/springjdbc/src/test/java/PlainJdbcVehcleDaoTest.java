
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.spring.jdbc.PlainJdbcVehicleDao;
import org.spring.jdbc.Vehicle;
import org.spring.jdbc.VehicleConfiguration;
import org.spring.jdbc.VehicleDao;

import java.util.List;

public class PlainJdbcVehcleDaoTest {

    private VehicleConfiguration configuration = new VehicleConfiguration();
    private VehicleDao vehicleDao;

    @BeforeEach
    public void before() {
        vehicleDao = new PlainJdbcVehicleDao(configuration.simpleDataSource());
    }

    @Test
    public void testInsertIsSuccessful() {

        Vehicle vehicle = new Vehicle("1234", "red", 4, 4);

        vehicleDao.insert(vehicle);

        List<Vehicle> list = vehicleDao.findAll();
        Assertions.assertTrue(list.size() == 2);

    }

}
