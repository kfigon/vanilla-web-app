package pl.kamil.servlet;

import pl.kamil.dto.MenuItem;
import pl.kamil.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MenuServlet extends HttpServlet {
    private MenuService menuService = new MenuService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(PrintWriter out = resp.getWriter()) {
            resp.setContentType("text/html");


            out.write(
                    "<html>\n" +
                            "<body>\n" +
                            "    <h1>My restaurant</h1>\n" +
                            "    <h3>Menu</h3>\n" +
                            "    <ul>\n");

            for(MenuItem i : menuService.getMenu()) {
                    out.write("<li>" + i + "</li>\n");
            }

            out.write("</ul>\n" +
                    "</body>\n" +
                    "</html>");
        }
    }
}
