<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// session에 저장된 cart 제거하기
	//session.invalidate() 해당 메소드는 로그인 정보도 날릴 수 있다.
	session.removeAttribute("cart"); // cart속성만 날린다.
	
	// 장바구니 목록으로 이동
	response.sendRedirect("03_cart_list.jsp");
%>