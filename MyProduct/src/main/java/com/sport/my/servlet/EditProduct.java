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

@WebServlet(urlPatterns = { "/editProduct" })
public class EditProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Product product = null;
        try {
            String code = request.getParameter("code");
            int id = Integer.parseInt(code);
            product = DbUtils.getProductBy(request, id);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorString", e.toString());
            response.sendRedirect(request.getContextPath() + "/productList");
        }

        request.setAttribute("product", product);
        request.setAttribute("edit", new Object());

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/updateProductView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
