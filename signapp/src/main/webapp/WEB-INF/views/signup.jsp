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
	<h1>회원가입</h1>
	<form method="post" action="/signup" id="signupForm">
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" id="id"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" id="pw"></td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td><input type="password" name="pw2" id="pw2"></td>
			</tr>
			<tr>
				<th>레벨</th>
				<td>
				<select id="level" name="level">
					<option>1</option>
					<option>2</option>
					<option>3</option>
				</select>
				</td>
			</tr>
		</table>
		<button type="button" id="btn">가입</button>
	</form>
	
	<script>
		$('#id').blur(function(){
			$.ajax({
				url:'/useId/'+$('#id').val()
				,type:'get'
				,success:function(data){
					if(data==='no'){
						alert('사용중인 아이디 입니다.');
						$('#id').val('');
					}
				}
			});
		});
		
		$('#pw').blur(function(){
			if($('#pw').val().length<4){
				alert('비밀번호는 4자리 이상이어야 합니다.');
				$('#pw').val('');
			}
		});
		
		$('#pw2').blur(function(){
			if($('#pw').val() !== $('#pw2').val()){
				alert('비밀번호를 확인해주세요.');
				$('#pw').val('');
				$('#pw2').val('');
			}
		});
		
		
		$('#btn').click(function(){
			if($('#name').val() != '' && $('#id').val() != '' 
			&& $('#pw').val() != '' && $('#pw2').val() != '' && $('#level').val() != ''){
				$('#signupForm').submit();
			}else{
				alert('입력하지않은 값이 있습니다.');
			}
		});
		
	</script>
</body>
</html>