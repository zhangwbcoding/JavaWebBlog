<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include file = "status.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日志管理</title>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript">	
$(document).ready(function(){
	$.ajax({
		url:"getblogs",
		type:"post",
		data:"{}",
		datatype:"json",
		success:function(data){
			$.each(data,function(i,value){
				/* 		迭代输出 */
				$("#each").append("<tr id=\"tr_"+i+"\"><td>"+value.title+"</td>"+"<td>"+value.username+"</td>"+"<td>"+value.created_at+"</td>"+"<td><a href=\"/MavenTest/edit/show_blog?blogid\="+value.blogid+"\">编辑</a></td><td><input type=\"button\" value=\"删除\" id=\"delete_"+i+"\"></td></tr>");
				/* 绑定delete事件 */
				$("#delete_"+i).click(function(){
					alert("确认删除该文章？删除后不可恢复！");
					var blogid = value.blogid;
					var param = {"blogid":blogid};
					$.ajax({
						url:"delete_blog",
						type:"post",
						data:param,
						datatype:"text",
						success:function(){
							$("#tr_"+i).hide();
						}
					});
										
				});
			});
		}
	});
});

</script>
</head>
<body>
<div>
     <a href="/MavenTest/manage/comments" >评论</a>  
     <a href="/MavenTest/manage/blogs" >日志</a>
     <a href="/MavenTest/manage/users" >用户</a>   
</div>

<table border="1" id="each">
    <tr>
      <th>标题</th>
      <th>作者</th>
      <th>创建时间</th>
      <th>操作</th>
      <th>操作</th>
    </tr>

</table>
</body>
</html>