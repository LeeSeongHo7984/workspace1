<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정하기</title>
</head>
<body>

	<div>회원정보 수정</div>
	
 	<form action="userModify" method="post">
	
	<c:forEach var="user" items="${userList}">
		아이디 <input type="text" name="userId" value="${user.userId}" readonly><br>
		비밀번호 <input type="password" name="passwd" value="${user.passwd}"><br>
		이름 <input type="text" name="name" value="${user.name}" readonly><br>
		주민번호 <input type="text" name="ssn" value="${user.ssn}" readonly><br>
		주소 <input type="text" name="address" value="${user.address}"><br>
		전화번호 <input type="text" name="phone" value="${user.phone}"><br>
	</c:forEach>
		
		<button type="submit">수정완료</button>
		
	</form> 
	
	
	<button type="button" onclick="history.back()">뒤로가기</button>

</body>
</html>