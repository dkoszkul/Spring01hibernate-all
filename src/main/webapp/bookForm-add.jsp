<%--
  Created by IntelliJ IDEA.
  User: koszkuld
  Date: 21/04/2022
  Time: 18:57
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

<form:form action="/bookForm/add" method="post" modelAttribute="book">
    <label for="title">Title</label>
    <form:input id="title" type="text" path="title"/><br/>

    <label for="rating">Rating</label>
    <form:input id="rating" type="number" path="rating"/><br/>

    <label for="description">Description</label>
    <form:input id="description" type="text" path="description"/><br/>

    <form:select itemValue="id" itemLabel="name"
                 path="publisher.id" items="${publishers}"/>

    <input type="submit"/>
</form:form>

</body>
</html>
