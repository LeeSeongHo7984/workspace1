<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.io.*, java.text.*, java.util.*" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko" dir="ltr">
<head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no,  maximum-scale=1.0, minimum-scale=1.0">
<title>게시글 등록</title>
</head>
<body style="text-align: center;">
	<form action="addBoard" method="post">
		<h3 style="font-size: 40px; margin-top: 25px; font-weight: bold;">게시글 작성</h3>
		<div style="width: 400px; text-align: center; font-size: 25px; font-weight: bold; margin: 0 auto; margin-bottom: 20px; margin-top: -10px;">제목
		</div>
		
		<div>
			<textarea name="title" maxlength="20" placeholder="제목을 입력하세요(최대 20자)" 
					style="width: 400px; text-align: center; font-size: 20px; font-weight: bold;">
			</textarea>
		</div>
		<br>
		
		<div style="width: 400px; text-align: center; font-size: 25px; font-weight: bold; margin: 0 auto; margin-bottom: 20px;">내용</div>
			<textarea name="content" maxlength="200" placeholder="내용을 입력하세요(최대 200자)"
					style="width: 400px; height:200px; text-align: center; font-size: 20px;">
			</textarea><br>
		
		<input type="submit" value="확인" style="width: 200px;height: 50px;margin-top: 30px;font-size: 15px;">
	</form>
	
</body>
</html>