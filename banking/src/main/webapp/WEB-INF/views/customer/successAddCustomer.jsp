<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
</head>
<body>
	<h3>가입여부 확인</h3>
		<label>회원 아이디 : </label>${customer.userId }<br>
		<label>비밀번호 : </label>${customer.passwd }<br>
		<label>이름 : </label>${customer.name }<br>
		<label>주민번호 : </label>${customer.ssn }<br>
		<label>전화번호 : </label>${customer.phone }<br>
</body>
</html>