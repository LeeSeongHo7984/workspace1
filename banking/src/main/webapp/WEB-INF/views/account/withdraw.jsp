<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출금</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
</head>
<body>
	<form action="withdraw" method="post">
	<label>출금할 계좌번호를 입력하세요 : <input type="text" name="accountNum"></label><br>
	<label>출금할 금액을 입력하세요 : <input type="text" name="amount"></label><br>
	<input type="submit" value="출금">
	</form>
</body>
</html>