<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file = "status.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet" type="text/css"> 
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
<title>首页</title>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<s:iterator value="bloglist">
				<div>
					<h1>
						<s:property value="title"/><br/>
					</h1>
					<h3><s:property value="username"/></h3>
					<p>发表于：<s:property value="created_at"/><br/></p>
					<p>
					<s:property value="summary"/><br/>
					</p>
					<s:a href="/MavenTest/blog?blogid=%{blogid}">继续阅读</s:a>
				</div>
					<hr>
			</s:iterator>
		</div>
	</div>
</div>

</body>
</html>