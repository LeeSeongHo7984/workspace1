<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post"> <%-- 1. action이 login이니까 class명 위에 login 적힌 서블릿으로 가야함 --%>
		아이디 : <input type="text" name="userId"/><br> <%-- 2. name값은 나중에 서블릿에서 getPrameter로 받아올거임 --%>
		비밀번호 : <input type="password" name="passwd"/><br>
		<input type="submit" value="로그인"/>
	</form>
</body>
</html>