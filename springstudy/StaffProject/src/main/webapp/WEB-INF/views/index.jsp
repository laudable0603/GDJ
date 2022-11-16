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
<script>

	$(function(){
		fn_staffList();
		fn_addStaff();
		fn_findStaff();
	});
	
	function fn_staffList(){
	      $.ajax({
	         type: 'get',
	         url : '${contextPath}/list.json',
	         dataType: 'json',
	         success : function(resData){
	            $('#staff_list').empty();   
	            $.each(resData, function(i, staff){
	               var tr = '<tr>';
	               tr += '<td>' + staff.sno + '</td>';
	               tr += '<td>' + staff.name + '</td>';
	               tr += '<td>' + staff.dept + '</td>';
	               tr += '<td>' + staff.salary + '</td>';
	               tr += '</tr>';
	               $('#staff_list').append(tr);            
	            });
	         }
	      });
	   } 

	
	function fn_addStaff(){
		$('#btn_add').click(function(){
			if( /^[0-9]{5}$/.test($('#sno').val()) == false){
				alert('사원번호는 5자리 숫자입니다.');
				return;
			}
			if(/^[ㄱ-ㅎ|가-힣]{3,5}$/.test($('#dept').val()) == false){
				alert('부서는 3~5자리 한글입니다.');
				return;
			}
			$.ajax({
				type: 'post',
				url: '${contextPath}/add',
				data: 'sno=' + $('#sno').val() + '&name=' + $('#name').val() + '&dept=' + $('#dept').val(),
				dataType: 'text',
				success: function(resData){
					alert(resData);
					fn_staffList();
					$('#sno').val('');
					$('#name').val('');
					$('#dept').val('');
				},
				error: function(jqXHR){
					alert(jqXHR.responseText);
				}
			});
		});
	}
	
	function fn_findStaff(){
	      $('#btn_oneStaff').click(function(){
	         if( /^[0-9]{5}$/.test($('#find_sno').val()) == false){
	            alert('사원번호는 5자리 숫자입니다.');
	            return;
	         }
	         $.ajax({
	        	type: 'get',
	            url: '${contextPath}/query.json',
	            data: 'query=' + $('#find_sno').val(),
	            dataType: 'json',
	            success: function(resData){
	            	$('#staff_list').empty();  
	            	var tr = '<tr>';
	            	tr += '<td>' + resData.sno + '</td>';
	            	tr += '<td>' + resData.name + '</td>';
	            	tr += '<td>' + resData.dept + '</td>';
	            	tr += '<td>' + resData.salary + '</td>';
	            	tr += '</tr>';
	            	$('#staff_list').append(tr);
				},
	            
	            error: function(jqXHR){
	               alert("조회된 사원 정보가 없습니다.");
	            }
	         });
	      });
	   }
	
	
	
	

	
	
</script>
</head>
<body>

	<h3>사원등록</h3>
	<form id="frm_add">
		<input type="text" id="sno" name="sno" placeholder="사원번호">
		<input type="text" id="name" name="name" placeholder="사원명">
		<input type="text" id="dept" name="dept" placeholder="부서명">
		<input type="button" value="등록" id="btn_add">
	</form>
	
	<hr>
	
	<h3>사원조회</h3>
	<form id="frm_find">
		<input type="text" id="find_sno" name="sno" placeholder="사원번호">
		<input type="button" value="조회" id="btn_oneStaff" >
		<input type="button" value="전체" id="btn_allStaff" onclick="fn_staffList();" >
	</form>
	
	<hr>
	
	<h3>사원목록</h3>
	<table border="1">
		<thead>
			<tr>
				<td>사원번호</td>
				<td>사원명</td>
				<td>부서명</td>
				<td>연봉</td>
			</tr>
		</thead>
		<tbody id="staff_list">
		
		</tbody>
	
	</table>
	
</body>
</html>