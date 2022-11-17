<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js" integrity="sha512-3j3VU6WC5rPQB4Ld1jnLV7Kd5xr+cq9avvhwqzbH/taCRNURoeEpoPBK9pDyeukwSxwRPJ8fDgvYXd6SkaZ2TA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<!-- 제이쿼리 쿠키 사용 (프론트단에서 유용)-->
<script type="text/javascript">
	
	$(function(){
		
		fn_lojin();
		fn_displayRememberId();
	});
	
	function fn_lojin(){
		
		$('#frm_login').submit(function(ev){
			
			if($('#id').val() == '' || $('#pw').val() == ''){
				alert('아이디와 패스워드 모두 입력하세요');
				ev.preventDefault();
				return;
			}
			if($('#rememberId').is(':checked')){
				//제이쿼리 쿠키 사용
				//      쿠키이름(변수)  쿠키에 넣을값(값)
				$.cookie('rememberId', $('#id').val());
			} else{
				$.cookie('rememberId', '');
			}
			
				
		});
	}
	
	function fn_displayRememberId(){
		
		let rememberId = $.cookie('rememberId');
		if(rememberId == ''){
			$('#id').val('');
			$('#rememberId').prop('checked', false);
		} else{
			$('#id').val(rememberId);
			$('#rememberId').prop('checked', true);
		}
		
	}
	
</script>
</head>
<body>

	<div>
	
		<h1>로그인</h1>
		
		<form id="frm_login" action="${contextPath}/user/login" method="post">
			
			<input type="hidden" name="url" value="${url}">
			
			<div>
				<label for="id">아이디</label>
				<input type="text" name="id" id="id">
			</div>
			
			<div>
				<label for="pw">비밀번호</label>
				<input type="password" name="pw" id="pw">
			</div>
			
			<div>			
				<button>로그인</button>
			</div>
			
			<div>			
				<label for="rememberId">
					<input type="checkbox" id="rememberId">
					아이디 저장
				</label>
				<label for="keepLogin">
					<input type="checkbox" name="keepLogin" id="keepLogin">
					<!-- 로그인 유지 저장 할 때는 cookie와 DB 두 곳에 보관하여야 한다.
						cookie과 DB의 SESSIONID를 비교해서 값이 맞으면 유지가 되도록 만들어야한다.
					 -->
					로그인 유지
				</label>
			</div>
		
		</form>
			
		<div>
			<a href="${contextPath}/user/findId">아이디 찾기</a> | 
			<a href="${contextPath}/user/findPw">비밀번호 찾기</a>
		</div>
	
	</div>
	
</body>
</html>