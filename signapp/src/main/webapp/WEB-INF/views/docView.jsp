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
${loginInfo.name}님 
<a href="/logout">로그아웃</a>
	<table border="1">
		<tr>
			<td><a href="">결제1</a></td><!-- Level 3 -->
			<td><a href="/signLevel3">결제2</a></td><!-- Level 2 -->
		</tr>
	</table>
	
	<div>
		문서내용 <!-- Level 1 -->
	</div>
	<table border="1">
		<tr>
			<th>문서번호</th>
			<th>제목</th>
			<th>작성자</th>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td><a href="/docOne?documentNo=${list.documentNo }">${list.documentNo }</a></td>
				<td>${list.title }</td>
				<td>${list.writer }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>