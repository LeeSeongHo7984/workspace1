<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body style="text-align: center;">
	<form action="addBoard" method="post">
		<h3>게시글 작성</h3>
		<div style="width: 400px; text-align: center; font-size: 20px; font-weight: bold; margin: 0 auto;">제목</div>
		<div>
		<textarea name="title" maxlength="20" placeholder="제목을 입력하세요(최대 20자)" 
					style="width: 400px; text-align: center; font-size: 20px; font-weight: bold;">
		</textarea>
		</div>
		<br>
		
		<div style="width: 400px; text-align: center; font-size: 20px; font-weight: bold; margin: 0 auto;">내용</div>
		<textarea name="content" maxlength="200" placeholder="내용을 입력하세요(최대 200자)"
					style="width: 400px; height:200px; text-align: center; font-size: 20px;">
		</textarea><br>
		
		<input type="submit" value="확인" style="width: 100px; height: 40px; margin-top: 10px;">
	</form>
</body>
</html>