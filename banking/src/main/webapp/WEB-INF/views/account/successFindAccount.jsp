<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객계좌 정보</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
</head>
<body>
	<h3>고객계좌 정보</h3>
	<c:forEach var="account" items="${accountList}">
		계좌번호 : ${account.accountNum}<br>
		계좌타입 : ${account.accType}<br><br>
	</c:forEach>
</body>
</html>