<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include file = "status.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript">	
$(document).ready(function(){
	$.ajax({
		url:"getusers",
		type:"post",
		data:"{}",
		datatype:"json",
		success:function(data){
			var json_data = eval("("+data")");
			alert(json_data.list);
			$.each(json_data.list,function(i,value){
				/* 		迭代输出 */
				$("#each").append("<tr><td>"+value.username+"</td>"+"<td>"+value.created_at+"</td>"+"<td id=\"admin_"+i+"\">"+value.admin+"</td>"+"<td><input type=\"button\" value=\"授权\" id=\"add_id_"+i+"\" class=\"add\" ></td>   <td><input type=\"button\" value=\"移除\" id=\"remove_id_"+i+"\" class=\"remove\" ></td></tr>")
				/* 绑定add_admin事件 */
				$("#add_id_"+i).click(function(){
					var userid = value.userId;
					var param = {"userid":userid};
					if (value.admin=="0"){          //此处判断仅作测试，实际业务逻辑与此不同，下同！
						alert("确定要为用户"+value.username+"授予管理员身份?");
						$.ajax({
							url:"addAdmin",
							type:"post",
							data:param,
							datatype:"text",
							success:function(data){
								$("#admin_"+i).text(data);
							}
						});
					}
					else{
						alert("权限不足!!");
					}
				});
				
				/* 绑定remove_admin事件 */
				$("#remove_id_"+i).click(function(){
					var userid = value.userId;
					var param = {"userid":userid};
					if (value.admin=="0"){
						alert("确定要为用户"+value.username+"移除管理员身份?");
						$.ajax({
							url:"removeAdmin",
							type:"post",
							data:param,
							datatype:"text",
							success:function(data){
								$("#admin_"+i).text(data);
							}
						});
					}
					else{
						alert("权限不足!!");
					}
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
      <th>用户名</th>
      <th>注册时间</th>
      <th>权限</th>
      <th>操作</th>
      <th>操作</th>
    </tr>
</table>
</div>
</body>
</html>