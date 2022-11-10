<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script>
	$(function(){
		if('${recordPerPage}' != ''){
	         $('#recordPerPage').val(${recordPerPage});
	      } else {
	         $('#recordPerPage').val(10);
	      }
		
		$('#recordPerPage').change(function(){
			location.href = '${contextPath}/bbs/list?recordPerPage=' + $(this).val();
		});
	});
</script>
<style>
	.lnk_remove {
		cursor: pointer;
		
	}
	.lnk_remove:hover{
		background-color: crimson;
	}
</style>
</head>
<body>

	<div>
		<a href="${contextPath}/bbs/write">게시판으로가기</a>
	</div>
	<div>
		<label for="recordPerPage">페이지 표시할 개수</label>
		<select id="recordPerPage" name="recordPerPage">
			<option value="10">10</option>
			<option value="20">20</option>
			<option value="30">30</option>
		</select>
	</div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>순번</td>
					<td>작성자</td>
					<td>제목(내용)</td>
					<td>IP</td>
					<td>작성일</td>
					<td>삭제</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bbs" items="${bbsList}" varStatus="vs">
					<tr>
						
						<c:if test="${bbs.state == 1}">
							<td>${beginNo - vs.index}</td>
							<td>${bbs.writer }</td>
							<td>${bbs.title}</td>
							<td>${bbs.ip}</td>
							<td>${bbs.createDate}</td>
							<td>
								<!-- data- 개발시 확인하는 코드  -->
								<%-- data-aaa="${bbs.bbsNo}" --%>
								<form class="frm_remove" method="post" action="${contextPath}/bbs/remove">
									<!--* 클래스로 주는 이유 forEach문때문에 id속성을 사용할 수 없다. -->
									<input type="hidden" name="bbsNo" value="${bbs.bbsNo}">
									<input class="lnk_remove" id="lnk_remove${bbs.bbsNo}" type="button" value="삭제">
								</form>							
								<script type="text/javascript">
									$('#lnk_remove${bbs.bbsNo}').click(function(ev){
											//$('.frm_remove').submit();
											/* data- 속성값 확인하는 코드 */
											//alert($(this).parent().data('aaa'));
										if(confirm('삭제할까요?')){
											$(this).parent().submit();
										}
									});
								
								</script>
							</td>
						</c:if>
						<c:if test="${bbs.state == 0}">
							<td>${beginNo - vs.index}</td>
							<td colspan="5" style="text-align:center;">※삭제된 게시글 입니다※</td>
						</c:if>
							
							
						
						
						
						
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6" style="text-align:center;">${paging}</td>
				</tr>
			</tfoot>
		</table>
	</div>
	
</body>
</html>