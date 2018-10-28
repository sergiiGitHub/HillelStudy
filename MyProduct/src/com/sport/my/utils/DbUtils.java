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
}
