<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cafe</title>
</head>
<body>
<h3>Java Cafe</h3>
	<form action="selectMenu" method="post">
	<label>메뉴</label>
	<select name="name">
		<option value="unknown">--선택--</option>
		<c:forEach var="menu" items="${menuList}">
		<option value="${menu.name}">${menu.name}</option>
		</c:forEach>
	</select><br>
	<input type="submit" value="확인" />
	</form>
</body>
</html>