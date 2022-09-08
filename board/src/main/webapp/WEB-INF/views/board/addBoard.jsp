<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addBoard" method="post">
		<h3>게시글 작성</h3>
		<span style="font-size: 20px; text-align: center;">제목</span>
		<textarea name="title" maxlength="20" placeholder="제목을 입력하세요(최대 20자)">
		</textarea><br>
		
		<span style="font-size: 20px; text-align: center;">내용</span>
		<textarea name="content" maxlength="200" placeholder="내용을 입력하세요(최대 200자)">
		</textarea><br>
		
		<input type="submit" value="확인">
	</form>
</body>
</html>