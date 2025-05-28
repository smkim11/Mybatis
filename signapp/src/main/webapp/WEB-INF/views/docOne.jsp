<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/css/signStyle.css">
</head>
<body class="bg-light p-4">
<div class="container bg-white p-4 rounded shadow-sm">
	<h1 class="mb-4">문서</h1>
	<div id="errorMsg" class="text-danger mb-3">${msg}</div>
	<a href="/docView" class="btn btn-secondary btn-sm mb-4">리스트</a>
	<input type="hidden" id="signImg" value="${loginInfo.signImg}">
	<!-- 결제 테이블 감싸는 div 추가 -->
<div class="approval-table-wrapper">
	<table class="table table-bordered text-center align-middle mb-4 approval-table" id="approvalTable">
		<tr>
			<th rowspan="2">결제</th>
			<th>Level 2</th>
			<th>Level 3</th>
		</tr>
		<tr>
			<c:if test="${document.signLevel2 != null}">
				<td class="signature-cell"><img class="signature-img" src="/sign_img/${document.signLevel2}" alt="서명 이미지"></td>
			</c:if>
			<c:if test="${document.signLevel2 == null}">
				<c:if test="${loginInfo.level == 2}">
					<td class="signature-cell"><button type=button id="signLevel2" class="btn btn-outline-success">결제</button></td>
				</c:if>
				<c:if test="${loginInfo.level != 2}">
					<td class="signature-cell"></td>
				</c:if>
			</c:if>
			<c:if test="${document.signLevel3 != null}">
				<td class="signature-cell"><img class="signature-img" src="/sign_img/${document.signLevel3}" alt="서명 이미지"></td>
			</c:if>
			<c:if test="${document.signLevel3 == null}">
				<c:if test="${loginInfo.level == 3}">
					<td class="signature-cell"><button type=button id="signLevel3" class="btn btn-outline-success">결제</button></td>
				</c:if>
				<c:if test="${loginInfo.level != 3}">
					<td class="signature-cell"></td>
				</c:if>
			</c:if>
		</tr>
	</table>
</div>


	<table class="table table-bordered" id="documentDetailTable">
		<tr>
			<th>문서 번호</th>
			<td><span id="documentNo">${document.documentNo }</span></td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${document.title }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${document.writer }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea class="form-control" cols="50" rows="10" readonly>${document.content}</textarea></td>
		</tr>
	</table>

	<!-- 작성자만 수정 삭제 가능 -->
	<a href="/updateDoc?documentNo=${document.documentNo}" class="btn btn-primary btn-sm me-2">수정</a>
	<a href="/deleteDoc?documentNo=${document.documentNo}&writer=${document.writer }" class="btn btn-danger btn-sm">삭제</a>
</div>

<script>
	$('#signLevel2').click(function(){
		$.ajax({
			url:'/signLevel2/'+$('#signImg').val()+'/'+$('#documentNo').text(),
			type:'post',
			success: function(){
				location.reload();
			}
		});
	});
	
	$('#signLevel3').click(function(){
		$.ajax({
			url:'/signLevel3/'+$('#signImg').val()+'/'+$('#documentNo').text(),
			type:'post',
			success: function(){
				location.reload();
			}
		});
	});
</script>
</body>
</html>