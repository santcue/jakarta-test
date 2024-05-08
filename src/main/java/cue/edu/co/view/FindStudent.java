package cue.edu.co.view;

import com.fasterxml.jackson.annotation.JacksonInject;
import cue.edu.co.model.Student;
import cue.edu.co.service.impl.RepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/findStudent")
public class FindStudent extends HttpServlet {

    private static RepositoryImpl service;

    public void init() throws ServletException {
        service = new RepositoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam == null || idParam.trim().isEmpty()) {
            req.getRequestDispatcher("/findStudent.jsp").forward(req, resp);
            return;
        }

        try {
            int id = Integer.parseInt(idParam);
            Optional<Student> student = service.byId(id);
            if (!student.isPresent()) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Student not found");
            } else {
                resp.setContentType("application/json");
                resp.getWriter().write(student.get().toString());
            }
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid student ID format");
        }
    }



}
