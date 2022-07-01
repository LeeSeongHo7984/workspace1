<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action="add_user.do" method="post">
   회원 아이디: <input type="text" name="userId"><br>
   비밀번호 : <input type="password" name="passwd"><br>
   이름 : <input type="text" name="userName"><br>
   주민번호 : <input type="text" name="ssn"  placeholder="앞자리 6자리"><br>
   이메일 : <input type="text" name="email1">
   <select name="email2">
            <option>이메일 선택</option>
            <option>naver.com</option>
            <option>nate.com</option>
            <option>daum.net</option>
            <option>gmail.com</option>
         </select>
         <br>
   주소 : <input type="text" name="addr1"><input type="text" name="addr2">
   <br><input type="submit" value="회원가입">
   </form>
</body>
</html>