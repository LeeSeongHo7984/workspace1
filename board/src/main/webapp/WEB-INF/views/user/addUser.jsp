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
<title>회원가입</title>
</head>
<body>

	<form action="addUser" method="post">
		<div>아이디</div>
		<input type="text" name="userId" placeholder="아이디를 입력하세요"><br>
		<div>비밀번호</div>
		<input type="password" name="passwd" placeholder="비밀번호를 입력하세요"><br>
		<div>이름</div>
		<input type="text" name="name" placeholder="이름을 입력하세요"><br>
		<div>주민번호</div>
		<input type="text" name="ssn" placeholder="주민번호를 입력하세요"><br>
		<div>주소</div>
		<input type="text" name="address" placeholder="주소를 입력하세요"><br>
		<div>번호</div>
		<input type="text" name="phone" placeholder="번호를 입력하세요"><br>
		
		<input type="submit" value="가입하기" />
	</form>
	
	<button type="button" onclick="location.href='/login'">취소</button>
	
</body>
</html>