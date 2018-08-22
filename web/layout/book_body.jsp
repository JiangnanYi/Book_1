    <%@ page contentType="text/html;charset=UTF-8" language="java" %>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <%--<%@include file="book_body_top.jsp"%>--%>

        <h2 class="sub-header">
        <sitemesh:getProperty property="meta.subtitle" default="书籍" />
        </h2>
        <div class="table-responsive">
        <sitemesh:body></sitemesh:body>
        </div>
        </div>