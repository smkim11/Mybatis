<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>HOME</h1>
	<c:if test="${name == 'anonymousUser' }">
		<a href="/login">로그인</a>
	</c:if>
	<c:if test="${name != 'anonymousUser' }">
		${name }님 반갑습니다.<br>
		<a href="/myPage">마이페이지</a>
	</c:if>
</body>
</html>