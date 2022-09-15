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

	<form action="modifyBoard" method="post">
		<c:forEach var="board" items="${boardList}">
			<input type="text" name="no" value="${board.num}" disabled="disabled">
			<input type="text" name="title" value="${board.title}">
			<input type="text" name="content" value="${board.content}">
			<input type="text" name="regDate" value="${board.regDate}" disabled="disabled">
		</c:forEach>
		<button type="submit" onClick="location.href='readBoard'">수정</button>
	</form>
	
	<form action="deleteBoard" method="post">
		<button type="submit" onclick="location.href='readBoard'">삭제</button>
	</form>
</body>
</html>