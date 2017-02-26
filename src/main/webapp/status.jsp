<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet" type="text/css"> 

</head>
<body>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>

<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<ul class="nav nav-tabs">
				<li >
					 <a href="/MavenTest/main" >首页</a>
				</li>
				<li>
					 <a href="/MavenTest/newblog"> 创建日志</a>
				</li>
				<li>
					 <a href="https://github.com/zhangwbcoding/JavaWebBlog" target="_blank">源码 </a>
				</li>
				<li class="disabled">
					 <a href="/MavenTest/manage/blogs">管理</a>
				</li>

	<%
			Cookie[] cookies= request.getCookies();
		    String username=null;
		    String userid=null;
		    if(session.getAttribute("username")!=null){
		    	username=(String)session.getAttribute("username");
		    	userid=(String)session.getAttribute("userid");
		    }
		    
			if (cookies!=null&&session.getAttribute("username")==null){
			    for(Cookie c : cookies)
			    {
					 if(c.getName().equals("user_cookie"))
			    	{
						 System.out.println("找到cookie:  "+c.getValue());
						 username=c.getValue().split("&")[0];
			    		 userid=c.getValue().split("&")[1];			    		 
			    		 session.setAttribute("username",username);
			    		 session.setAttribute("userid",userid);	
			    	}
			    }
			}%>
				<% if (username!=null) {%>	
						<li>
							  <a href="/MavenTest/user?userid=<%=(String)session.getAttribute("userid")%>">${username}</a>
						</li>
						
						<li>
							  <a href="/MavenTest/loginout">登出</a>
						</li>
				<% }else { %>
						<li>
							 <a href="/MavenTest/login.jsp"> 登陆</a>
						</li>
						<li>
							 <a href="/MavenTest/register.jsp"> 注册</a>
						</li>
						<li class="divider">
						</li>

					<% } %>
				</ul>

		</div>
	</div>    
</div>      
          
          

</body>
</html>