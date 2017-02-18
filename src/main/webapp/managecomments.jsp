<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include file = "status.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评论管理</title>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript">	
$(document).ready(function(){
	$.ajax({
		url:"getcomments",
		type:"post",
		data:"{}",
		datatype:"json",
		success:function(data){
			$.each(data,function(i,value){
				/* 		迭代输出 */
				$("#each").append("<tr id=\"tr_"+i+"\"><td>"+value.blogtitle+"</td>"+"<td>"+value.content+"</td>"+"<td>"+value.username+"</td>"+"<td>"+value.created_at+"</td><td><input type=\"button\" value=\"删除\" id=\"delete_"+i+"\"></td></tr>");
				/* 绑定delete事件 */
				$("#delete_"+i).click(function(){
					alert("确认删除该评论？删除后不可恢复！");
					var commentid = value.commentid;
					var param = {"commentid":commentid};
					$.ajax({
						url:"delete_comment",
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
<style type="text/css"> 
.align-center{ 
margin:0 auto; /* 居中 这个是必须的，，其它的属性非必须 */ 
width:450px; /* 给个宽度 顶到浏览器的两边就看不出居中效果了 */ 
text-align:center; /* 文字等内容居中 */ 
} 
</style> 
</head>
<body>
<div class="align-center">
<div>
     <a href="/MavenTest/manage/comments" >评论</a>  
     <a href="/MavenTest/manage/blogs" >日志</a>
     <a href="/MavenTest/manage/users" >用户</a>   
</div>

<table border="1" id="each">
    <tr>
      <th>博客标题</th>     
      <th>评论内容</th>
      <th>用户名</th>       
      <th>评论时间</th>
      <th>操作</th>
    </tr>
</table>
</div>
</body>
</html>