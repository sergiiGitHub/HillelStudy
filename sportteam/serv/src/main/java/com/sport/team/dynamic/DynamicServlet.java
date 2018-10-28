package com.sport.team.dynamic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sergii on 23.10.18.
 */
public class DynamicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("com.sport.team.dynamic Get");
    }

    @Override
    public String getServletInfo() {
        return "My dynamic awesome com.sport.team.servlet!";
    }
}
