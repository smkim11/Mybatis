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
	<h1>예약금 결제</h1>
	<div>
	<form method="post" action="/pay">
		<input type="hidden" name="reservationNo" value="${reservationNo }"><br>
		예약금:<input type="text" name="amount" value="10000" readonly><br>
		결제:<select name="payMethod">
				<option value="신용카드">신용카드</option>
				<option value="카카오페이">카카오페이</option>
				<option value="토스페이">토스페이</option>
				<option value="네이버페이">네이버페이</option>
			</select>
		<button type="submit">결제</button>
	</form>
	</div>
</body>
</html>