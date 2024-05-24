<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">
</head>
<body>
	
	<!-- index.jsp -->
	
	<%@include file="/WEB-INF/views/inc/header.jsp" %>
	
	<h2>Index Page</h2>
	
	<div>모든 사용자가 접근 가능합니다.</div>
	
	<div class="message">
		<sec:authentication property="principal"/>
	</div>
	
</body>
</html>









