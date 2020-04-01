package pl.kamil.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet(value = {"", "/hello.html"}) // no need for xml mappings! Newer servlet api
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (PrintWriter out = resp.getWriter()) {
            resp.setContentType("text/html");
            out.println("<html><body>" +
                    "<h1>Hello!</h1>" +
                    "<p> It's " + LocalDateTime.now().toString() +
                    "</p>" +
                    "</body></html>");
        }
    }
}
