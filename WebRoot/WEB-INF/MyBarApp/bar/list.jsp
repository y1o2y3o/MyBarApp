<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>index</title>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
  </head>
  
  <body>
    <nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="">贴吧</a>
	      <a class="navbar-brand" href="${path }/MyBarApp/Account/register">注册</a>
	      <a class="navbar-brand" href="${path }/MyBarApp/Account/login">登陆</a>
	    </div>
		<button type="button" class="btn btn-default navbar-btn">关注</button>
		<button type="button" class="btn btn-default navbar-btn">首页</button>
	    <form class="navbar-form navbar-left" role="search">
		  <div class="form-group">
		    <input type="text" class="form-control" placeholder="搜索">
		  </div>
		  <button type="submit" class="btn btn-default">搜索</button>
		</form>
		<a class="navbar-brand" href="${path }/MyBarApp/Bar/create">创建贴吧</a>
	  </div><!-- /.container-fluid -->
	</nav>
	
	<div class="panel panel-default">
	  <!-- Default panel contents -->
	  <c:forEach var="bar" items="${requestScope.barList }">
	  <div class="panel-heading"><a href="${path }/MyBarApp/Post/list?bar_id=${bar.id}">${bar.name }吧</a></div>
	  <div class="panel-body">
	    <p>...</p>
	  </div>
	  </c:forEach>
	</div>
    
  </body>
</html>
