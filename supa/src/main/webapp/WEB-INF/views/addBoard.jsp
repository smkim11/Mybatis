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
	<h1>ADDBOARD</h1>
	<form method="post" action="/addBoard" id="addForm">
		<table border="1">
			<tr>
				<th>TITLE</th>
				<td><input type="text" name="title" id="title"></td>
			</tr>
		</table>
		<button id="btn">추가</button>
	</form>
</body>
<script>
	$('#btn').click(function(){
		if($('#title').val() === ''){
			alert('제목을 입력하세요.');
			return false;
		}else{
			$('#addForm').submit();
		}
	});
</script>
</html>