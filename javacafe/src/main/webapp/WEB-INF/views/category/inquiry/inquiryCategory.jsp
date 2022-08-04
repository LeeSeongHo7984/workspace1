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
	<form action="selectCategory" method="post">
	<label>카테고리</label>
	<select name="name">
		<option value="unknown">--선택--</option>
		<c:forEach var="category" items="${categoryList}">
		<option value="${category.name}">${category.name}</option>
		</c:forEach>
	</select><br>
	<input type="submit" value="조회" />
	</form>
</body>
</html>