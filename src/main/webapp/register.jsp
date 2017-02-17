<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<style type="text/css"> 
.align-center{ 
margin:0 auto;
width:290px;  
text-align:center; 
} 
</style> 
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
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

<div class="align-center">
	<h3>
	欢迎注册
	</h3>
	<div>
	    <s:form action="register" >  
	        <s:textfield name="user.username" label="用户名" id="in_uname"></s:textfield> <s:fielderror fieldName="username"/>
	        <s:password name="user.password" label="密码"></s:password> <s:fielderror fieldName="password"/>
	        <s:password name="passwordr" label="重复密码"></s:password>           
	        <s:submit value="注册"></s:submit>  
	    </s:form> 
    </div>
    <div id="msg">
    </div>
    
</div>
</body>
</html>