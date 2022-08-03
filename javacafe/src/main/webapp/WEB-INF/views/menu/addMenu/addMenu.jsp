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
	<h3>메뉴추가</h3>
	<form action="addMenu" method="post">
		<label>추가하실 메뉴를 입력하세요 : </label><input type="text"  name="name"><br>
		<label>추가하실 메뉴의 가격을 입력하세요 : <input type="text"  name="price"></label><br>
		<label>추가하실 메뉴의 카테고리를 입력하세요 : <input type="text"  name="categoryName"></label><br>
		<input type="submit" value="추가"/>
	</form>
</body>
</html>