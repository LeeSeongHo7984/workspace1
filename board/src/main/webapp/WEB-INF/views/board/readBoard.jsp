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
<title>회원정보 보기</title>
</head>
<body>
	<form action="modifyBoard" method="post" style="text-align: center;">
	<table border="1">
		<tr>
			<td colspan="4" style="text-align: center;">게시판</td>
		</tr>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>내용</td>
			<td>날짜</td>
		</tr>
		<c:forEach var="board" items="${boardList}">
		<tr>
			<td><input type="submit" value="${board.num}"><br></td>
			<td>${board.title}<br></td>
			<td>${board.content}<br></td>
			<td>${board.regDate}<br></td>
		</tr>
		</c:forEach>
	</table>	
	</form>
	
	<form action="readBoard" method="post">
		<input type="submit" value="글쓰기" style="width: 200px; height: 40px; margin-top: 20px; margin-left: 60px;">
	</form>
</body>
</html>