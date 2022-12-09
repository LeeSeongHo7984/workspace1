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

	<div>회원 정보</div>
	
 	<form action="userInfo" method="post">
	
	<c:forEach var="user" items="${userList}">
		아이디 <input type="text" name="userId" value="${user.userId}" readonly><br>
		비밀번호 <input type="password" name="passwd" value="${user.passwd}" readonly><br>
		이름 <input type="text" name="name" value="${user.name}" readonly><br>
		주민번호 <input type="text" name="ssn" value="${user.ssn}" readonly><br>
		주소 <input type="text" name="address" value="${user.address}" readonly><br>
		전화번호 <input type="text" name="phone" value="${user.phone}" readonly><br>
	</c:forEach>
	
	</form> 
	
	<button type="button" onclick="location.href='userModify';">수정하기</button><br>
	<button onclick="history.back()">뒤로가기</button>

</body>
</html>