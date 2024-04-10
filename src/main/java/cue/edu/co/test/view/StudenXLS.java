package cue.edu.co.test.view;

import cue.edu.co.test.mapping.DTO.StudentDTo;
import cue.edu.co.test.service.impl.RepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/students", "/students.html"})
public class StudenXLS extends HttpServlet {

    private static RepositoryImpl service;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        List<StudentDTo> students = service.listStudent();
        response.setContentType("text/html; charset=UTF-8");
        String servletPath = request.getServletPath();
        boolean esXlS = servletPath.endsWith(".xls");
        if (esXlS) {
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=students.xls");
        }
        try (PrintWriter out = response.getWriter()) {

            if (!esXlS) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("   <head>");
                out.println("       <meta charset='UTF-8'>");
                out.println("       <title>Students</title>");
                out.println("   </head>");
                out.println("   <body>");
                out.println("       <h1>Students</h1>");
                out.println("<p><a href=\"" + request.getContextPath() + "/students.xls\">Exportar a XLS</a></p>");
            }

            out.println("<table>");
            out.println("   <tr>");
            out.println("       <th>Id</th>");
            out.println("       <th>Name</th>");
            out.println("       <th>Type</th>");
            out.println("       <th>Price</th>");
            out.println("   </tr>");

            students.forEach(p -> {
                out.println("   <tr>");
                out.println("       <td>" + p.id() + "</td>");
                out.println("       <td>" + p.name() + "</td>");
                out.println("       <td>" + p.email() + "</td>");
                out.println("       <td>" + p.semester() + "</td>");
                out.println("   </tr>");
            });

            out.println("</table>");

            if(!esXlS) {
                out.println("   </body>");
                out.println("</html>");
            }

        }

        }

}
