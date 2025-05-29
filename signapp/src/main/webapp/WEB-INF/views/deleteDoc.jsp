<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/css/signStyle.css">
<meta charset="UTF-8">
<title>문서 삭제</title>
</head>
<body>
<div class="container mt-5">
	<h1 class="mb-4">문서 삭제</h1>
	<form method="post" action="/deleteDoc" id="deleteDocForm" class="border p-4 rounded bg-light shadow-sm" style="max-width: 400px; margin:auto;">
		<input type="hidden" name="writer" value="${writer}">
		<input type="hidden" name="documentNo" value="${documentNo}">
		
		<div class="mb-3">
			<label for="pw" class="form-label fw-bold">비밀번호</label>
			<input type="password" class="form-control" name="pw" id="pw" placeholder="비밀번호를 입력하세요">
		</div>
		
		<div class="text-center">
			<button type="button" class="btn btn-danger btn-sm w-25" id="btn">삭제</button>
		</div>
	</form>
</div>
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