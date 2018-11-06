package com.sport.my.utils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;

/**
 * Created by sergii on 27.10.18.
 */
public class Utils {

    private static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";

    public static Connection getStoredConnection(HttpServletRequest req) {
        return (Connection)req.getAttribute(ATT_NAME_CONNECTION);
    }

    public static void storeConnection(ServletRequest request, Connection conn) {
        request.setAttribute(ATT_NAME_CONNECTION, conn);
    }
}
