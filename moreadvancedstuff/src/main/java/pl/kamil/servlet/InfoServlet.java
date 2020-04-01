package pl.kamil.servlet;

import pl.kamil.dto.MenuItem;
import pl.kamil.service.MenuService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/getInfo")
public class InfoServlet extends HttpServlet {

//    MVC - przekazywanie danych do jsp z servletu

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MenuService menuService = new MenuService();
        req.setAttribute("myData", menuService.getMenu());

//        standardowy boilerplate
        ServletContext context = getServletContext();
        RequestDispatcher requestDispatcher = context.getRequestDispatcher("/info.jsp");
//        jsp tworzy servlet dynamicznie w runtime, wiec przekierowujemy do tego servletu
        requestDispatcher.forward(req, resp);
    }
}
