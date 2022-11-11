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
<script type="text/javascript">
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
	body {
  		padding:1.5em;
  		background: #f5f5f5;
	}

	table {
		  border: 1px #a39485 solid;
		  font-size: .9em;
		  box-shadow: 0 2px 5px rgba(0,0,0,.25);
		  width: 100%;
		  border-collapse: collapse;
		  border-radius: 5px;
		  overflow: hidden;
	}

	th {
	  	text-align: left;
	}
  
	thead {
	  	font-weight: bold;
	 	 color: #fff;
	  	background: #73685d;
	}
  
	 td, th {
	  	padding: 1em .5em;
	  	vertical-align: middle;
	}
  
	 td {
		  border-bottom: 1px solid rgba(0,0,0,.1);
		  background: #fff;
	}

	a {
	 	 color: #73685d;
	}
  
	 @media all and (max-width: 768px) {
		    
	  table, thead, tbody, th, td, tr {
		   display: block;
	  }
	  
	  th {
	   	 text-align: right;
	  }
	  
	  table {
		    position: relative; 
		    padding-bottom: 0;
		    border: none;
		    box-shadow: 0 0 10px rgba(0,0,0,.2);
	  }
	  
	  thead {
		    float: left;
		    white-space: nowrap;
	  }
	  
	  tbody {
		    overflow-x: auto;
		    overflow-y: hidden;
		    position: relative;
		    white-space: nowrap;
	  }
	  
	  tr {
		    display: inline-block;
		    vertical-align: top;
	  }
	  
	  th {
	    	border-bottom: 1px solid #a39485;
	  }
	  
	  td {
	    	border-bottom: 1px solid #e5e5e5;
	  }
	  
	  
	  }
	
	.lnk_remove {
		cursor: pointer;
	}
	.blind {
		display: none;
	}
</style>
</head>
<body>

	<div>
		<a href="${contextPath}/bbs/write">작성하러가기</a>
	</div>

	<div>
		<select id="recordPerPage">
			<option value="10">10</option>
			<option value="20">20</option>
			<option value="30">30</option>
		</select>
	</div>

	<div>
		<table border="1">
			<thead>
				<tr>
					<th>순번</th>
					<th>작성자</th>
					<th>제목</th>
					<th>IP</th>
					<th>작성일</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bbs" items="${bbsList}" varStatus="vs">
					<c:if test="${bbs.state == 1}">
						<tr>
							<td>${beginNo - vs.index}</td>
							<td>${bbs.writer}</td>
							<td>
								<!-- DEPTH에 따른 들여쓰기 -->
								<c:forEach begin="1" end="${bbs.depth}" step="1">
									&nbsp;&nbsp;
								</c:forEach>
								<!-- 답글은 [RE] 표시 -->
								<c:if test="${bbs.depth > 0}">
									↳
								</c:if>
								<!-- 제목 -->
								${bbs.title}
								<!-- 답글달기 버튼 -->
								<%--
									1단 답글로 운용하는 경우 아래와 같이 처리한다.
									<c:if test="${bbs.depth == 0}">
										<input type="button" value="답글" class="btn_reply_write">
									</c:if>
								--%>
								<input type="button" value="답글" class="btn_reply_write">
								<script>
									$('.btn_reply_write').click(function(){
										$('.reply_write_tr').addClass('blind');
										$(this).parent().parent().next().removeClass('blind');
									});
								</script>
							</td>
							<td>${bbs.ip}</td>
							<td>${bbs.createDate}</td>
							<td>
								<form method="post" action="${contextPath}/bbs/remove">
									<input type="hidden" name="bbsNo" value="${bbs.bbsNo}">
									<button class="lnk_remove" id="lnk_remove${bbs.bbsNo}" style="text-align:center;">삭제</button>
								</form>
								<script>
									$('#lnk_remove${bbs.bbsNo}').click(function(){
										if(confirm('삭제할까요?')){
											//$('.frm_remove').submit();
											/* data- 속성값 확인하는 코드 */
											//alert($(this).parent().data('aaa'));
											$(this).parent().submit();
										}
									});
								</script>
							</td>
						</tr>
						<tr class="reply_write_tr blind">
							<td colspan="6">
								<form method="post" action="${contextPath}/bbs/reply/add">
									<div><input type="text" name="writer" placeholder="작성자" required></div>
									<div><input type="text" name="title" placeholder="제목" required></div>
									<div><button>답글달기</button></div>
									<input type="hidden" name="depth" value="${bbs.depth}">
									<input type="hidden" name="groupNo" value="${bbs.groupNo}">
									<input type="hidden" name="groupOrder" value="${bbs.groupOrder}">
								</form>
							</td>
						<tr>
					</c:if>
					<c:if test="${bbs.state == 0}">
						<tr>
							<td>${beginNo - vs.index}</td>
							<td colspan="5">삭제된 게시글입니다</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6" style="text-align:center; letter-spacing: 20px;">${paging}</td>
				</tr>
			</tfoot>
		</table>
	</div>

</body>
</html>
