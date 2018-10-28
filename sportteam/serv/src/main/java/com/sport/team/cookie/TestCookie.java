package com.sport.team.cookie;

/**
 * Created by sergii on 26.10.18.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/TestCookie" })
public class TestCookie extends HttpServlet  {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request com.sport.team.servlet request
     * @param response com.sport.team.servlet response
     * @throws ServletException if a com.sport.team.servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {
        response.setContentType("text/com.sport.team.html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE com.sport.team.html>");
            out.println("<com.sport.team.html>");
            out.println("<head>");
            out.println("<title>Servlet TestCookie</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestCookie at " + request.getContextPath() + "</h1>");
            SessionCookieConfig cookies = request.getServletContext().getSessionCookieConfig();
            out.println("Found com.sport.team.cookie: " + cookies.getName());

            Cookie cookie = new Cookie("myCookieKey", "myCookieValue");
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
            out.println("<br><br>Set a new com.sport.team.cookie");

            cookie = new Cookie("myHttpOnlyCookieKey", "myHttpOnlyCookieValue");
            cookie.setHttpOnly(true);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
            out.println("<br>Set a new HTTPOnly Cookie<br><br>");
            out.println("Check what com.sport.team.cookie are visible by");
            out.println("<a href=\"http://"
                    + request.getServerName()
                    + ":"
                    + request.getServerPort()
                    + request.getContextPath()
                    + "/index-com.sport.team.cookie.jsp\">clicking here</a>");

            out.println("</body>");
            out.println("</com.sport.team.html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request com.sport.team.servlet request
     * @param response com.sport.team.servlet response
     * @throws ServletException if a com.sport.team.servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request com.sport.team.servlet request
     * @param response com.sport.team.servlet response
     * @throws ServletException if a com.sport.team.servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the com.sport.team.servlet.
     *
     * @return a String containing com.sport.team.servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
