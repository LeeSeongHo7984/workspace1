<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/addCustomer.css'/>"/>
</head>
<body>
	<h3>회원가입</h3>
	<form action="addCustomer" method="post">
		<div>
			<label>회원 아이디 : </label><input type="text" name="userId"><br>
		</div>
		<div>
			<label>비밀번호 : </label><input type="password" name="passwd"><br>
		</div>
		<div>
			<label>이름 : </label><input type="text" name="name"><br>
		</div>	
		<div>	
			<label>주민번호 : </label><input type="text" name="ssn"><br>
		</div>	
		<div>	
			<label>전화번호 : </label><input type="text" name="phone"><br>
		</div>	
		<div>	
			<input type="checkbox" name="agree">약관동의
		</div>	
		<div>	
			<input type="submit" value="회원가입"/>
		</div>
	</form>
</body>
</html>

