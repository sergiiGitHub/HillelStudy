package org.spring.jdbc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

public class Main {

    public static void main(String []args) throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class, DaoConfig.class);

        //PLAIN JDBC
        VehicleDao vehicleDao = (VehicleDao) context.getBean("vehicleDao");

        String num = "TEM001";
        Vehicle vehicle = new Vehicle(num, "Red", 4, 4);

        vehicleDao.insert(vehicle);

        vehicle = vehicleDao.findByVehicle(num);
        System.out.println(vehicle);

    }

    @Configuration
    @Import(VehicleConfiguration.class)
    public class DaoConfig {
        @Bean
        public VehicleDao vehicleDao(DataSource dataSource) {
            return new PlainJdbcVehicleDao(dataSource);
        }
    }

}
