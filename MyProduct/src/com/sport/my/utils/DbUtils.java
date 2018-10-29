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

    public static List<Product> queryProduct(HttpServletRequest req) throws SQLException {
        Connection conn = Utils.getStoredConnection(req);
        if (conn == null) {
            return null;
        }
        //product_id | product_name | product_price
        String sql = "SELECT a.product_id, a.product_name, a.product_price FROM product_tbl a";

        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        List<Product> result = new ArrayList<>();
        while(rs.next()) {
            int code = rs.getInt("product_id");
            String name = rs.getString("product_name");
            float price = rs.getFloat("product_price");

            Product product = new Product(code, name, price);
//            product.setCode(code);
//            product.setName(name);
//            product.setPrice(price);

            result.add(product);
        }
        return result;
    }

    public static void insertProduct(HttpServletRequest request, Product product) throws SQLException {
        Connection conn = Utils.getStoredConnection(request);
        if (conn == null) {
            return;
        }

        String sql = "insert into product_tbl (product_name, product_price) values(?,?)";
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
        String sql = "select product_name, product_price from product_tbl where product_id=?";

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

        //String sql = "select a.Code, a.Name, a.Price from PRODUCT a where a.Code =?";

//        PreparedStatement pstm = conn.prepareStatement(sql);
//        pstm.setString(1, code);


    }

    public static void updateProduct(HttpServletRequest request, Product product) throws SQLException {
        Connection conn = Utils.getStoredConnection(request);
        String sql = "update product_tbl set product_name=?, product_price =? where product_id=?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, product.getName());
        pstm.setFloat(2, product.getPrice());
        pstm.setFloat(3, product.getCode());

        pstm.executeUpdate();

    }

    public static void deleteProduct(HttpServletRequest request, int id) throws SQLException {
        Connection conn = Utils.getStoredConnection(request);
        String sql = "delete from product_tbl where product_id=?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);

        pstm.executeUpdate();
    }
}
