    <%@ page contentType="text/html;charset=UTF-8" language="java" %>

        <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
        <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">aaaa</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav navbar-right">
        <li><a href="#">首页</a></li>
        <li><a href="#">设置</a></li>
        <li><a href="#">帮助</a></li>
        </ul>
        <form action="/book/q" class="navbar-form navbar-right">
        <input type="text" class="form-control" placeholder="查询条件(名字)" name="condition">
        </form>
        </div>
        </div>
        </nav>