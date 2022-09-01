<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌생성</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
</head>
<body>
<h3>신규계좌</h3>
   <form action="addAccount" method="post">
      <label>계좌번호: </label>${account.accountNum}<br>
      <label>계좌타입: </label>${account.accType}<br>
      <label>아이디: </label>${account.customerId}<br>
   </form>
</body>
</html>