<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div class="navigation"> 
共<label id="total"></label>条数据 第[<label id="current"></label>]页/共[<label id="pageCount">0</label>]页 
<a id="first" href="#">首页</a> <a id="previous" href="#">上一页</a> <a id="next" href="#"> 
下一页</a> <a id="last" href="#">末页</a> 
<span>跳转到第<input id="jumpPage"  style="width:20px;" value="1"></input>页</span><span><input type="button" id="jump" value="go"></input></span>
</div> 
</body>
</html>