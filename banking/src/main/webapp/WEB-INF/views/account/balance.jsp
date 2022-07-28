<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>잔고 확인</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
</head>
<body>
	<form action="balance" method="post">
		<label>계좌번호를 입력해 주세요 : </label><input type="text" name="accountNum"><br>
		<input type="submit" value="확인">
	</form>
</body>
</html>