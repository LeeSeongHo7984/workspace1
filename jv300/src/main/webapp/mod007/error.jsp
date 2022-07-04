<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<style>
   h1 {
   color: red;
   }
</style>
<body>
<div id="wrapper">
   <div id="header">
      <jsp:include page="/incl/banner.jsp">
         <jsp:param name="subtitle" value='<%=URLEncoder.encode(\"mod007 : 에러가 발생했습니다.\",\"UTF-8\") %>'/>
      </jsp:include>
   </div>
   <div id="content-wrapper">
      <h3>다음과 같은 에러가 발생했습니다..</h3>
      <ul>
<%      
         @SuppressWarnings("unchekced")
         List<String> errorMsgs = (List<String>)request.getAttribute("errorMsgs");
         for(String errorMsg : errorMsgs) {
%>            
            <li><%=errorMsg %></li>
<%             
         }
%>         
      
      </ul>
   </div>
   <div id="footer">
      <%@ include file="/incl/footer.jsp"%>
   </div>
</div>
</body>
</html>