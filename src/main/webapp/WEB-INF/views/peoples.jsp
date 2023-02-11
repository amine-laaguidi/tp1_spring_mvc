
<%--
  Created by IntelliJ IDEA.
  User: PRO
  Date: 2/9/2023
  Time: 12:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns:th="https://www.thymeleaf.org">
<head>
    <title>Peoples</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <style>
        body{
            display: flex;
        }
        .tab,.inpts{
            width:50%;
            margin: 20px;
            padding: 10px;
        }

    </style>
</head>
<body>
    <div class="tab">
        <c:if test="${delName != null}">
            <div style="margin: 5px" class="p-2 text-success-emphasis bg-success-subtle border border-success-subtle rounded-3">
                ${delName} deleted successfully
            </div>
        </c:if>
        <c:if test="${err == 2}">
            <div style="margin: 5px" class="p-2 text-danger-emphasis bg-danger-subtle border border-danger-subtle rounded-3">
                    User can't be deleted
            </div>
        </c:if>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="p" items="${peoples}" varStatus="stat">
                <tr>
                    <td>${stat.count}</td>
                    <td><c:out value="${p.name}"/></td>
                    <td>${p.age}</td>
                    <td>${p.email}</td>
                    <td>
                        <a class="btn btn-danger" href="${pageContext.request.contextPath }/peoples/delete/${p.id}" onclick="return confirm('Are you sure?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
    <div class="inpts">
        <c:if test="${person != null}">
        <c:set var="name" value="${person.name}"/>
        <c:set var="age" value="${person.age}"/>
        <c:set var="email" value="${person.email}"/>
        </c:if>
        <form action="#"  th:action="@{/peoples}" method="post">
            <div class="mb-3">
                <label for="name" class="form-label" >Name</label>
                <input type="text" name="name" id="name" th:field="*{name}" value="${name}" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" name="email" id="email" th:field="*{email}" value="${email}" class="form-control" required>
                <c:if test="${err == 1}">
                    <div style="margin: 5px"  class="p-2 text-danger-emphasis bg-danger-subtle border border-danger-subtle rounded-3">
                        Please enter a Gmail account
                    </div>
                </c:if>
            </div>
            <div class="mb-3">
                <label for="age" class="form-label">Age</label>
                <input type="number" name="age" th:field="*{age}" id="age" value="${age}" class="form-control" required>
            </div>
                <input type="submit" value="ADD" class="btn btn-primary">
        </form>

    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>
