<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<%@ taglib prefix="s" uri="/struts-tags" %>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>登录</title> 
<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet" type="text/css"> 


</head>  
<body>  
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
 
<s:a href="/MavenTest/main" >首页</s:a>
<s:a href="/MavenTest/register.jsp" >注册</s:a>

<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3 class="text-center" >
					请登录
			</h3>
			<form class="form-horizontal" id="login" action="login">
				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-5 control-label">用户名</label>
					<div class="col-sm-3">
						<input  class="form-control" id="inputEmail3"  name="user.username"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-5 control-label">密码</label>
					<div class="col-sm-3">
						<input type="password" class="form-control" id="inputPassword3" name="user.password"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-5 col-sm-10">
						<div class="checkbox">
							 <label><input type="checkbox" name="autologin" value="true"/>自动登录</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-6 col-sm-10">
						 <button type="submit" class="btn btn-default">登录</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

  
</body>  
</html> 