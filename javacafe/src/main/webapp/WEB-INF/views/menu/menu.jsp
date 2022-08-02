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
	<form:form method="post" modelAtrribute="customer">
	<label>카테고리</label>
	<form:select path="menu">
		<form:option value="unknown">--선택--</form:option>
		<form:options itemValue="menuHost"
					  itemLabel="menuCode"
					  items="${menuProviderList }" />
	</form:select><br>
	<input type="submit" value="조회" />
	</form:form>
</body>
</html>