package pl.kamil.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SecuredServlet extends HttpServlet {
//    curl --user "admin:admin" localhost:8080/secured
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            try(PrintWriter out = resp.getWriter()) {
                out.write("This is secret place!");
            }
    }
}
