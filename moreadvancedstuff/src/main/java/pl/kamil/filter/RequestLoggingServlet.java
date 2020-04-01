package pl.kamil.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebFilter("/*") // all pages
public class RequestLoggingServlet implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String uuid = UUID.randomUUID().toString();
        System.out.println(
                String.format("%s --->  %s, URL: %s",
                        uuid,
                        req.getMethod(),
                        req.getRequestURI())
        );

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println(
                String.format("%s --->  response status: %d",
                        uuid,
                        ((HttpServletResponse)servletResponse).getStatus()));
    }

    @Override
    public void destroy() {

    }
}
