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

		
	
		$("#submitUser").click(function(){
			alert("ok");
			$.ajax({
				url:"ajaxGetUser",
				type:"post",
				data:"{}",
				datatype:"json",
				success:function(data){
					alert("zhixing huidao");
					$.each(data,function(i,eachone){
						
						$("#allUser").append("<div>遍历："+eachone+","+eachone+"</div>");
					});
					
				}
			});
		});
	});
</script>
</head>
<body>
<div>
		<input type="button" value="get" id="getUser">		
		<input type="button" value="submit" id="submitUser">
</div>

<div id="allUser">  
input_user:  
</div> 
</body>
</html>