<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include file = "status.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评论管理</title>
<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet" type="text/css"> 
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
<script type="text/javascript">	
var page = 1;
var currentPage = page;
var totalRows = 0;
var totalPages = 0;
var isFirstPage = true;
var isLastPage = false;

//获取后台返回页码信息，更新分页标签状态
function UpdatePageStatus(data){

	totalRows = data.allRows;
	totalPages = data.allPages;			
	isFirstPage = data.firstPage;
	isLastPage = data.lastPage;
	currentPage = data.currentPage;

	
	$("#total").text(totalRows);
	$("#current").text(currentPage);
	$("#pageCount").text(totalPages);
	
	if(isFirstPage){
		$("#first").hide();
		$("#previous").hide();
	}
	else{
		$("#first").show();
		$("#previous").show();
	}

	if(isLastPage){
		$("#next").hide();
		$("#last").hide();
	}
	else{
		$("#next").show();
		$("#last").show();
	}
}

function bindData(page){
	var param = {"pageIndex":page};
	$.ajax({
		url:"getcomments",
		type:"post",
		data:param,
		datatype:"json",
		success:function(data){
			UpdatePageStatus(data);  //调用更新分页标签状态函数
			$.each(data.list,function(i,value){
				/* 		迭代输出 */
				$("#each").append("<tr id=\"tr_"+i+"\"><td>"+value.blogtitle+"</td>"+"<td>"+value.content+"</td>"+"<td>"+value.username+"</td>"+"<td>"+value.created_at+"</td><td><input type=\"button\" value=\"删除\" id=\"delete_"+i+"\"></td></tr>");
				/* 绑定delete事件 */
				
				$("#delete_"+i).click(function(){
					alert("确认删除该评论？删除后不可恢复！");
					var commentid = value.commentid;
					var param = {"commentid":commentid};
					$.ajax({
						url:"delete_comment",
						type:"post",
						data:param,
						datatype:"text",
						success:function(){
							$("#tr_"+i).hide();
						}
					});
										
				});
			});
		}
	});
}

$(document).ready(function(){
	bindData(page);  //默认页码为1

	//下一页
	$("#next").click(function(){
		$("#each  tr:not(:first)").remove();
		bindData(++page);
		UpdatePageStatus();
	});
	
	//上一页
	$("#previous").click(function(){
		$("#each  tr:not(:first)").remove();
		bindData(--page);
		UpdatePageStatus();
	});
	
	//末页
	$("#last").click(function(){
		$("#each  tr:not(:first)").remove();
		page = totalPages;
		bindData(page);
	});
	
	//首页
	$("#first").click(function(){
		$("#each  tr:not(:first)").remove();
		page = 1;
		bindData(page)
	});
	
	//跳转
	$("#jump").click(function(){
		$("#each  tr:not(:first)").remove();
		jumpPage = $("#jumpPage").val();
		if (jumpPage <= totalPages && jumpPage >=0){
			page = jumpPage;
			bindData(page);
		}
		else{
			alert("输入有误！");
			bindData(page);
		}
	});
});

</script>
 
</head>
<body>

<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<ul class="breadcrumb">
				<li class="active">
					 <a href="/MavenTest/manage/comments" >评论</a> 
				</li>
				<li>
					 <a href="/MavenTest/manage/blogs" >日志</a>
				</li>
				<li>
					 <a href="/MavenTest/manage/users" >用户</a> 
				</li>
			</ul>
			<table class="table table-striped" id="each">
				<thead>
					<tr>
						<th>博客标题</th>     
						<th>评论内容</th>
						<th>用户名</th>       
						<th>评论时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
				<%@include file = "pageStatus.jsp" %>
</div>





</body>
</html>