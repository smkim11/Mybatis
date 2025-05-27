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
	
	<h1>문서 리스트</h1>
	<c:if test="${loginInfo.level == 1 }">
		<a href="/addDoc">문서작성</a>
	</c:if>
	<table border="1">
		<tr>
			<th>문서번호</th>
			<th>제목</th>
			<th>작성자</th>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.documentNo }</td>
				<td><a href="/docOne?documentNo=${list.documentNo }">${list.title }</a></td>
				<td>${list.writer }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>