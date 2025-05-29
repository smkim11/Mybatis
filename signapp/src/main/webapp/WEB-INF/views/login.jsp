<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/css/signStyle.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="bg-light p-4">
	<div class="container bg-white p-4 rounded shadow-sm" style="max-width: 400px;">
		<h1 class="text-center mb-4">로그인</h1>
		<form method="post" action="/login" id="loginForm">
			<table class="table table-bordered">
				<tr>
					<th class="text-center align-middle">아이디</th>
					<td><input type="text" name="id" class="form-control"></td>
				</tr>
				<tr>
					<th class="text-center align-middle">비밀번호</th>
					<td><input type="password" name="pw" class="form-control"></td>
				</tr>
			</table>
			<div class="d-flex justify-content-between align-items-center mt-3">
				<!-- 로그인 버튼 -->
				<button type="button" id="btn" class="btn btn-success">로그인</button>
				<!-- 회원가입 링크 -->
				<a href="/signup" class="btn btn-link">회원가입</a>
			</div>
		</form>
	</div>

	<script>
		$('#btn').click(function(){
			$('#loginForm').submit();
		});
	</script>
</body>
</html>