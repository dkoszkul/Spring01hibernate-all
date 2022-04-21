<%--
  Created by IntelliJ IDEA.
  User: koszkuld
  Date: 21/04/2022
  Time: 18:31
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

<form:form action="/student" method="post" modelAttribute="student">
    <label for="firstName">First name</label>
    <form:input id="firstName" type="text" path="firstName"/><br/>

    <label for="lastName">Last name</label>
    <form:input id="lastName" type="text" path="lastName"/><br/>

    Gender:<br/>
    Male: <form:radiobutton value="male" path="gender"/><br/>
    Female: <form:radiobutton value="female" path="gender"/><br/>
    
    Country:
    <form:select path="country" items="${countries}"/> <br/>

    <label for="notes">Notes</label>
    <form:textarea id="notes" type="text" path="notes"/><br/>

    <label for="mailingList">Mailing list</label>
    <form:checkbox id="mailingList" path="mailingList"/><br/>

    Programming skills:
    <form:select path="programmingSkills" items="${programmingSkills}" multiple="true"/> <br/>

    Hobbies:
    <form:checkboxes path="hobbies" items="${hobbies}"/> <br/>

    <input type="submit"/>
</form:form>

</body>
</html>
