<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #aaa;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 0px;
            overflow: hidden;
            word-break: normal;
            border-color: #aaa;
            color: #333;
            background-color: #fff;
            border-top-width: 1px;
            border-bottom-width: 1px;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 0px;
            overflow: hidden;
            word-break: normal;
            border-color: #aaa;
            color: #fff;
            background-color: #f38630;
            border-top-width: 1px;
            border-bottom-width: 1px;
        }

        .tg .tg-qsvf {
            font-size: 18px;
            vertical-align: top
        }

        .tg .tg-13pz {
            font-size: 18px;
            text-align: center;
            vertical-align: top
        }

        .tg .tg-yw4l {
            vertical-align: top
        }
    </style>

</head>

<body>
<c:if test="${!empty usersList}">
<table class="tg">
    <tr>
        <th class="tg-13pz">Id</th>
        <th class="tg-qsvf">Name</th>
        <th class="tg-qsvf">Age</th>
        <th class="tg-qsvf">Is Admin</th>
        <th class="tg-qsvf">Created date</th>
        <th class="tg-qsvf">Edit</th>
        <th class="tg-qsvf">Remove</th>
    </tr>
    <c:forEach items="${usersList.pageList}" var="user">
        <tr>
            <td class="tg-yw4l">${user.id}</td>
            <td class="tg-yw4l">${user.name}</td>
            <td class="tg-yw4l">${user.age}</td>
            <td class="tg-yw4l">
                <c:if test="${user.admin}">
                    YES
                </c:if>
                <c:if test="${!user.admin}">
                    NO
                </c:if>

            </td>
            <td class="tg-yw4l">${user.createdDate}</td>
            <td class="tg-yw4l"><a href="/edit=${user.id}">edit</a></td>
            <td class="tg-yw4l"><a href="/remove/${user.id}">remove</a></td>
        </tr>

    </c:forEach>

    </c:if>
    <c:if test="${empty usersList}">
        List is EMPTY
    </c:if>
    <form method="get" action="/users" target="_self">
        <input name="page" value="${usersList.page+1}" hidden> <input type=submit value="Next page"></form>

    <form method="get" action="/users" target="_self">
        <input name="page" value="${usersList.page-1}" hidden> <input <c:if test="${usersList.page eq 0}">disabled</c:if> type=submit value="Prev page"></form>

</table>
<a href="/addUser">ADD USER</a>
</body>
</html>
