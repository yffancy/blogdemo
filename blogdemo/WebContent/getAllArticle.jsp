<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../js/jquery-1.7.1.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function del(id){
		$.get("/blogdemo/article/delArticle?id=" + id,function(data){
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
欢迎${loginUser.userName }<hr />
 <a href="/blogdemo/article/toAddArticle?userName=${loginUser.userName}">添加文章</a>
	<hr />
	<h6><a href="/article/toAddArticle">添加文章</a></h6>
	<table>
		<tbody>
			<tr>
				<th>标题</th>
				<th>内容</th>
				<th>操作</th>
			</tr>
			<c:if test="${!empty articleList }">
				<c:forEach items="${articleList }" var="art">
					<tr>
						<td>${art.title }</td>
						<td>${art.content }</td>
						<td>
							<a href="/blogdemo/article/getArticle?articleId=${art.articleId }">编辑</a>
							<a href="javascript:del('${art.articleId }')">删除</a>
						</td>
					</tr>				
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	
</body>
</html>