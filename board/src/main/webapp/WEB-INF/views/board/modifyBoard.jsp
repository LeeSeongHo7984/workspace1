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
<title>회원정보 수정</title>
</head>
<body>
	
	<!-- 수정 Form -->
	<form action="modifyBoard" method="post">
		<c:forEach var="board" items="${boardList}">
			<p style="margin-left: 110px;">게시글 번호</p>
			<input type="text" name="num" value="${board.num}" readonly="readonly"
						style="text-align: center; width: 250px; height: 30px; margin-left: 25px;"><br>
			
			<p style="margin-left: 140px;">제목</p>
			<input type="text" name="title" value="${board.title}" 
						style="text-align: center;width: 300px; height: 40px;"><br>
			
			<p style="margin-left: 140px;">내용</p>			
			<input type="text" name="content" value="${board.content}" 
						style="text-align: center; width: 300px; height: 200px;"><br>
			
			<input type="text" name="regDate" value="${board.regDate}" readonly="readonly"
						style="text-align: center; margin-top: 10px; width: 300px; height: 30px;"><br>
		</c:forEach>
		<button type="submit" style="width: 200px; height: 40px; margin-left: 60px; margin-top: 10px;">수정</button>
	</form>
	
	<!-- 삭제 From -->
	<form action="deleteBoard" method="post">
	<c:forEach var="board" items="${boardList}">
		<button type="submit" value="${board.num}" name="num"
						style="width: 200px; height: 40px; margin-top: 10px; margin-left: 60px;">삭제</button>
	</c:forEach>
	</form>
</body>
</html>