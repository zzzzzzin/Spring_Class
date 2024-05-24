<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">
</head>
<body>
    
    <!-- accesserror.jsp -->
	<%@include file="/WEB-INF/views/inc/header.jsp" %>
	
	<h2>Access Denied Page</h2>
	
	<div>접근할 권한이 없습니다.</div>
    
    <div>접근: ${auth}</div>
    
    <div>${SPRING_SECURITY_403_EXCEPTION.getMessage()}</div>
    
</body>
</html>