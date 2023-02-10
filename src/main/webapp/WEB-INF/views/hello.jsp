<%--
  Created by IntelliJ IDEA.
  User: PRO
  Date: 1/21/2023
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>HELLOOOO SPRING</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Age</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="p" begin="0" end="5" varStatus="stat">
            <tr>
                <td>${stat.current}</td>
                <td><c:out value="${p}"/></td>
                <td>${p}</td>
                <td>${p}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
