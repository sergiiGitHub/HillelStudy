package com.sport.team.html;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sergii on 26.10.18.
 */
@WebServlet (urlPatterns = {"/com.sport.team.html-com.sport.team.servlet", "/com.sport.team.servlet-com.sport.team.html"})
public class HtmlServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String l = req.getParameter("login");
        String p = req.getParameter("password");

        User user = new User(l, p);

        req.setAttribute("user", user);
        req.getServletContext().getRequestDispatcher("/WEB-INF/jsp/login-com.sport.team.html.jsp").forward(req, resp);
    }

//    String login = req.getParameter("login");
//
//    String password = req.getParameter("password");
//
//    User user = new User(login, password);
//
//        req.setAttribute("user", user);
//
//        req.getServletContext().getRequestDispatcher("/WEB-INF/jsp/login-com.sport.team.html.jsp").forward(req, resp);
}
