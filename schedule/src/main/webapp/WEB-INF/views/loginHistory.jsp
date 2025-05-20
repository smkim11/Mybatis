<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>LoginHistory</h1>
	${loginInfo.id }님 반갑습니다.
	<a href="/logout">로그아웃</a>
	<table border="1">
		<tr>
			<th>NO</th>
			<th>ID</th>
			<th>LOGINDATE</th>
		</tr>
		<c:forEach var="list" items="${list }">
			<tr>
				<th>${list.no}</th>
				<th>${list.id}</th>
				<th>${list.logindate}</th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>