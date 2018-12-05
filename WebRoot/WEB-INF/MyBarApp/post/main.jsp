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
    <title>mainpost</title>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <script>
      function setModal2(v1, v2){
      	document.getElementById("input_hostreply_id").value=v1
      	document.getElementById("input_target_user_id").value=v2
      }
    </script>
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
	      <a class="navbar-brand" href="${path }/MyBarApp/Post/list?bar_id=${requestScope.mainPost.hostBar.id}">返回</a>
	    </div>
		<form class="navbar-form navbar-left" role="search">
		  <div class="form-group">
		    <input type="text" class="form-control" placeholder="搜索">
		  </div>
		  <button type="submit" class="btn btn-default">搜索</button>
		</form>
		<a class="navbar-brand" href="${path }/MyBarApp/Post/create_main?bar_id=${requestScope.bar.id}">新建</a>
	  </div><!-- /.container-fluid -->
	</nav>
	<h4>${requestScope.mainPost.hostBar.name}吧  的 主题帖</h4>
	<a href="" id="dd1" aria-hidden="true" data-toggle="modal" data-target="#modal1">回复</a>
	<hr>
	<div class="panel panel-default">
	  <h2>作者:${requestScope.mainPost.author.username }</h2>
	  <h2>标题:${requestScope.mainPost.title }</h2>
	  <h2>内容:${requestScope.mainPost.description }</h2>		
	  <!-- Default panel contents -->
	  <c:forEach var="reply" items="${requestScope.mainPost.replies }">
	  <div class="panel-heading"><a href="">层主:${reply.author.username}</a>
	  
	    <p>${reply.description }</p>
	     ${reply.order }楼  ${reply.createOn } <a href="${path }/MyBarApp/Post/reply"></a>
	    <a href="" id="dd1" aria-hidden="true" data-toggle="modal" data-target="#modal2" onclick="setModal2('${reply.id}', '${reply.author.id }')">回复</a>
	  </div>
	  
	  <c:forEach var="secondaryReply" items="${reply.secondaryReplies }">
	  <div class="panel-body">
	  	<p>${secondaryReply.author.username }: #回复 ${secondaryReply.replyTarget.username }:
	  	${secondaryReply.description }
	  	${secondaryReply.createOn }<br>
	  	</p>
	  	<a href="" id="dd1" aria-hidden="true" data-toggle="modal" data-target="#modal2" onclick="setModal2('${reply.id}', '${secondaryReply.author.id }')">回复楼中楼</a>
	  	<hr>
	  </div>
	  </c:forEach>
	  <br>
	  </c:forEach>
	  
	</div>
	
    <!-- 回复 Modal -->
	<form action="${path }/MyBarApp/Post/create_reply" method="post">
	<div class="modal fade" id="modal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">回复:${requestScope.mainPost.author.username }</h4>
	      </div>
	      <div class="modal-body">
	        <div class="form-group">
		      <label for="reply">回复</label>
		      <input type="text" class="form-control" name="input_description" id="reply" ><br>
		      <input type="text" class="form-control" name="input_user_id" value="${sessionScope.user.id }"><br>
		      <input type="text" class="form-control" name="input_hostpost_id" value="${requestScope.mainPost.id }" >
	      </div>	         
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <button type="submit" class="btn btn-primary">提交</button>
	      </div>
	    </div>
	  </div>
	</div>
	</div>
	</form>
	
	<!-- 楼中楼回复 Modal -->
	<form action="${path }/MyBarApp/Post/create_secondary_reply" method="post">
	<div class="modal fade" id="modal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">回复:${requestScope.mainPost.author.username }</h4>
	      </div>
	      <div class="modal-body">
	        <div class="form-group">
		      <label for="reply">回复</label>
		      <input type="text" class="form-control" id="input_description" name="input_description"  ><br>
		      <input type="text" class="form-control" id="input_user_id" name="input_user_id" value="${sessionScope.user.id }"><br>
		      <input type="text" class="form-control" id="input_hostreply_id" name="input_hostreply_id"  >
		      <input type="text" class="form-control" id="input_target_user_id" name="input_target_user_id">
		      <input type="text" class="form-control" id="input_mainpost_id" name="input_mainpost_id" value="${requestScope.mainPost.id }" >
	      </div>
	     
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <button type="submit" class="btn btn-primary">提交</button>
	      </div>
	    </div>
	  </div>
	</div>
	</div>
	</form>
	
	
  </body>
</html>
