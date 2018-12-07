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
    <title>postlist</title>
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
	      <a class="navbar-brand" href="${path }/MyBarApp/Bar/list">返回</a>
	    </div>
		<form class="navbar-form navbar-left" role="search">
		  <div class="form-group">
		    <input type="text" class="form-control" placeholder="搜索">
		  </div>
		  <button type="submit" class="btn btn-default">搜索</button>
		</form>
		<a class="navbar-brand" href="${path }/MyBarApp/Post/create_main?bar_id=${pager.bar.id}">新建</a>
	  </div><!-- /.container-fluid -->
	</nav>
	<h1>${pager.bar.name}吧</h1>
	<h3>排序依据：</h3>
	<ul>
	  <li><a href="${path }/MyBarApp/Post/list?page=0&size=${pager.pageSize }&orderby=lastReplyOn&bar_id=${pager.bar.id}">回复时间</a></li>
	  <li><a href="${path }/MyBarApp/Post/list?page=0&size=${pager.pageSize }&orderby=createOn&bar_id=${pager.bar.id}">发帖时间</a></li>
	  <li><a href="${path }/MyBarApp/Post/list?page=0&size=${pager.pageSize }&orderby=replyNum&bar_id=${pager.bar.id}">帖子热度</a></li>
	  <li><a href="${path }/MyBarApp/Post/list?page=0&size=${pager.pageSize }&orderby=&bar_id=${pager.bar.id}">关注的人</a></li>
	</ul>
	
	<hr>
	<h2>帖子：</h2>
	<div class="panel panel-default">
	
	  <!-- Default panel contents -->
	  <c:forEach var="post" items="${requestScope.pager.content }">
	  <div class="panel-heading"><a href="${path }/MyBarApp/Post/main?page=0&size=20&replyAuthor_id=&sc=asc&hostPost_id=${post.id}">#标题-----${post.title }</a></div>
	  <div class="panel-body">
	    <p>#内容-----${post.description }</p>
	    <hr>#楼主：${post.author.username} ---- ${post.createOn }------ ${post.lastReplyOn }
	  </div>
		
	  </c:forEach>
	</div>
    <div class="btn-group" role="group" aria-label="...">
	  <a href="${path }/MyBarApp/Post/list?bar_id=${pager.bar.id}&page=${pager.previousPage}&size=${pager.pageSize}&orderby=${pager.orderby}"><button type="button" class="btn btn-default">上一页</button></a>
	  ${pager.currentPage + 1 } / ${pager.lastPage + 1}
	   <a href="${path }/MyBarApp/Post/list?bar_id=${pager.bar.id}&page=${pager.nextPage}&size=${pager.pageSize}&orderby=${pager.orderby}"><button type="button" class="btn btn-default">下一页</button></a>
	</div>
  </body>
</html>
