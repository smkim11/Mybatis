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
	<h1>문서</h1>
	<table border="1">
		<tr>
			<th>2</th>
			<th>3</th>
		</tr>
		<tr>
			<td><a href="/signLevel3">결제</a></td>
			<td><a href="/signLevel3">결제</a></td>
		</tr>
	</table>
	<table border="1">
		<tr>
			<th>문서 번호</th>
			<td>${document.documentNo }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${document.title }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${document.writer }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="10" rows="10">${document.content}</textarea></td>
		</tr>
	</table>
</body>
</html>