package cue.edu.co.listeners;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpSessionListener;

public class WebListener implements ServletContextListener, ServletRequestListener, HttpSessionListener {

    private ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("Aplicación iniciada");
        servletContext = sce.getServletContext();
        servletContext.setAttribute("mensaje", "Hola a todos");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        servletContext.log("Petición iniciada");
        sre.getServletRequest().setAttribute("mensaje", "Guardando algun valor para el request");
    }

}
