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
	<h1>테이블 예약1</h1>
	<div>
		예약날짜:<input type="date" name="reservationDate"> 
		시간<select name="reservationOption">
				<option value="AM">오전</option>
				<option value="PM">오후</option>
			</select>
	</div>
</body>
</html>