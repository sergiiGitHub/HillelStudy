package com.sport.team.utils;

import com.sport.team.entity.Product;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by sergii on 27.10.18.
 */
public class DbUtils {

    public static List<Product> queryProduct(HttpServletRequest req) throws SQLException {
        Connection conn = Utils.getStoredConnection(req);

        return null;
    }
}
