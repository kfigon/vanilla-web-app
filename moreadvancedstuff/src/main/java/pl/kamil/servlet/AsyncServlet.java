package pl.kamil.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//in general - dont use

//constant connection
//(actually bunch of new connections)
//to receive constant data, it's self refreshing

//self updating page,
//no delay between server response and sending that to front

//it can be dangerous, threadPool is limited
//also need to enable async in filter
@WebServlet(value = "/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AsyncContext context = req.startAsync();
        context.start(() -> {
            int i = 0;
            while(i<10) {
                try (PrintWriter out = resp.getWriter()) {
                    out.write(i);
                    i++;
                    Thread.sleep(500);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
