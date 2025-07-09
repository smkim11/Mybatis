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
	<h1>UPDATE</h1>
	<form method="post" action="/updateUser">
		<div>
			id:<input type="text" name="username" value="${userInfo.username }" readonly>
		</div>
		<div>
			phone:<input type="text" name="phone" value="${userInfo.phone }">
		</div>
		<div>
			email:<input type="text" name="email" value="${userInfo.email }">
		</div>
		<div>
			birth:<input type="date" name="birth" value="${userInfo.birth }">
		</div>
		<button type="submit">수정</button>
	</form>
	<a href="/deleteUser?username=${userInfo.username }">삭제</a>
</body>
</html>