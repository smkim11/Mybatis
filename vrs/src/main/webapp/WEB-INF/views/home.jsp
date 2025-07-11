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
    }

    h1 {
        text-align: center;
        margin-bottom: 30px;
        color: #333;
    }

    form {
        background-color: #fff;
        padding: 20px 30px;
        border-radius: 10px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        max-width: 600px;
        margin: 0 auto 30px auto;
    }

    form div {
        display: flex;
        align-items: center;
        gap: 10px;
        flex-wrap: wrap;
    }

    input[type="date"], select {
        padding: 8px 10px;
        border: 1px solid #ccc;
        border-radius: 6px;
        font-size: 14px;
    }

    button[type="submit"] {
        background-color: #ff6b6b;
        color: white;
        border: none;
        padding: 8px 16px;
        font-size: 14px;
        border-radius: 6px;
        cursor: pointer;
    }

    button[type="submit"]:hover {
        background-color: #ff4e4e;
    }

    .room-list-container {
	    display: grid;
	    grid-template-columns: repeat(4, 1fr);
	    gap: 20px;
	    justify-items: center;
	}
	
	.room-list-container > div {
	    background-color: #fff;
	    border-radius: 10px;
	    padding: 20px;
	    width: 220px;
	    box-shadow: 0 2px 8px rgba(0,0,0,0.08);
	    text-align: center;
	    font-size: 15px;
	}


    .room-list-container a {
        display: inline-block;
        margin-top: 10px;
        background-color: #4CAF50;
        color: white;
        text-decoration: none;
        padding: 6px 12px;
        border-radius: 6px;
        font-size: 14px;
    }

    .room-list-container a:hover {
        background-color: #43a047;
    }

    .room-list-container .예약불가 {
        color: #999;
    }
</style>
</head>
<body>
	<h1>테이블 예약</h1>
	<form method="post" action="/searchTable">
		<div>
			예약날짜:<input type="date" name="reservationDate" value=${date }> 
			<c:if test="${option == 'AM' }">
				시간:<select name="reservationOption">
						<option value="AM" selected="selected">오전</option>
						<option value="PM">오후</option>
					</select>
			</c:if>
			<c:if test="${option == 'PM' }">
				시간:<select name="reservationOption">
						<option value="AM">오전</option>
						<option value="PM" selected="selected">오후</option>
					</select>
			</c:if>
			<c:if test="${option == null }">
				시간:<select name="reservationOption">
						<option value="AM">오전</option>
						<option value="PM">오후</option>
					</select>
			</c:if>
			<button type="submit">검색</button>
		</div>
	</form>
	<div class="room-list-container">
		<c:forEach var="list" items="${reservationList}">
			<c:if test="${list.status == '예약가능' }">
				<div>
					<a href="/reservation?date=${date}&option=${option}&roomNo=${list.roomNo}&roomLimit=${list.roomLimit}">${list.roomName} ${list.status}</a>
				</div>
			</c:if>
			<c:if test="${list.status == '예약불가' }">
				<div>
					${list.roomName} ${list.status}
				</div>
			</c:if>
		</c:forEach>
	</div>
</body>
</html>