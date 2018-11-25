package org.spring.jdbc;

public interface VehicleDaoExtended extends VehicleDao {

    String getColor(String vehicleNo);

    int countAll();

}
