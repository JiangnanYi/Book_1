    <%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
        <%@ taglib prefix="decoder" uri="http://www.opensymphony.com/sitemesh/decorator" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>

        <!DOCTYPE html>
        <html lang="zh-CN">
        <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title><sitemesh:title /></title>

        <%@include file="book_res_pre.jsp"%>

        <sitemesh:head></sitemesh:head>
        </head>

        <body>

        <%--顶部区域--%>
        <%@include file="book_nav.jsp"%>

        <%--主体区域--%>
        <div class="container-fluid">
        <div class="row">
        <%--菜单栏--%>
        <%@include file="book_menu.jsp"%>
        <%--body--%>
        <%@include file="book_body.jsp"%>
        </div>
        </div>

        <%@include file="book_res_post.jsp"%>
        </body>
        </html>
