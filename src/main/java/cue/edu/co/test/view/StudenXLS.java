package cue.edu.co.test.view;

import cue.edu.co.test.mapping.DTO.StudentDTo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/test", "/students.html", "/students"})
public class StudenXLS {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        List<StudentDTo> students = service.listar();
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
                out.println("       <td>" + p.getId() + "</td>");
                out.println("       <td>" + p.getName() + "</td>");
                out.println("       <td>" + p.getType() + "</td>");
                out.println("       <td>" + p.getPrice() + "</td>");
                out.println("   </tr>");
            });

            out.println("</table>");

            if(!esXLS) {
                out.println("   </body>");
                out.println("</html>");
            }

        }

        }

}
