<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>

<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
		$('#btn_write').click(function(ev){
			location.href = '${contextPath}/board/write.do'
		})
	})
</script>
</head>
<body>

	<table border="1">
	<caption>총 게시글 :${count}개</caption>
		<thead>
			<tr>
				<th>순번</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${count eq 0}">
				<tr>
					<td colspan="4">게시물이 없습니다.</td>
				</tr>
				<tr>
					<td colspan="4"><button id="btn_write">새글작성</button></td>
				</tr>
			</c:if>
			<c:if test="${count ne 0}">
				<c:forEach items="${boards}" var="b">
					<tr>
						<td>${b.boardlistNo}</td>
						<td>${b.writer}</td>
						<td><a href="${contextPath}/board/detail.do?boardlistNo=${b.boardlistNo}">${b.title}</a></td>
						<td>${b.createDate}</td>
					<tr>
				</c:forEach>
					<tr>
						<td colspan="4"><button id="btn_write">새글작성</button></td>
					</tr>
			</c:if>
		</tbody>
	</table>
	
	
	
	
	
	

</body>
</html>