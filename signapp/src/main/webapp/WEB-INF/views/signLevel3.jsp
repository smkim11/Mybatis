<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- id: 싸인레벨이 되는 로그인 사용자 id -->
	<div id="id">id</div> <!-- <input type="text" id="id" value="manage"> -->
	<canvas style="border : 1px solid #000000"></canvas>
	<button type="button" id="btnClear">삭제</button>
	<button type="button" id="btnSign">결제</button>
	
	
	
	<script src="/js/signature_pad.umd.min.js"></script>
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
						id: $('#id').text()
						, signImg: signaturePad.toDataURL() // 인수 생략시 기본값은 PNG 이미지
					} // 로그인 사용자 id, signaturePad객체 안의 사인 이미지
				}).done(function(data){ // data = 결제 완료
					alert(data);
					// js로 페이지 이동 location.href='이동할 페이지'
				}).fail(function(){
					alert('결제 실패');
				});
			}
		});
	</script>
</body>
</html>