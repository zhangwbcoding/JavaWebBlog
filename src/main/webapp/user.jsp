<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include file = "status.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet" type="text/css"> 
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
<title>用户详情</title>
</head>
<body>

<div class="container">
	<div class="row clearfix">
		<div class="col-md-8 column">
			<s:if test="%{bloglist.size!=0}">
					<h2>发表过的日志</h2>
				<s:iterator value="bloglist">
						<div>
						<h3><s:a href="/MavenTest/blog?blogid=%{blogid}"><s:property value="title"/></s:a></h3>
						<h4>发表于：<s:property value="created_at"/></h4>
						<p>
						<s:property value="summary"/>
						</p>
						</div>
					<hr>
				</s:iterator>					
			</s:if>
			<s:else>
					<h3>该用户还未发表过任何内容！</h3>
			</s:else>		
		</div>	
		<div class="col-md-4 column">
			<h1>
				<s:property value="user.username"/>
			</h1>
			<h4>创建于：<s:property value="user.created_at"/></h4>
			<h3>
				共发表过文章：<s:property value="bloglist.size"/>篇
			</h3>
		</div>	
	</div>
</div>			
			
</body>
</html>