<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include file = "status.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评论管理</title>
</head>
<body>
<div>
     <a href="/MavenTest/manage/comments" >评论</a>  
     <a href="/MavenTest/manage/blogs" >日志</a>
     <a href="/MavenTest/manage/users" >用户</a>   
</div>

<table border="1">
    <tr>
      <th>博客标题</th>     
      <th>评论内容</th>
      <th>用户名</th>       
      <th>评论时间</th>
      <th>操作</th>
    </tr>
	<s:iterator value="commentlist">
	    <tr>
	      <td><s:a href="/MavenTest/blog?blogid=%{blogid}"><s:property value="blogtitle"/></s:a></td>
	      <td><s:property value="content"/></td>
	      <td><s:property value="username"/></td>
	      <td><s:property value="created_at"/></td>      
	      <td><s:a href="/MavenTest/manage/delete_comment?commentid=%{commentid}">删除评论</s:a></td>
	    </tr>
	</s:iterator>
</table>
</body>
</html>