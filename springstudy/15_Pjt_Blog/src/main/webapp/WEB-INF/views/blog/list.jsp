 <%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<jsp:include page="../layout/header.jsp">
	<jsp:param value="블로그목록" name="title"/>
</jsp:include>

<div>
	
	<h1>블로그 목록(전체 ${totalRecord}개)</h1>
	
	<%-- 관리자만보이는 코드 <c:if test="${loginUser.id == 'admin'}">  --%>
	<%-- 로그인한 유저만 보이는 코드<c:if test="${loginUser != null}"> --%>
	<div>
		<input type="button" value="블로그 작성하기" onclick="location.href='${contextPath}/blog/write'">
	</div>
	<%-- </c:if> --%>
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>순번</td>
					<td>제목</td>
					<td>조회수</td>
					<td>작성일</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${blogList}" var="blog" varStatus="vs">
					<tr>
						<td>${beginNo - vs.index}</td>
						<td><a href="${contextPath}/blog/increse/hit?blogNo=${blog.blogNo}">${blog.title}</a></td>
						<td>${blog.hit}</td>
						<td>${blog.createDate}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4" style="text-align:center">
						${paging}
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
	

</div>

</body>
</html>