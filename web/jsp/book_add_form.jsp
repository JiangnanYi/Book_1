<%--
  Created by IntelliJ IDEA.
  User: Mr.黎
  Date: 2018/8/21
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加书籍</title>
    <meta name="subtitle" content="新增书籍">
</head>
<body>
<form action="/book/add" method="post">
    <div class="form-group">
        <label for="id">书籍ID</label>
        <input type="number" class="form-control" id="id" name="id" placeholder="id">
    </div>
    <div class="form-group">
        <label for="name">书籍名字</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="name">
    </div>
    <div class="form-group">
        <label for="price">书籍价格</label>
        <input type="number" class="form-control" id="price" name="price" placeholder="price">
    </div>
    <div class="form-group">
        <label for="author">书籍作者</label>
        <input type="text" class="form-control" id="author" name="author" placeholder="author">
    </div>
    <div class="form-group">
        <label for="press">出版社</label>
        <input type="text" class="form-control" id="press" name="press" placeholder="press">
    </div>
    <div><input type="submit" class="form-control"></div>
</form>

<script>
    document.querySelector("#bookadd").classList.add("active");
</script>
</body>
</html>
