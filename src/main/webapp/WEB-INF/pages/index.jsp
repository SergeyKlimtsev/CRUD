<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Users</title>
</head>
<body>
  <h3><a href="/users">ALL Users</a></h3>
  <br>
  <br>
  <form method="get" action="/search" target="_blank">
      <input name="name" id="form-query" value="" placeholder="User name"> <input type=submit value="Search"></form>


</body>
</html>
