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
		<label>보내는분 계좌 : </label><input type="text" name="sendAccount"><br>
		<label>보낼 금액 : </label><input type="text" name="amount"><br>
		<label>받으실분 계좌 : </label><input type="text" name="receiveAccount"><br>
		<input type="submit" value="이체"/>
	</form>
</body>
</html>