<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder" %>

<div style='padding: 30px; background-color: #f1f1f1;'id="banner">
   <h1><%=URLDecoder.decode(request.getParameter("subtitle"), "UTF-8") %></h1>
</div>