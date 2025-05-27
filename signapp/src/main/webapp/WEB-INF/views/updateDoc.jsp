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
<h1>문서 수정</h1>
<form method="post" action="/updateDoc" id="updateDocForm">
		<table border="1">
			<tr>
				<th>제목</th>
				<td><input type="text" id="title" name="title" value="${doc.title}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea cols="50" rows="10" id="content" name="content">${doc.content }</textarea></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" id="writer" name="writer" value="${doc.writer }" readonly></td>
			</tr>
		</table>
		<button type="button" id="btn">수정</button>
	</form>
</body>
<script>
	$('#btn').click(function(){
		if($('#title').val() != '' && $('#content').val() != '' && $('#writer').val() != ''){
			$('#updateDocForm').submit();
		}else{
			alert('입력하지않은 값이 있습니다.');
		}
	});
</script>
</html>