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
	<h1>BOARDLIST</h1>
	<a href="/addBoard">추가</a>
	<table border="1">
		<tr>
			<th>TITLE</th>
			<th>CREATEAT</th>
			<th>EDIT</th>
			<th>DELETE</th>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.title }</td>
				<td>${list.createAt }</td>
				<td><a href="/editBoard?id=${list.id }">수정</a></td>
				<td><a href="/deleteBoard?id=${list.id }">삭제</a></td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>