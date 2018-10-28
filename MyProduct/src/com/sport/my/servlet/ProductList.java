package com.sport.my.servlet;


import com.sport.my.entity.Product;
import com.sport.my.utils.DbUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by sergii on 27.10.18.
 */
@WebServlet(urlPatterns = { "/productList" })
public class ProductList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String errorString = null;
        List<Product> list = null;
        try {
            list = DbUtils.queryProduct(request);
        } catch (SQLException e) {
            errorString = e.getMessage();
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("productList", list);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/productListView.jsp");
        dispatcher.forward(request, response);
    }
}
