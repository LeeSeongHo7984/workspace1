<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, java.net.URLEncoder" %>
       <!-- 변수 설정 영역-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- errorMsgs 리스트 가져와서 for문 돌려서 출력 -->
<h3>회원가입 실패</h3>
<div id="wrapper">
   <div id="header">
      <jsp:include page="/incl/banner.jsp">
         <jsp:param name="subtitle" value="<%=URLEncoder.encode(\"mod007 : 자바빈즈\", \"UTF-8\") %>"/>
      </jsp:include>
   </div>
   <div id="content-wrapper">
      <h4>error</h4>
   <%
   List<String> errorMsgs = (List<String>)request.getAttribute("errorMsgs");
   %>
   <%
      for(String x : errorMsgs){
   %>
   <%=
      x
   %><br>
   <%
   } 
   %>
   </div>
   <div id="footer">
      <%@ include file="/incl/footer.jsp" %>
   </div>
</div>

</body>
</html>