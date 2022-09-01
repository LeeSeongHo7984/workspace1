<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 조회</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
</head>
<body>
	<form action="findAccount" method="post">
	<h3>아이디로 계좌조회</h3>
	<label>아이디를 입력해 주세요</label> <input type="text" name="customerId"><br>
	<input type="submit" value="확인">
	</form>
</body>
</html>