<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include file = "status.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日志管理</title>
</head>
<body>
<div>
     <a href="/MavenTest/manage/comments" >评论</a>  
     <a href="/MavenTest/manage/blogs" >日志</a>
     <a href="/MavenTest/manage/users" >用户</a>   
</div>

<table border="1">
    <tr>
      <th>标题</th>
      <th>作者</th>
      <th>创建时间</th>
      <th>操作</th>
      <th>操作</th>
    </tr>
	<s:iterator value="bloglist">
	    <tr>
	      <td><s:a href="/MavenTest/blog?blogid=%{blogid}"><s:property value="title"/></s:a></td>
	      <td><s:property value="username"/></td>
	      <td><s:property value="created_at"/></td>
	      <td><s:a href="/MavenTest/manage/delete_blog?blogid=%{blogid}">删除</s:a></td>
	      <td><s:a href="/MavenTest/edit/show_blog?blogid=%{blogid}">编辑</s:a></td>     
	    </tr>
	</s:iterator>
</table>
</body>
</html>