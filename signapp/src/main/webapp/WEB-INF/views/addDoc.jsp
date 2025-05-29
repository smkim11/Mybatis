<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/css/signStyle.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container mt-5">
	<h1 class="mb-4">문서작성</h1>
	<form method="post" action="/addDoc" id="addDocForm" class="border p-4 rounded bg-light shadow-sm">
		<div class="mb-3">
			<label for="title" class="form-label fw-bold">제목</label>
			<input type="text" class="form-control" id="title" name="title">
		</div>
		<div class="mb-3">
			<label for="content" class="form-label fw-bold">내용</label>
			<textarea cols="50" rows="10" class="form-control" id="content" name="content"></textarea>
		</div>
		<div class="mb-3">
			<label for="writer" class="form-label fw-bold">작성자</label>
			<input type="text" class="form-control" id="writer" name="writer" value="${loginInfo.name }">
		</div>
		<div class="text-center mt-3">
			<button type="button" class="btn btn-primary btn-sm w-25 d-inline-block" id="btn">작성</button>
		</div>
	</form>
</div>
	
<script>
	$('#btn').click(function(){
		if($('#title').val() != '' && $('#content').val() != '' && $('#writer').val() != ''){
			$('#addDocForm').submit();
		}else{
			alert('입력하지않은 값이 있습니다.');
		}
	});
</script>
</body>
</html>