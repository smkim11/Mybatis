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
       background-color: #f9f9f9;
       padding: 40px;
       color: #333;
   }

   h1 {
       text-align: center;
       margin-bottom: 30px;
       color: #2c3e50;
   }

   form {
       background-color: #fff;
       padding: 25px 30px;
       border-radius: 12px;
       max-width: 500px;
       margin: 0 auto;
       box-shadow: 0 2px 12px rgba(0,0,0,0.08);
   }

   form div {
       display: flex;
       flex-direction: column;
       gap: 15px;
   }

   input[type="text"],
   input[type="number"],
   select {
       padding: 10px;
       font-size: 14px;
       border: 1px solid #ccc;
       border-radius: 6px;
       width: 100%;
       box-sizing: border-box;
   }

   input[readonly] {
       background-color: #f1f1f1;
       color: #666;
   }

   button {
       background-color: #ff6b6b;
       color: white;
       border: none;
       padding: 10px 18px;
       font-size: 15px;
       border-radius: 6px;
       cursor: pointer;
       margin-top: 20px;
       transition: background-color 0.2s ease;
   }

   button:hover {
       background-color: #ff4e4e;
   }
</style>
</head>
<body>
	<h1>테이블 예약</h1>
	<form method="post" action="/reservation" id="reservationForm">
	<input type="hidden" name="roomNo" id="roomNo" value="${reservation.roomNo }">
	<input type="hidden" name="provider" id="provider" value="${reservation.provider }">
		<div>
			이름:<input type="text" name="reservationName" id="reservationName"><br>
			전화번호:<input type="text" name="reservationId" id="reservationId" value="${reservation.reservationId }" readonly><br>
			날짜:<input type="text" name="reservationDate" id="reservationDate" value="${reservation.reservationDate }" readonly><br>
			시간:<input type="text" name="reservationOption" id="reservationOption" value="${reservation.reservationOption }" readonly><br>
			인원수:<input type="number" name="reservationCount" id="reservationCount" value="1" min="1" max="${limit }">
		</div>
		<button id="btn">예약</button>
	</form>
	
</body>
<script>
	$('#btn').click(function(){
		if($('#reservationName').val() === '' || $('#reservationCount').val() === ''){
			alert('입력하지 않은 값이 있습니다.');
		}else{
			
			$('#reservationForm').submit();
		}
	});
</script>
</html>