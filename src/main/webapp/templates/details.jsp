<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.codeforall.online.javabank-step02-carolina.model.Customer"%>

<% Customer customer = (Customer) request.getAttribute("customer"); %>

<html>
    <head>
        <title>Bank App</title>
    </head>

    <body>
        <h6><%= customer.getFirstName()</h6>
        <h6><%= customer.getLastPhone()</h6>
        <h6><%= customer.getPhone()</h6>
        <h6><%= customer.getEmail()</h6>
    </body>

</html>