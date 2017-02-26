<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet" type="text/css">  
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#in_uname").blur(function(){
			var param = $("#in_uname").serialize();
			$.ajax({
				url:"checkUsername",
				type:"post",
				data:param,
				datatype:"text",
				success:function(data){
						$("#msg").html("<b>"+data+"</b>");
				}
			});
		});
	});
</script>
</head>
<body>
<s:a href="/MavenTest/main" >首页</s:a>
<s:a href="/MavenTest/login.jsp" >登录</s:a>

<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3 class="text-center" >
					欢迎注册
			</h3>
			<form class="form-horizontal"  action="register">
				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-5 control-label">用户名</label>
					<div class="col-sm-3">
						<input  class="form-control" id="in_uname"  name="user.username"/><span id="msg"></span><s:fielderror fieldName="username"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-5 control-label">密码</label>
					<div class="col-sm-3">
						<input type="password" class="form-control"  name="user.password"/><s:fielderror fieldName="password"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-5 control-label">重复密码</label>
					<div class="col-sm-3">
						<input type="password" class="form-control"  name="passwordr"/>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-6 col-sm-10">
						 <button type="submit" class="btn btn-default">注册</button>
					</div>
				</div>
			</form>
			    
		</div>
	</div>
</div>


</body>
</html>