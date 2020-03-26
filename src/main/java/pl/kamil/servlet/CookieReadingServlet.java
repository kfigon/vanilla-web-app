package pl.kamil.servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class CookieReadingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try (PrintWriter out = resp.getWriter()) {
            resp.setContentType("text/html");
            out.println("<html><body>" +
                    "<h1>Your last stored cookie: " + findMyCookie(req) +
                    "</h1>" +
                    "</body></html>");
        }
    }

    private String findMyCookie(HttpServletRequest req) {
        return Arrays.stream(req.getCookies())
                .filter(cookie -> "your-last-text".equals(cookie.getName()))
                .map(Cookie::getValue)
                .findFirst().orElse("THERE'S NO COOKIE!");
    }
}
