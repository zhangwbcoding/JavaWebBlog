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
margin:0 auto; /* 居中 这个是必须的，，其它的属性非必须 */ 
width:290px; /* 给个宽度 顶到浏览器的两边就看不出居中效果了 */ 
text-align:center; /* 文字等内容居中 */ 
} 
</style> 

</head>
<body>
<s:a href="/MavenTest/main" >首页</s:a>
<s:a href="/MavenTest/login.jsp" >登录</s:a>

<div class="align-center">
	<h3>
	欢迎注册
	</h3>
    <s:form action="register">  
        <s:textfield name="user.username" label="用户名"></s:textfield>  
        <s:password name="user.password" label="密码"></s:password>
        <s:password name="passwordr" label="重复密码"></s:password>           
        <s:submit value="注册"></s:submit>  
    </s:form> 
</div>
</body>
</html>