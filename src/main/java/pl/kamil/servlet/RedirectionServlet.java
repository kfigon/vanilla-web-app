package pl.kamil.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectionServlet extends HttpServlet {

//    classic design pattern - POST - REDIRECT - GET
//    so user won't do double post with refreshing the page
//    after receiving post, we redirect to different site

    //    GET /somePost.html
//    POST - /receivePost
//    REDIRECT /hello.html
//    get /hello.html
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        redirect  get
        resp.sendRedirect("/hello.html");
    }
}
