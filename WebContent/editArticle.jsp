<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../js/jquery-1.7.1.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>编辑文章</h1>
	<form action="/blogdemo/article/updateArticle" name="articleForm" method="post">
		<input type="hidden" name="articleId" value="${article.articleId }">
		标题：<br/><input type="text" name="title" value="${article.title }">
		<br/><br/>
		内容：<br/><textarea name="content"  cols="45" rows="20" class="inputTextW480">${article.content } </textarea>
		<br/><br/>
		<input type="submit" value="编辑" >
	</form>
</body>
</html>