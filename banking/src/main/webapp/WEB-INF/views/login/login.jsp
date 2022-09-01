<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
</head>
<body>
	<h3>로그인</h3>
	<form action="login" method="post">
		<label>아이디</label><input type="text" name="userId"><br>
		<label>비밀번호</label><input type="password" name="passwd">
		<input type="submit" value="로그인"/>
	</form>
</body>
</html>