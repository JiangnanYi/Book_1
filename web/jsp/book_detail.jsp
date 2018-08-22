<%@ page import="entity.Book" %>
<%@ page import="util.WebUtil" %><%--
  Created by IntelliJ IDEA.
  User: Mr.黎
  Date: 2018/8/21
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>书籍详情</title>
    <style>
        .msg {
            font-size: 2em;
            color: greenyellow;
        }
    </style>
</head>
<body>
<%
    Book book = (Book) request.getAttribute("book");
%>

<%= WebUtil.popSessionMsg(request) %>
<h1>${requestScope.book.name}
</h1>
<ul class="list-group">

    <li class="list-group-item">${requestScope.book.id}
    </li>
    <li class="list-group-item">${requestScope.book.price}
    </li>
    <li class="list-group-item">${requestScope.book.press}
    </li>
</ul>

<a href="book_list.jsp">返回</a>
</body>
</html>
