<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="/js/signature_pad.umd.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/css/signStyle.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="bg-light p-4">
	<div class="container bg-white p-4 rounded shadow-sm" style="max-width: 600px;">
		<h1 class="text-center mb-4">회원가입</h1>
		<form method="post" action="/signup" id="signupForm">
			<table class="table table-bordered align-middle">
				<tr>
					<th class="text-center">이름</th>
					<td><input type="text" name="name" id="name" class="form-control"></td>
				</tr>
				<tr>
					<th class="text-center">아이디</th>
					<td><input type="text" name="id" id="id" class="form-control"></td>
				</tr>
				<tr>
					<th class="text-center">비밀번호</th>
					<td><input type="password" name="pw" id="pw" class="form-control"></td>
				</tr>
				<tr>
					<th class="text-center">비밀번호확인</th>
					<td><input type="password" name="pw2" id="pw2" class="form-control"></td>
				</tr>
				<tr>
					<th class="text-center">레벨</th>
					<td>
						<select id="level" name="level" class="form-select">
							<option>1</option>
							<option>2</option>
							<option>3</option>
						</select>
					</td>
				</tr>
				<tr>
				    <th class="text-center">서명</th>
				    <td>
				        <canvas id="signCanvas" width="500" height="200" style="border: 1px solid #000000; width: 100%;"></canvas>
				        <div class="mt-2 d-flex gap-2">
				            <button type="button" id="btnClear" class="btn btn-secondary btn-sm">삭제</button>
				            <button type="button" id="btnSign" class="btn btn-primary btn-sm">등록</button>
				        </div>
				        <input type="hidden" id="signImg" name="signImg">
				    </td>
				</tr>
			</table>
			<div class="text-center">
				<button type="button" id="btn" class="btn btn-success">가입</button>
			</div>
		</form>
	</div>
	<script>
		// 캔버스에 사인 후 객체로 받는 SignaturePad 생성자
		// SignaturePad API설명은 https://github.com/szimek/signature_pad 페이지 readme파일 참고
		const signaturePad = new SignaturePad($('canvas')[0], {
			  minWidth: 2,
		      maxWidth: 2,
		      penColor: 'rgb(0, 0, 0)'
		});
		
		// 캔버스 내용 초기화하는 clear()메소드
		$('#btnClear').click(function(){
			signaturePad.clear();
		});
		
		// ajax로 SignaturePad 객체안 사인이미지를 서버로 전송
		$('#btnSign').click(function(){
			if(signaturePad.isEmpty()){
				alert('사인을 해주세요.');
			}else{
				$.ajax({
					asyn : true, // true면 비동기(백그라운드로 실행)
					url: '/addSign',
					type: 'post',
					data: {
						id: $('#id').val()
						, signImg: signaturePad.toDataURL() // 인수 생략시 기본값은 PNG 이미지
					} // 로그인 사용자 id, signaturePad객체 안의 사인 이미지
				}).done(function(data){ // data = 결제 완료
					$('#signImg').val(data);
					// js로 페이지 이동 location.href='이동할 페이지'
				}).fail(function(){
					alert('저장 실패');
				});
			}
		});
	
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