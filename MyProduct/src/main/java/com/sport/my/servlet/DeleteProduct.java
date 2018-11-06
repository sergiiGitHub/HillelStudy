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

@WebServlet(urlPatterns = { "/deleteProduct" })
public class DeleteProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String errorString = null;

        try {
            String code = request.getParameter("code");
            int id = Integer.parseInt(code);
            DbUtils.deleteProduct(request, id);
        } catch (SQLException e) {
            errorString = e.getMessage();
        }

        if (errorString != null) {

            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/deleteProductErrorView.jsp");
            dispatcher.forward(request, response);
        }

        else {
            response.sendRedirect(request.getContextPath() + "/productList");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
