<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
<body>

	<c:forEach var="user" items="${userList}">
		<input type="text" name="user.userId" readonly> 이름 <br>
		<input type="password" name="user.passwd" readonly> 비밀번호<br>
		<input type="text" name="user.name" readonly> 이름 <br>
		<input type="text" name="user.ssn" readonly> 주민번호 <br>
		<input type="text" name="user.address" readonly> 주소 <br>
		<input type="text" name="user.phone" readonly> 전화번호 <br>
	</c:forEach>

</body>
</html>