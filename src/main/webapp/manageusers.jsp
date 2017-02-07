<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include file = "status.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>

</head>
<body>
<div>
     <a href="/MavenTest/manage/comments" >评论</a>  
     <a href="/MavenTest/manage/blogs" >日志</a>
     <a href="/MavenTest/manage/users" >用户</a>   
</div>

<table border="1">
    <tr>
      <th>用户名</th>
      <th>注册时间</th>
      <th>权限</th>
      <th>操作</th>
      <th>操作</th>
    </tr>
	<s:iterator value="userlist">
	    <tr>
	      <td><s:a href="/MavenTest/user?userid=%{userId}"><s:property value="username"/></s:a></td>
	      <td><s:property value="created_at"/></td>
	      <td><s:property  value="admin"/></td>
	      <td><s:a href="/MavenTest/manage/addadmin?userid=%{userId}">授权</s:a></td>
	      <td><a href="/MavenTest/manage/removeadmin?userid=%{userId}>">移除</a></td>     
	    </tr>
	</s:iterator>
</table>
</body>
</html>