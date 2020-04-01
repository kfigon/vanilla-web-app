<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="pl.kamil.service.MenuService" %>
<%@page import="pl.kamil.dto.MenuItem" %>
<%@page import="java.util.List" %>
<%@ page import="java.awt.*" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Menu!</h1>
    <ul>
        <%
            MenuService menuService = new MenuService();
            for(MenuItem item : menuService.getMenu()) {
                out.print("<li>"+item+"</li>");
            }
        %>
    </ul>
    <hr>
    <h1>the same with expression</h1>
    <ul>
        <%
        for(MenuItem item : menuService.getMenu()) {
        %>
            <li><%=item%></li>
        <%
        }
        %>
    </ul>
</body>
</html>
