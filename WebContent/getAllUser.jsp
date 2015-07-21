<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../js/jquery-1.7.1.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看用户列表</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/main.css>" type="text/css"/>
<script type="text/javascript">
	function del(id){
		$.get("/blogdemo/user/delUser?id=" + id,function(data){
			if("success" == data.result){
				alert("删除成功");
				window.location.reload();
			}else{
				alert("删除失败");
			}
		});
	}
</script>
</head>
<body>
	<a href="/blogdemo/user/toAddUser">添加</a>--欢迎${loginUser.userName }
	<hr />
	<c:if test="${!empty userList }">
	<c:forEach items="${userList}" var="user">
		<input type="hidden" value="${user.id}">
		${user.userName}		
		${user.passWord}
		<a href="<%=request.getContextPath() %>/user/getUser?id=${user.id}">修改</a>
		<a href="javascript:del('${user.id }')">删除</a>
		<hr />
	</c:forEach>
	</c:if>
</body>
</html>