<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board.board_no}번 게시글</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		
		var frm = $('#frm_btn'); //성능 개선을 위해 작성
		
		//편집화면으로 이동
		$('#btn_edit').click(function(){ //하나의 폼에 여러가지 서브밋을 달기위해 작성
			frm.attr('action', '${contextPath}/brd/edit');
			frm.submit();
			return;
		});
		
		//삭제
		$('#btn_remove').click(function(){ //하나의 폼에 여러가지 서브밋을 달기위해 작성
			if(confirm('삭제할까요?')){
				frm.attr('action', '${contextPath}/brd/remove');
				frm.submit();
				return;
			}
			
		});
		
		// 목록
		$('#btn_list').click(function(){
			location.href = '${contextPath}/brd/list';
		});
	});
</script>
</head>
<body>
		
	<ul>
		<li>글번호 : ${board.board_no}</li>
		<li>제목 : ${board.title}</li>
		<li>작성자 : ${board.writer}</li>
		<li>작성일 : ${board.create_date}</li>
		<li>수정일 : ${board.modify_date}</li>
	</ul>
	<div>
		${board.content}
	</div>
	
	<hr>
	
	<div>
		<form  id="frm_btn" method="post">
			<input type="hidden" name="board_no" value="${board.board_no}"> <!-- 삭제할 게시글 번호를 보내주기 위해 히든 작성 -->
			<input type="button" value="편집" id="btn_edit">
			<input type="button" value="삭제" id="btn_remove">
			<input type="button" value="목록" id="btn_list">
		</form>
	</div>
	
</body>
</html>