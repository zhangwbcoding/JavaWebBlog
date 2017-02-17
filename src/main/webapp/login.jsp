<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<%@ taglib prefix="s" uri="/struts-tags" %>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>登录</title>  
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	
	});


</script>
<style type="text/css"> 
.align-center{ 
margin:0 auto; /* 居中 这个是必须的，，其它的属性非必须 */ 
width:290px; /* 给个宽度 顶到浏览器的两边就看不出居中效果了 */ 
text-align:center; /* 文字等内容居中 */ 
} 
</style> 
</head>  
<body>   
<s:a href="/MavenTest/main" >首页</s:a>
<s:a href="/MavenTest/register.jsp" >注册</s:a>
<div class="align-center">
	<h3>
	请登录
	</h3>
    <s:form  id="login" action="login">  
        <s:textfield name="user.username" label="用户名"></s:textfield>  
        <s:password name="user.password" label="密码"></s:password> 
        <s:checkbox label="自动登录" name="autologin" value="true"></s:checkbox>     
        <s:submit value="登录"></s:submit>  
    </s:form>

</div>  
</body>  
</html> 