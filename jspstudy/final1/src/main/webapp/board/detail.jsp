<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>${board.boardlistNo}번 게시글</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	
	$(document).ready(function(){
		$('#frm_sub').submit(function(ev){
			if($('#writer').val() == ''){
				alert('작성자는 필수입니다.');
				$('#writer').focus();
				ev.preventDefault();
				return;
			}
			
			if($('#title').val() == ''){
				alert('제목은 필수입니다.');
				$('#title').focus();
				ev.preventDefault();
				return;
			}
		});
		
		$('#btn_remove').click(function(ev){
			if(confirm('게시글을 삭제할까요?')){
				location.href = '${contextPath}/board/remove.do?boardlistNo=${board.boardlistNo}';
			} else {
				alert('취소되었습니다.');
			}
		});
		
		$('#btn_list').click(function(event){
			location.href = '${contextPath}/board/list.do';
		});
		
	});
	
</script>
</head>
<body>
	<form id="frm_sub" action="${contextPath}/board/modify.do" method="POST">
			<table border="1">
				<tbody>
					<tr>
						<td>
							순번
						</td>
						<td>
							<input type="text" name="boardlistNo" value="${board.boardlistNo}" readonly>
						</td>
					</tr>
					<tr>
						<td><label for="writer">작성자</label></td>
						<td>${board.writer}</td>
					</tr>		
					<tr>
						<td><label for="title">제목</label></td>
						<td><input type="text" id="title" name="title" value="${board.title}"></td>
					</tr>			
					<tr>
						<td><label for="content">내용</label></td>
						<td><textarea id="content" name="content" rows="5" cols="30" >${board.content}</textarea></td>
					</tr>			
					<tr>
						<td colspan="2">
							<input type="submit" value="수정">
							<input type="button" value="목록" id="btn_list">
							<input type="button" value="삭제" id="btn_remove">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
</body>
</html>