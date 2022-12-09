<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<div style="margin-top: 150px;">
	<h1 style="text-align: center; font-size: 60px; ">로그인</h1>
	
	<form action="login" method="post"
		style="text-align: center;">
		
		<input type="text" name="userId" placeholder="아이디를 입력하세요" 
			style="text-align: center; margin-bottom: 10px; width: 300px; height: 30px;"/><br>
			
		<input type="password" name="passwd"  placeholder="비밀번호를 입력하세요" 
			style="text-align: center; margin-bottom: 10px; width: 300px; height: 30px;"/><br>
			
		<button value="submit" style="margin-top: 20px; width: 200px; height: 40px;">로그인</button>
	</form>	
	
		<button type="button" onclick="location.href='/addUser';" 
			style="margin-top: 20px; margin-left: 532px; width: 200px; height: 40px;">회원가입</button>
			
	</div>
		
</body>
</html>