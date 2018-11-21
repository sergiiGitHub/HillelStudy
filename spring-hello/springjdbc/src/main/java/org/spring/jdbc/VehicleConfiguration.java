package org.spring.jdbc;


import com.mysql.jdbc.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;


@Configuration
public class VehicleConfiguration {

    @Bean
    public DataSource simpleDataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost:3306/vehicledb");
        dataSource.setUsername("root");
        dataSource.setPassword("1");
        return dataSource;
    }

}
