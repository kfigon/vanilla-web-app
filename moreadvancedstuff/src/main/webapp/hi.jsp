<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--//tak jak index.html jest defaultowym rootem,
index.jsp tez moze byc--%>
<%--mozna te zalaczac sub jsp--%>

<%--jsp powoduje tworzenie servletu w runtime przez api--%>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Hi there!</h1>
    <ul>
        <%
            for(int i =0; i<10; i++) {
                out.write("<li>"+i+"</li>");
            }
        %>
    </ul>
</body>
</html>
