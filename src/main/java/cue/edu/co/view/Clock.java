package cue.edu.co.view;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet({"/clock"})
public class Clock extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setHeader("refresh","1"); //Set an HTTP header to refresh the page every second.
        LocalTime hora = LocalTime.now(); //Gets the current time.
        DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mm:ss"); //Time formatter to display time in 12-hour format.
        try(PrintWriter out = resp.getWriter()) { // Write the HTML response.
            // Start of the HTML document.
            out.println("<!DOCTYPEhtml>");
            out.println("<html>");
            out.println(" <head>");
            out.println(" <metacharset=\"UTF-8\">");
            out.println(" <title>The updated time</title>");
            out.println(" </head>");
            out.println(" <body>");
            out.println(" <h1>The updated time!</h1>");
            out.println("<h3>"+hora.format(df)+"</h3>");
            out.println(" </body>");
            out.println("</html>");
        }
    }

    /*
    The Clock servlet uses the Jakarta Servlet API to display the current
    time in a browser and automatically update it every second. When the
    /clock path is accessed, the servlet generates an HTML page that displays
    the time in 12-hour format. To achieve automatic refreshing, the servlet
    configures the HTTP response so that the page is refreshed every second
    using the refresh header. Thus, every time the page is reloaded, the servlet
    recalculates the current time and displays it, keeping the clock updated.
     */

}
