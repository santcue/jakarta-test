package cue.edu.co.test.view;

import java.io.*;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value = "/test")

public class Test extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String metodoHttp = request.getMethod(); // Obtiene el método HTTP de la solicitud (GET, POST, etc.).
        String requestUri = request.getRequestURI(); // Obtiene el URI de la solicitud.
        String requestUrl = request.getRequestURL().toString(); // Obtiene la URL de la solicitud como un String.
        String contextPath = request.getContextPath(); // Obtiene el contexto de la aplicación web.
        String servletPath = request.getServletPath(); // Obtiene la ruta del servlet dentro del contexto de la aplicación.
        String ipClient = request.getRemoteAddr(); // Obtiene la dirección IP del cliente que realizó la solicitud.
        String ip = request.getLocalAddr(); // Obtiene la dirección IP del servidor local.
        int port = request.getLocalPort(); // Obtiene el puerto del servidor local.
        String scheme = request.getScheme(); // Obtiene el protocolo de la solicitud (HTTP o HTTPS).
        String host = request.getHeader("host"); // Obtiene el encabezado "Host" de la solicitud.
        String url = scheme + "://" + host + contextPath + servletPath; // Construye la URL completa de la solicitud.
        String url2 = scheme + "://" + ip + ":" + port + contextPath + servletPath; // Construye una URL alternativa con la dirección IP y el puerto del servidor.

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("   <head>");
            out.println("       <meta charset='UTF-8'>");
            out.println("       <title>Cabeceras HTTP Request</title>");
            out.println("   </head>");
            out.println("   <body>");
            out.println("       <h1>Cabeceras HTTP Request</h1>");
            out.println("<ul>");
            out.println("   <li>Método HTTP: " + metodoHttp + "</li>");
            out.println("   <li>Request URI: " + requestUri + "</li>");
            out.println("   <li>Request URL: " + requestUrl + "</li>");
            out.println("   <li>Context Path: " + contextPath + "</li>");
            out.println("   <li>Servlet Path: " + servletPath + "</li>");
            out.println("   <li>IP Cliente: " + ipClient + "</li>");
            out.println("   <li>IP Local: " + ip + "</li>");
            out.println("   <li>Puerto Local: " + port + "</li>");
            out.println("   <li>Scheme: " + scheme + "</li>");
            out.println("   <li>Host: " + host + "</li>");
            out.println("   <li>URL: " + url + "</li>");
            out.println("   <li>URL2: " + url2 + "</li>");

            Enumeration<String> headerNames = request.getHeaderNames();
            while(headerNames.hasMoreElements()) {
                String cabecera = headerNames.nextElement();
                out.println("   <li>" + cabecera + ": " + request.getHeader(cabecera) + "</li>"); // Imprime todos los encabezados de la solicitud.
            }
            out.println("</ul>");
            out.println("   </body>");
            out.println("</html>");

        }

        /*
        Las cabeceras HTTP son parte fundamental de la comunicación entre un cliente y un servidor
        en una aplicacion web. y pueden utilizarse para una amplia variedad de propositos, desde la
        seguridad hasta la optimizacion de rendimiento y personalizar respuestas.
         */

    }

}
