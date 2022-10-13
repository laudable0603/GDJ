<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	application.setAttribute("a", 1); // 애플리케이션 종료 전까지
	session.setAttribute("b", 2);	  // 브라우저 닫기 전까지 
	request.setAttribute("c", 3);	  // 하나의 요청&응답 사이클 내에서 유지
	pageContext.setAttribute("d",4);  // 현재 페이지에서만 유지
%>


<%-- 포워드 : request 정보를 전달하는 이동 방식 --%>
<%--
	request.getRequestDispatcher("02_scope2.jsp").forward(request, response);
--%><!-- 아래 코드와 동일한 코드. -->

<%-- 포워드 액션 태그 --%>
 <jsp:forward page="02_scope2.jsp"></jsp:forward><!-- d를 제외한 값이 모두 넘어간다. -->

<%-- 리다이렉트 : request 정보를 전달하지 않는 이동방식 --%>
<%
	response.sendRedirect("/02_Jsp/ex03_binding/02_scope2.jsp"); /* c와 d를 제외한 값이 모두 넘어간다. */
%>

</body>
</html>