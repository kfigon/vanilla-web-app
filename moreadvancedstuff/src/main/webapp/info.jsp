<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="pl.kamil.dto.MenuItem" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Menu! This is from MVC!</h1>
    <ul>
        <%
            List<MenuItem> items = (List<MenuItem>) request.getAttribute("myData");
            for(MenuItem item : items) {
                out.print("<li>"+item+"</li>");
            }
        %>
    </ul>
</body>
</html>
