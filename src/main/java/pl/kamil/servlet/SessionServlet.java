package pl.kamil.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class SessionServlet extends HttpServlet {
    private static final String TIMES = "times";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        it will add unique ID in cookies to user and store it in requests
//        to access session data in the backend.
//        in cookie it will be some random id and key JSESSIONID

//        can be anything here, even objects
//        easier API than regular cookies

        HttpSession session = req.getSession();

        Integer timesEntered = Optional.ofNullable(session.getAttribute(TIMES))
                .map(Integer.class::cast)
                .orElse(0);

        timesEntered+=1;

        session.setAttribute(TIMES, timesEntered);
        try(PrintWriter out = resp.getWriter()) {
            out.write(String.format("you entered this page: %d times!", timesEntered));
        }
    }
}
