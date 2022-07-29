<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이체</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
</head>
<body>
	<form action="transfer" method="post">
		<label>보낼분 계좌 : </label><input type="text" name="accuontNum"><br>
		<label>비밀번호 : </label><input type="passwd" name="passwd"><br>
		<label>받으실분 계좌 : </label><input type="text" name="accountNum"><br>
		<input type="submit" value="이체"/>
	</form>
</body>
</html>