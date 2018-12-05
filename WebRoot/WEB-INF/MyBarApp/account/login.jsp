<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    <title>login</title>
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
	     
	      <a class="navbar-brand" href="${path }/MyBarApp/index">返回</a>
	    </div>
	  </div><!-- /.container-fluid -->
	</nav>
	
	<div class="page-header">
	  <h2>欢迎登陆贴吧 <small>MyBarApp</small></h2>
	</div>
	<form method="post" action="${path }/MyBarApp/Account/login">
    <div class="input-group">
	  <span class="input-group-addon" id="basic-addon1">账号</span>
	  <input type="text" class="form-control" name="input_account" placeholder="Account" aria-describedby="basic-addon1"
	  	value="${requestScope.loginForm.input_account }">
	</div>
	<label for="basic-addon2"><br></label>
    <div class="input-group">
	  <span class="input-group-addon" id="basic-addon2">密码</span>
	  <input type="password" class="form-control" name="input_password"placeholder="Password" aria-describedby="basic-addon2"
	  	value="${requestScope.loginForm.input_password }">
	</div>
	<input type="submit" value="login">
    </form>
  </body>
</html>
