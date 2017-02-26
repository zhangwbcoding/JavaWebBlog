<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include file = "status.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日志详情</title>
<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet" type="text/css"> 
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#submit").click(function(){
		var param = $("#form").serialize();
		$.ajax({
			url:'creatcomment',
			type:"post",
			data:param,
			datatype:"json",
			success:function(data){			
				$("#list").append("<li><div><h4><a href=\"/MavenTest/user?userid="+data.userid+"\">"+data.username+"</a>  评论于："+data.created_at+"</h4></div><div>"+data.content+"</div></li><hr>");
			},
			error:function(){
				alert("请先登录！");
			}
		});
	});
	
});


</script>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
				<div>
					<h1>
						<s:property value="blog.title"/>
					</h1>
					<h4><s:a href="/MavenTest/user?userid=%{blog.userid}"><s:property value="blog.username"/></s:a>  发表于：<s:property value="blog.created_at"/></h4>
					<p>
						<s:property value="blog.summary"/>
					</p>
					<p>
						<s:property value="blog.content"/>
					</p>
				</div>
				<hr>
			
			 	<h3>最新评论</h3>
			<s:if test="%{commentlist.size==0}">
				还没有人评论！
				<hr>
			</s:if>
			<s:else>
				<ul id="list">
					<s:iterator value="commentlist">
						<li>
							<div>
								<h4><s:a href="/MavenTest/user?userid=%{userid}"><s:property value="username"/></s:a>  评论于：<s:property value="created_at"/></h4>
							</div>
							<div>
								<s:property value="content"/>
							</div>
						</li>	
						<hr>
					</s:iterator>
				</ul>
			</s:else>
			<div>
				<s:form action="creatcomment" id="form">
					<s:label>说点什么吧！</s:label>
					<div>
					<s:textarea name="comment.content" rows="5" cols="50"></s:textarea>
					<s:hidden name="comment.blogid" value="%{blog.blogid}"></s:hidden>
					</div>
				</s:form>
				
				<div>
					<input id="submit" type="button" value="保存">	  
				</div>	
			
			</div> 
		</div>
	</div>
</div>
</body>
</html>