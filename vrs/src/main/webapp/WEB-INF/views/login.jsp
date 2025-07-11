<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		font-family: 'Helvetica Neue', sans-serif;
		background-color: #f7f7f7;
		padding: 40px;
		margin: 0;
		color: #333;
		display: flex;
		flex-direction: column;
		align-items: center;
		height: 100vh;
	}

	h1 {
		margin-bottom: 40px;
		color: #2c3e50;
	}

	.naver {
		display: inline-block;
		background-color: #03C75A;
		color: white;
		text-decoration: none;
		padding: 12px 24px;
		font-size: 16px;
		border-radius: 6px;
		font-weight: bold;
		box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
		transition: background-color 0.3s;
	}

	.naver:hover {
		background-color: #02b553;
	}
</style>
</head>
<body>
<h1>식당 예약</h1>
	<div>
		<a class="naver" href="/oauth2/authorization/naver">네이버 로그인</a>
	</div>
</body>
</html>