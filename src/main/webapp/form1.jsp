<%--
  Created by IntelliJ IDEA.
  User: koszkuld
  Date: 20/04/2022
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="/newPerson" method="post" modelAttribute="person">
    <label for="login">Login</label>
    <form:input id="login" type="text" path="login"/><br/>

    <label for="password">Password</label>
    <form:input id="password" type="password" path="password"/><br/>

    <label for="email">E-mail</label>
    <form:input id="email" type="email" path="email"/><br/>

    <c:forEach items="${exampleList}" var="lang">
        ${lang}<br>
    </c:forEach>

    <input type="submit"/>
</form:form>

</body>
</html>
