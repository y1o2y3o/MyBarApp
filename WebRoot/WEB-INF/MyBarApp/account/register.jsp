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
    <title>register</title>
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
	  <h2>注册账号<small>MyBarApp</small></h2>
	</div>
	
	<form method="post" action="${path }/MyBarApp/Account/register">
    <div class="input-group">
	  <span class="input-group-addon" id="basic-addon1">账号</span>
	  <input type="text" class="form-control" name="input_account" placeholder="Account" aria-describedby="basic-addon1">
	</div>
	<label for="basic-addon2"></label>
    <div class="input-group">
	  <span class="input-group-addon" id="basic-addon2">密码</span>
	  <input type="password" class="form-control" name="input_password" placeholder="Password" aria-describedby="basic-addon2">
	</div>
    <label for="basic-addon3"></label>
    <div class="input-group">
	  <span class="input-group-addon" id="basic-addon3">确认密码</span>
	  <input type="password" class="form-control" placeholder="Password" aria-describedby="basic-addon3">
	</div>
	<div class="input-group">
	  <span class="input-group-addon" id="basic-addon4">用户名</span>
	  <input type="text" class="form-control" name="input_username" placeholder="Account" aria-describedby="basic-addon4">
	</div>
	<div class="form-group">
      <label class="radio-inline">
        <input type="radio" value="MALE" name="input_gender">男性
      </label>
      <label class="radio-inline">
        <input type="radio" value="FEMALE" name="input_gender">女性
      </label>
    </div>
	<div class="input-group">
	  <span class="input-group-addon" id="basic-addon5">手机号</span>
	</div>
	
	<input type="submit" value="确认"/>
	</form>
	
  </body>
</html>
