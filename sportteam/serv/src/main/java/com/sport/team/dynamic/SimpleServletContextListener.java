package com.sport.team.dynamic;

import com.sport.team.servlet.ProductList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

/**
 * Created by sergii on 23.10.18.
 */
@WebListener
public class SimpleServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Servlet context initialized " + servletContextEvent.getServletContext().getContextPath());
        ServletRegistration.Dynamic registration = servletContextEvent.getServletContext().addServlet("com/sport/team/dynamic", DynamicServlet.class);
        registration.addMapping("/dynamic");

        //
        registration = servletContextEvent.getServletContext().addServlet("com/sport/team/servlet", ProductList.class);
        registration.addMapping("/productList");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("com.sport.team.servlet context destroyer: " + servletContextEvent.getServletContext().getContextPath());
    }
}
