<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vahan
  Date: 11-Feb-18
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
Add Author :
<span style="color: red">${message}</span>
<spring:form action="/addAuthor" modelAttribute="author" method="post" enctype="multipart/form-data">
    Name:<spring:input path="name" title="name"/><br>
    Surname:<spring:input path="surname" title="surname"/><br>
    Age:<spring:input path="age" title="age"/><br>
    Picture:<input type="file" name="picture"><br>
    <input type="submit" value="Save"/>
</spring:form>
Add Book:
<span style="color: red">${message}</span>
<spring:form action="/addBook" modelAttribute="book" method="post" enctype="multipart/form-data">
    Title:<spring:input path="title" title="title"/><br>
    Text:<spring:textarea path="text" title="text"/><br>
    <%--<input type="file" name="picture1">--%>
    Author:<spring:select path="author" title="author">
    <c:forEach items="${authors}" var="author">
        <spring:option value=" ${author.id}"> ${author.name} ${author.surname}
        </spring:option>
    </c:forEach>
</spring:select><br>
    <input type="submit" value="Save"/>
</spring:form>
Author view:
<spring:form action="/authorView" method="post" enctype="multipart/form-data">
    <c:forEach items="${authors}" var="author">
        <h3> ${author.name} ${author.surname}</h3>
       Age: <h5>${author.age}</h5>
        <img src="/image?fileName=${author.picUrl}"/>
    </c:forEach>
</spring:form>
Book view:
<spring:form action="/bookView" method="post" enctype="multipart/form-data">
    <c:forEach items="${books}" var="book">
        Title:<h3> ${book.title}</h3>
        Author:<h5>${book.author.name} ${book.author.surname}</h5>
        Text:<p>${book.text}</p>
    </c:forEach>
</spring:form>
</body>
</html>
