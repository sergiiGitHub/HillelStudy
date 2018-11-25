package org.spring.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@SuppressWarnings("all")
public class PlainJdbcVehicleDaoImpl implements VehicleDaoExtended {

    public static final String VEHICLE_NO = "vehicle_no";
    public static final String COLOR = "color";
    public static final String WHEEL = "wheel";
    public static final String SEAT = "seat";

    public static final String TABLE_NAME = "VEHICLE_NEW";

    private static final String INSERT_SQL = "INSERT INTO " + PlainJdbcVehicleDaoImpl.TABLE_NAME + " (" + COLOR +", "+ WHEEL + ", " + SEAT + ", "+ VEHICLE_NO +") VALUES (?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE " + PlainJdbcVehicleDaoImpl.TABLE_NAME + " SET "+ COLOR +"=?,"+ COLOR + "=?," + SEAT + "=? WHERE "+VEHICLE_NO +"=?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM " + PlainJdbcVehicleDaoImpl.TABLE_NAME;
    private static final String SELECT_ONE_SQL = "SELECT * FROM " + PlainJdbcVehicleDaoImpl.TABLE_NAME + " WHERE " + VEHICLE_NO +" = ?";
    private static final String DELETE_SQL = "DELETE FROM " + PlainJdbcVehicleDaoImpl.TABLE_NAME + " WHERE "+ VEHICLE_NO  +"=?";
    private static final String COUNT_ALL_SQL = "SELECT COUNT(*) FROM " + PlainJdbcVehicleDaoImpl.TABLE_NAME;
    private static final String SELECT_COLOR_SQL = "SELECT COLOR FROM " + PlainJdbcVehicleDaoImpl.TABLE_NAME + " WHERE " + VEHICLE_NO + "=?";

    private final JdbcTemplate jdbcTemplate;

    public PlainJdbcVehicleDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Vehicle vehicle) {
        jdbcTemplate.update(INSERT_SQL, vehicle.getColor(), vehicle.getWheel(), vehicle.getSeat(), vehicle.getVehicleNo());
    }

    @Override
    public void insert(Collection<Vehicle> vehicle) {
        jdbcTemplate.batchUpdate(INSERT_SQL, vehicle, vehicle.size(), this::prepareStament);
    }

    @Override
    public Vehicle findByVehicle(String vehicleNo) {
        return jdbcTemplate.queryForObject(SELECT_ONE_SQL, BeanPropertyRowMapper.newInstance(Vehicle.class), vehicleNo);
    }

    @Override
    public List<Vehicle> findAll() {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SELECT_ALL_SQL);

        return rows.stream().map(row-> {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNo((String) row.get(VEHICLE_NO));
            vehicle.setColor((String) row.get(COLOR));
            vehicle.setWheel((Integer) row.get(WHEEL));
            vehicle.setSeat((Integer) row.get(SEAT));
            return vehicle;
        }).collect(Collectors.toList());
    }

    @Override
    public void update(Vehicle vehicle) {
        jdbcTemplate.update(UPDATE_SQL, ps->prepareStament(ps, vehicle));
    }

    @Override
    public void delete(Vehicle vehicle) {
        jdbcTemplate.update(DELETE_SQL, vehicle.getVehicleNo());
    }

    private Vehicle toVehicle(ResultSet rs) throws SQLException {
        return new Vehicle(rs.getString(VEHICLE_NO), rs.getString(COLOR),
                rs.getInt(WHEEL), rs.getInt(SEAT));
    }

    @Override
    public String getColor(String vehicleNo) {
        return jdbcTemplate.queryForObject(SELECT_COLOR_SQL, String.class, vehicleNo);
    }

    @Override
    public int countAll() {
        return jdbcTemplate.queryForObject(COUNT_ALL_SQL, Integer.class);
    }

    private void prepareStament(PreparedStatement ps, Vehicle vehicle) throws SQLException {
        ps.setString(1, vehicle.getColor());
        ps.setInt(2, vehicle.getWheel());
        ps.setInt(3, vehicle.getSeat());
        ps.setString(4, vehicle.getVehicleNo());
    }

}

