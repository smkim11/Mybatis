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
	<c:if test="${loginUsername!='anonymousUser'}">
		<div>
			사용자이름: ${loginUsername}
		</div>
		<div>
			<a href="/logout">로그아웃</a>
			<a href="/updateUser?username=${loginUsername}">회원정보수정</a>
		</div>
	</c:if>
	<c:if test="${loginUsername=='anonymousUser'}">
		<div>
			<a href="/addUser">회원가입</a>
			<a href="/login">로그인</a>
		</div>
	</c:if>
</body>
</html>