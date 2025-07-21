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
	<h1>${boardNo }번글 해시태그추가</h1>
	해시태그 :
	<form method="post" action="/addTag" id="addForm">
		<input type="hidden" name="boardNo" value="${boardNo }">
		<textarea rows="2" cols="80" id="tags" name="tags">${tags }</textarea>
		<button type="button" id="btn">저장</button>
	</form>
	
<script>
	$('#btn').click(function(){
		let tags=$('#tags').val();
		// 정규표현식 사용해서 한글,영어,숫자,',' 제외하고 공백으로
		tags=tags.replace(/[^가-힣a-zA-Z0-9,]/g,'');
		alert(tags);
		
		
		$('#addForm').submit();
	});
</script>
</body>
</html>