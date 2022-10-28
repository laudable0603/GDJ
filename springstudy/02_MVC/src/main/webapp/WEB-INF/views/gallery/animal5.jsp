<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>보고 싶은 동물 ${param.filename}</h1><!-- 파라미터로 전달됏으면 : param -> 파라미터 값꺼내기,
												  속성으로 전달 됐으면 그냥 el -->
		
	<img src="${contextPath}/resources/images/${param.filename}" width=200px />
</body>
</html>