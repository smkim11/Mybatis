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
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>태그</th>
			<th>태그추가</th>
		</tr>
		<c:forEach var="b" items="${boardList }">
			<tr>
				<td>${b.boardNo }</td>
				<td>${b.title }</td>
				<td>${b.tag }</td>
				<td><a href="/addTag?boardNo=${b.boardNo }">태그추가</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>