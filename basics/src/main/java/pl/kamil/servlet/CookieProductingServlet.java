package pl.kamil.servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CookieProductingServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//this will result in response header
//Set-Cookie: your-last-text=asd
//        so browser will save that and keep sending to server in each request
        resp.addCookie(new Cookie("your-last-text", req.getParameter("someValue")));

//        Cookie[] cookies = req.getCookies();
        try (PrintWriter out = resp.getWriter()) {
            resp.setContentType("text/html");
            out.println("<html><body>" +
                    "<h1>I stored your data in a cookie</h1>" +
                    "</body></html>");
        }
    }
}
