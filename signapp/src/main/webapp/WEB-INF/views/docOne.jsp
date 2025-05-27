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
	<h1>문서</h1>
	<a href="/docView">리스트</a>
	<input type="hidden" id="signImg" value="${loginInfo.signImg}">
	<table border="1">
		<tr>
			<th rowspan="2">결제</th>
			<th>2</th>
			<th>3</th>
		</tr>
		<tr>
			<c:if test="${document.signLevel2 != null}">
				<td><img style="width:70px; height:70px" src="/sign_img/${document.signLevel2}" alt="서명 이미지"></td>
			</c:if>
			<c:if test="${document.signLevel2 == null}">
				<c:if test="${loginInfo.level == 2}">
					<td><button type=button id="signLevel2">결제</button></td>
				</c:if>
				<c:if test="${loginInfo.level != 2}">
					<td style="width:70px; height:70px"></td>
				</c:if>
			</c:if>
			<c:if test="${document.signLevel3 != null}">
				<td><img style="width:70px; height:70px" src="/sign_img/${document.signLevel3}" alt="서명 이미지"></td>
			</c:if>
			<c:if test="${document.signLevel3 == null}">
				<c:if test="${loginInfo.level == 3}">
					<td><button type=button id="signLevel3">결제</button></td>
				</c:if>
				<c:if test="${loginInfo.level != 3}">
					<td style="width:70px; height:70px"></td>
				</c:if>
			</c:if>
		</tr>
	</table>
	<table border="1">
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
			<td><textarea cols="50" rows="10">${document.content}</textarea></td>
		</tr>
	</table>
	<a href="/updateDoc?documentNo=${document.documentNo}">수정</a>
	<a href="/deleteDoc">삭제</a>
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