<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>UpdatePw</h1>
	<form method="post" action="/updatePw" id="updateForm">
	<input type="hidden" name="id" id="id" value="${loginInfo.id }">
		<table border="1">
			<tr>
				<th>PrePw</th>
				<td><input type="password" name="prePw" id="prePw"></td>
			</tr>
			<tr>
				<th>NewPw</th>
				<td><input type="password" name="pw" id="pw"></td>
			</tr>
			<tr>
				<th>NewPw2</th>
				<td><input type="password" name="newPw" id="newPw"></td>
			</tr>
		</table>
		<button type="button" id="btn">변경</button>
	</form>
	
	<script>
		$('#pw').blur(function(){
			$.ajax({
				url:'/pwUse/'+$('#id').val()+'/'+$('#pw').val(),
				type:'get',
				success:function(data){
					if(data=='impos'){
						alert('이전에 사용한 비밀번호 입니다.');
						$('#pw').val('');
					}
				}
			});
		});
	
		$('#newPw').blur(function(){
			if($('#pw').val()!==$('#newPw').val()){
				alert('변경비밀번호가 일치하지 않습니다.');
				$('#pw').val('');
				$('#newPw').val('');
			}
		});
	
		$('#btn').click(function(){
			if($('#prePw').val() == '' || $('#pw').val() == ''  || $('#pw').val() == ''){
				alert('입력하지 않은 값이 있습니다.');
			}else{
				$('#updateForm').submit();
			}
		});
		
	</script>
</body>
</html>