package org.spring.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("all")
public class PlainJdbcVehicleDao implements VehicleDao {
    private static final String INSERT_SQL = "INSERT INTO Vehicle (color, wheel, seat, vehicle_no) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE Vehicle SET color=?,wheel=?,seat=? WHERE vehicle_no=?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM Vehicle";
    private static final String SELECT_ONE_SQL = "SELECT * FROM Vehicle WHERE vehicle_no = ?";
    private static final String DELETE_SQL = "DELETE FROM Vehicle WHERE vehicle_no=?";

    private final DataSource dataSource;

    public PlainJdbcVehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Vehicle vehicle) {
        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(INSERT_SQL);
            prepareStament(ps, vehicle);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void update(Vehicle vehicle) {
        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(UPDATE_SQL);
            prepareStament(ps, vehicle);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(Vehicle vehicle) {
        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(DELETE_SQL);
            ps.setString(1, vehicle.getVehicleNo());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Vehicle findByVehicle(String vehicleNo) {
        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SELECT_ONE_SQL);
            ps.setString(1, vehicleNo);
            Vehicle vehicle = null;
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    vehicle = toVehicle(rs);
                }
            }
            return vehicle;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    private Vehicle toVehicle(ResultSet rs) throws SQLException {
        return new Vehicle(rs.getString("vehicle_no"), rs.getString("color"),
                rs.getInt("wheel"), rs.getInt("seat"));
    }

    private void prepareStament(PreparedStatement ps, Vehicle vehicle) throws SQLException {
        ps.setString(1, vehicle.getColor());
        ps.setInt(2, vehicle.getWheel());
        ps.setInt(3, vehicle.getSeat());
        ps.setString(4, vehicle.getVehicleNo());
    }

    @Override
    public List<Vehicle> findAll() {
        List<Vehicle> vehicles = null;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = ps.executeQuery()) {

            vehicles = new ArrayList<>();
            while (rs.next()) {
                vehicles.add(toVehicle(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
}

