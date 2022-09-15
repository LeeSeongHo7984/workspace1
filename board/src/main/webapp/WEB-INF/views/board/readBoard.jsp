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

<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/readBoard.css'/>"/>
</head>
<body link="black" vlink="black">
	<form action="modifyBoard" method="post" style="text-align: center;">
	<table border="1">
		<tr>
			<td colspan="4" style="text-align: center; height: 80px;">
				<p style="font-size: 30px; font-weight: bold; margin-left: 130px;">게시판</p>
			</td>
		</tr>
		<tr>
			<td style="height: 40px;"><p style="font-weight: bold;">번호</p></td>
			<td style="height: 40px;"><p style="font-weight: bold;">제목</p></td>
			<td style="height: 40px;"><p style="font-weight: bold;">내용</p></td>
			<td style="height: 40px;"><p style="font-weight: bold;">날짜</p></td>
		</tr>
		<c:forEach var="board" items="${boardList}" varStatus="x">
		<tr>
			<td style="width: 80px;"><a href="modifyBoard?num=${board.num}"  
										style="text-decoration: none;">${x.index+1}</a><br></td>
			<td style="width: 200px;">${board.title}<br></td>
			<td style="width: 800px;">${board.content}<br></td>
			<td style="width: 150px;">${board.regDate}<br></td>
		</tr>
		</c:forEach>
	</table>	
	</form>
	
	<form action="readBoard" method="post">
		<input type="submit" value="등록" style="width: 300px;height: 60px;margin-top: 20px;margin-left: 540px;font-size: 20px;">
	</form>
</body>
</html>