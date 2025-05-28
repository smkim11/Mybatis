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
<h1>문서 삭제</h1>
<form method="post" action="/deleteDoc" id="deleteDocForm">
	<table border="1">
	<input type="hidden" name="writer" value="${writer}">
	<input type="hidden" name="documentNo" value="${documentNo}">
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pw" id="pw"></td>
		</tr>
	</table>
	<button type="button" id="btn">삭제</button>
</form>

<script>
	$('#btn').click(function(){
		if($('#pw').val() != ''){
			$('#deleteDocForm').submit();
		}else{
			alert('비밀번호를 입력하세요.');
		}
	
	});
</script>
</body>
</html>