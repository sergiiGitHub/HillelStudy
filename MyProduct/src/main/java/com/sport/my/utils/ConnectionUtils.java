package com.sport.my.utils;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by sergii on 27.10.18.
 */
public class ConnectionUtils {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/userdb");
        dataSource.setUser("root");
        dataSource.setPassword("1");

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dataSource.getUrl(), dataSource.getUser(), "1");
        conn.setAutoCommit(true);
        return conn;
    }

    public static void rollbackQuietly(Connection conn) {
        try {
            conn.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeQuietly(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
