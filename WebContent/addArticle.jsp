<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加文章</title>
<script type="text/javascript">
	function addArticle(){
		var form = document.forms[0];
		form.action = "/blogdemo/article/addArticle?userName=${userName}";
		form.method="post";
		form.submit();
	}
</script>
</head>
<body>
	<h1>添加文章</h1>
	<form action="" name="articleForm">
		标题：<input type="text" name="title">
		<br/>
		内容：<br/><textarea name="content"  cols="45" rows="20" class="inputTextW480"></textarea>
		<br/><br/>
		<input type="hidden" name="userName" value="${userName}"> 
		<input type="button" value="添加" onclick="addArticle()">
	</form>
</body>
</html>