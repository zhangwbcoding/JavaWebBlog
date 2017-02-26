<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file = "status.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet" type="text/css"> 
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
<title>创建日志</title>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form action="creatblog" method="post">
		    	<label>标题</label>
				<div>
				<input type="text" name="blog.title">
				</div>
				<label>摘要</label>
				<div>
				<textarea name="blog.summary" rows="3" cols="50"></textarea>
				</div>
				<label>内容</label>
				<div>
				<textarea name="blog.content" rows="10" cols="50"></textarea>
				</div>
				<div>
				<input type="submit" value="提交">
				<a href="/MavenTest/main">取消</a>
				</div>	
			</form>
		</div>
	</div>
</div>               
</body>
</html>