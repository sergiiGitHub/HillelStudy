package com.sport.my.utils;


import com.sport.my.entity.Product;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergii on 27.10.18.
 */
public class DbUtils {
    private static final String PRODUCT_COLUMN_ID = "id";
    private static final String TABLE_NAME = "product_tbl_temp";

    public static List<Product> queryProduct(HttpServletRequest req) throws SQLException {
        Connection conn = Utils.getStoredConnection(req);
        if (conn == null) {
            return null;
        }
        String sql = "SELECT a." + PRODUCT_COLUMN_ID + " , a.product_name, a.product_price FROM " + TABLE_NAME + " a";

        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        List<Product> result = new ArrayList<Product>();
        while(rs.next()) {
            int code = rs.getInt(PRODUCT_COLUMN_ID);
            String name = rs.getString("product_name");
            float price = rs.getFloat("product_price");

            Product product = new Product(code, name, price);

            result.add(product);
        }
        return result;
    }

    public static void insertProduct(HttpServletRequest request, Product product) throws SQLException {
        Connection conn = Utils.getStoredConnection(request);
        if (conn == null) {
            return;
        }

        String sql = "insert into " + TABLE_NAME + " (product_name, product_price) values(?,?)";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, product.getName());
        pstm.setFloat(2, product.getPrice());
        int id = pstm.executeUpdate();
        if (id == Product.UNDEFINED) {
            // TODO: 28.10.18 throw error
            throw new SQLException();
        } else {
            product.setCode(id);
        }
    }

    public static Product getProductBy(HttpServletRequest request, int id) {
        Connection conn = Utils.getStoredConnection(request);
        String sql = "select product_name, product_price from " + TABLE_NAME + " where " + PRODUCT_COLUMN_ID +"=?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                String name = rs.getString("product_name");
                float price = rs.getFloat("product_price");
                return new Product(id, name, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateProduct(HttpServletRequest request, Product product) throws SQLException {
        Connection conn = Utils.getStoredConnection(request);
        String sql = "update " + TABLE_NAME + " set product_name=?, product_price =? where " + PRODUCT_COLUMN_ID + "=?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, product.getName());
        pstm.setFloat(2, product.getPrice());
        pstm.setFloat(3, product.getCode());

        pstm.executeUpdate();
    }

    public static void deleteProduct(HttpServletRequest request, int id) throws SQLException {
        Connection conn = Utils.getStoredConnection(request);
        String sql = "delete from " + TABLE_NAME + " where " + PRODUCT_COLUMN_ID + "=?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);

        pstm.executeUpdate();
    }
}
