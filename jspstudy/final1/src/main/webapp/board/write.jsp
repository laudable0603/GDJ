<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		$('#frm_write').submit(function(ev){
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
		
		$('#btn_list').click(function(ev){
			location.href = '${contextPath}/board/list.do';
		});
	});
</script>
</head>
<body>
	<form id="frm_write" action="${contextPath}/board/add.do" method="POST">
		<table border="1">
			<tbody>
				<tr>
					<td><label for="writer">작성자</label></td>
					<td><input type="text" id="writer" name="writer"></td>
				</tr>		
				<tr>
					<td><label for="title">제목</label></td>
					<td><input type="text" id="title" name="title"></td>
				</tr>			
				<tr>
					<td><label for="content">내용</label></td>
					<td><textarea id="content" name="content" rows="5" cols="30"></textarea></td>
				</tr>			
				<tr>
					<td colspan="2">
						<input type="submit" value="등록">
						<input type="button" value="목록" id="btn_list">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>