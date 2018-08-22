<%@ page import="entity.Book" %>
<%@ page import="java.util.List" %>
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
    <title>图书列表</title>
</head>
<body>
<%= WebUtil.popSessionMsg(request) %>

<form action="/book/del" method="post">

    <table class="table table-striped">
        <tr>
            <th><input type="checkbox" onclick="alls(this)"></th>
            <th>id</th>
            <th>书名</th>
            <th>价格</th>
            <th>作者</th>
            <th>出版社</th>
            <th>其他</th>
        </tr>
        <%--<%--%>
        <%--List<Book> books = (List<Book>) request.getAttribute("books");--%>
        <%--request.getSession().setAttribute("books",books);--%>

        <%--for (Book book : books) {--%>
        <%--%>--%>
        <c:forEach items="${requestScope.books}" var="listItem">

            <tr>
                <td><input name="id" value="${listItem.id}" type="checkbox"></td>
                <td>${listItem.id}
                </td>
                <td><a href="/book/detail?id=${listItem.id}">${listItem.name}
                </a></td>
                <td>${listItem.price}
                </td>
                <td>${listItem.author}
                </td>
                <td>${listItem.press}
                </td>
                <td>
                    <a href="/book/del?id=${listItem.id}">删除</a>
                    <a data-toggle="modal" href="#myModal" data-id="${listItem.id}">更新</a>
            </tr>
        </c:forEach>
        <%--<%--%>
        <%--}--%>
        <%--%>--%>
    </table>


    <div style="margin-top: 2em;">
        <input type="submit" value="删除" class="btn btn-success">
        <a href="/book/add">增加新的书籍</a>
    </div>
</form>

<%@ include file="book_update_2.jsp" %>
<script src="/assets/js/jquery1.12.4.js"></script>
<script>
    function alls(e) {
        var checkboxs = document.getElementsByName("id");
        for (var i = 0; i < checkboxs.length; i++) {
            checkboxs[i].checked = e.checked
        }
    }

    document.querySelector("#booklist").classList.add("active");


    //弹出框修改
    $("#myModal").on("show.bs.modal", function (e) {
        var x = event.target;
        var $x = $(x);
        $.post("/book/detail", {id: $(x).attr("data-id")}, function (data) {
            //$("#bookId").val(data.id);
            //$("#bookname").val(data.name);
            //$("#bookprice").val(data.price);
            //$("#bookauthor").val(data.author);
            //$("#bookpress").val(data.press);
            document.getElementById("bookId").value = data.id;
            document.getElementById("bookname").value = data.name;
            document.getElementById("bookprice").value = data.price;
            document.getElementById("bookauthor").value = data.author;
            document.getElementById("bookpress").value = data.press;

        });

        //     var tds = x.parentNode.parentNode.getElementsByTagName("td");
        // var id = tds[1].childNodes[0].nodeValue;
        // var name = tds[2].childNodes[0].childNodes[0].nodeValue;
        // var price = tds[3].childNodes[0].nodeValue;
        // var author = tds[4].childNodes[0].nodeValue;
        // var press = tds[5].childNodes[0].nodeValue;
        //
        // $("#bookId").val(id.trim());
        // $("#bookname").val(name.trim());
        // $("#bookprice").val(price.trim());
        // $("#bookauthor").val(author.trim());
        // $("#bookpress").val(press.trim());
    });


</script>
</body>
</html>
