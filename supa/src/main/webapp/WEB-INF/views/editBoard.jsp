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
	<h1>EDITBOARD</h1>
		<form method="post" action="/editBoard" id="editForm">
			<table border="1">
				<tr>
					<th>ID</th>
					<td><input type="text" name="id" value="${board.id}" readonly></td>
				</tr>
				<tr>
					<th>TITLE</th>
					<td><input type="text" name="title" value="${board.title}" id="title"></td>
				</tr>
			</table>
		<button id="btn">수정</button>
		</form>
</body>
<script>
	$('#btn').click(function(){
		if($('#title').val() === ''){
			alert('제목을 입력하세요.');
			return false;
		}else{
			$('#editForm').submit();
		}
	});
</script>
</html>