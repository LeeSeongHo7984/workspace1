<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.net.URLEncoder"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>JavaCafe</title>
	<link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/blog/">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/main.css'/>"/>
    
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap" rel="stylesheet">
  </head>
  <body>
    
<header class="blog-header py-3">
    <div class="row flex-nowrap justify-content-between align-items-center">
      <div class="col-4 text-center">
        <a class="blog-header-logo text-dark" href="/javacafe/home/homePage" style="margin-left: 50px;">JavaCafe</a>
      </div>
      <div class="col-4 d-flex justify-content-end align-items-center">
        <a class="btn btn-sm btn-outline-secondary" onClick="location.href='/javacafe/auCategory'" style="font-weight: bold; font-size: 16px; margin-left: 1250px;">Category(관리자)</a>
      </div>
      <div class="col-4 d-flex justify-content-end align-items-center">
        <a class="btn btn-sm btn-outline-secondary" onClick="location.href='/javacafe/auMenu'" style="font-weight: bold; font-size: 16px;">Menu(관리자)</a>
      </div>
    </div>
  </header>
  
  	<div style="font-size: 50px; margin-top: 50px; text-align: center; font-weight: bold;">
  	<span>메뉴 추가</span>
  	</div>
	<form action="addMenu" method="post" style="text-align: center; font-size: 25px; margin-top: 30px;">
		<label>추가하실 메뉴의 카테고를 선택하세요</label><br>
		<select name="categoryName" style=" margin-top: 50px; margin-bottom: 50px; width: 500px; height: 50px; text-align: center; 
			background-color: black; color: white; font-weight: bold; font-size: 15px;"> <!-- 도메인에 변수명이랑 같아야함 -->
				<option value="unknown" disabled selected="selected">--선택--</option>
					<c:forEach var="category" items="${categoryList}">
				<option value="${category.name}">${category.name}</option>
			</c:forEach>
		</select><br>
		<label>추가하실 메뉴를 입력하세요</label><br>
		<input type="text"  name="name" style="margin-top: 20px; height: 50px; width: 300px; margin-bottom: 20px; text-align: center;"><br>
		<label>추가하실 메뉴의 가격을 입력하세요</label><br>
		<input type="text"  name="price" style="margin-top: 20px; height: 50px; width: 300px; margin-bottom: 20px; text-align: center;"><br>
		<label>추가하실 메뉴의 사진을 넣어주세요</label>
		<input type="submit" value="추가" class="btn btn-lg btn-secondary" style="margin: 0 auto; text-align: center; display: block;
		margin-top: 30px; width: 250px;"/>
	</form>
	
	<!-- FOOTER -->
  <footer class="blog-footer" style="transform: translateY(30%); ">
  <p>Blog template built for <a href="https://getbootstrap.com/">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
  <p>
    <a href="#">Back to top</a>
  </p>
</footer>
</body>
</html>

