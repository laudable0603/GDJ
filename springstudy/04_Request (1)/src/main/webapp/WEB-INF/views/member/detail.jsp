<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원 상세보기</h1>
	
	<div>아이디 ${member.id}</div>  	<%-- ${member.id}는 member.getId()를 호출  ▷ getter를 만들어야 정상 동작한다. --%>
	<div>패스워드 ${member.pw}</div>    <%-- ${member.pw}는 member.getPw()를 호출  ▷ getter를 만들어야 정상 동작한다. --%>

</body>
</html>