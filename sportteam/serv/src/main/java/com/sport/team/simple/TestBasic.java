package com.sport.team.simple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sergii on 23.10.18.
 */
@WebServlet(urlPatterns = "/TestBasic")
public class TestBasic extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/com.sport.team.html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE com.sport.team.html>");
            out.println("<com.sport.team.html>");
            out.println("<head>");
            out.println("<title>Web Fragment with output from Servlet Filter</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Web Fragment with output from Servlet Filter</h1>");
            out.println("<br><br>Check server log for output from LoggingFilter");
            out.println("</body>");
            out.println("</com.sport.team.html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
