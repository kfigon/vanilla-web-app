package pl.kamil.servlet;

import pl.kamil.dto.MenuItem;
import pl.kamil.service.MenuService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class SearchResultServlet extends HttpServlet {
    private MenuService menuService = new MenuService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try(PrintWriter out = resp.getWriter()) {
            resp.setContentType("text/html");


            out.write(
                    "<html>\n" +
                            "<body>\n" +
                            "    <h1>My restaurant</h1>\n");

            String queryString = req.getParameter("searchTerm");
            if(queryString == null || queryString.length() == 0) {
                out.write("<h2>invalid query, please try again!</h2>");
            } else {
                List<MenuItem> collect = menuService.getMenu()
                        .stream()
                        .filter(menuItem -> menuItem.getName().toLowerCase().equals(queryString.toLowerCase()))
                        .collect(Collectors.toList());

                if (collect.isEmpty()) {
                    out.write("<h3>No element " + queryString + " present</h3>");
                } else {
                    String results = collect.stream()
                            .map(MenuItem::getName)
                            .collect(Collectors.joining(", "));

                    out.write("<h3>found : " + results + "</h3>");
                }
            }

            out.write("<a href='/'>go back</a>");
            out.write(
                    "</body>\n" +
                    "</html>");
        }
    }
}
