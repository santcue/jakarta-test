package cue.edu.co.view;

import cue.edu.co.mapping.DTO.StudentDTo;
import cue.edu.co.model.Student;
import cue.edu.co.service.Service;
import cue.edu.co.service.impl.RepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

@WebServlet({"/students", "/students.html", "/students.xls"})
public class StudentsXLS extends HttpServlet {

    private RepositoryImpl service;

    public void init() throws ServletException {
        service = new RepositoryImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn = (Connection) request.getAttribute("conn");
        Service service = new RepositoryImpl(conn);

        List<Student> students = service.listStudent();
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
            out.println("       <th>Semester</th>");
            out.println("   </tr>");

            students.forEach(p -> {
                out.println("   <tr>");
                out.println("       <td>" + p.getId() + "</td>");
                out.println("       <td>" + p.getName()+ "</td>");
                out.println("       <td>" + p.getEmail() + "</td>");
                out.println("       <td>" + p.getSemester() + "</td>");
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
