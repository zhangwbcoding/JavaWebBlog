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
	$("form").submit(function(){
		alert("chufa");
		$.ajax({
			url:"ajaxtext",
			type:"post",
			data:"{}",
			dataType:"json",
			success:function(data){
				alert("hello!");	
			}
		});
	});
	
});


</script>
</head>
<body>
        <form id="info" action="ajaxtext" method="post">  
	        <input type="text" name="name" id="name"/>  
	        <input type="text" name="age" id="age"/>  
	        <input type="submit" value="Submit">
        </form> 
</body>
</html>