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
	<h1>addUser</h1>
	<form method="post" action="/addUserAction">
		<div>
			id:<input type="text" name="username">
		</div>
		<div>
			pw:<input type="password" name="password">
		</div>
		<div>
			phone:<input type="text" name="phone">
		</div>
		<div>
			email:<input type="text" name="email">
		</div>
		<div>
			birth:<input type="date" name="birth">
		</div>
		<button type="submit">회원가입</button>
	</form>
</body>
</html>