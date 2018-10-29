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

/**
 * Created by sergii on 28.10.18.
 */
@WebServlet(urlPatterns = { "/updateProduct" })
public class UpdateProduct extends HttpServlet {
    private final String regex = "\\w+";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String code =  request.getParameter("code");
        //System.out.println("UpdateProduct:code:" + code);
        String name =  request.getParameter("name");
        String priceStr = request.getParameter("price");
        float price = 0;
        int intCode = Product.UNDEFINED;
        try {
            intCode = Integer.parseInt(code);
            price = Float.parseFloat(priceStr);
        } catch (Exception e) {}
        Product product = new Product(intCode, name, price);
        String errorString = null;
        if (!name.matches(regex)) {
            errorString = "name invalid!";
        }
        if (errorString == null) {
            try {
                 DbUtils.updateProduct(request, product);
            } catch (SQLException e) {
                errorString = e.getMessage();
            }
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("product", product);

        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsp/createProductView.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/productList");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
