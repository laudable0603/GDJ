<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script src="${contextPath}/resources/js/agree.js"></script>
<link rel="stylesheet" href="${contextPath}/resources/css/agree.css">
</head>
<body>
	
	<div>
	
		<h1>약관 동의하기</h1>
		
		<form id="frm_agree" action="${contextPath}/user/join/write">
		
			<div>
				<input type="checkbox" id="check_all" class="blind">
				<label for="check_all" class="lbl_all stop-dragging"> 모두동의 </label>
			</div>
			
			<hr>
			
			<div>
				<input type="checkbox" id="service" class="check_one blind">
				<label for="service" class="lbl_one stop-dragging">이용약관 동의(필수)</label>
				<div>
					<textarea readonly >본 약관은 ...</textarea>
				</div>
			</div>
			
			<div>
				<input type="checkbox" id="privacy" class="check_one blind">
				<label for="privacy" class="lbl_one stop-dragging">개인정보수집 동의(필수)</label>
				<div>
					<textarea readonly >개인정보 보호법에 따라 ...</textarea>
				</div>
			</div>
			
			<div>
				<input type="checkbox" id="location" name="location" class="check_one blind">
				<label for="location" class="lbl_one stop-dragging">위치정보수집 동의(선택)</label>
				<div>
					<textarea readonly >위치정보 ...</textarea>
				</div>
			</div>
			
			<div>
				<input type="checkbox" id="promotion" name="promotion" class="check_one blind" >
				<label for="promotion" class="lbl_one stop-dragging">마케팅 동의(선택)</label>
				<div>
					<textarea readonly >이벤트 ...</textarea>
				</div>
			</div>
			
			<hr>
			
			<div>
				<input type="button" value="취소" onclick="history.back();">
				<button>다음</button>
			</div>
		
		</form>
	</div>
	
</body>
</html>