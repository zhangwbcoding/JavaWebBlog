<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#getUser").click(function(){
			$.ajax({
				url:"ajaxGetUser",
				type:"post",
				data:{},
				datatype:"json",
				success:function(data){
					$("#allUser").append("<div>输出了：id:" + data.userId + ", name: " + data.username + "</div>");  
	            }  
				
				
			});
		});
		
		$("#submitUser").click(function(){
			$.ajax({
				url:"getuseraction",
				type:"post",
				data:{},
				datatype:"json",
				success:function(data){
					$.each(data,function(i,user){
						
						$("#allUser").append("<div>遍历："+user.username+","+user.userId+"</div>");
					});
					
				}
			});
		});
	});
</script>
</head>
<body>
<div>
        <form id="subUserForm">  
        <input type="text" name="user.username" id="name"/>  
        <input type="text" name="user.userId" id="id"/>  
        </form> 
		<input type="button" value="get" id="getUser">		
		<input type="button" value="submit" id="submitUser">
</div>

<div id="allUser">  
input_user:  
</div> 
</body>
</html>