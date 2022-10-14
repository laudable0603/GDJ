<%@page import="domain.Board"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 1. 1 ~ 5 --%>
	<c:forEach var="n" begin="1" end="5" step="1"> <!-- n을 1부터 5까지 1씩 늘린다. -->
		<div>${n}</div>
	</c:forEach>
	<hr>
	<%-- 2. 5 ~ 1 --%>
	<c:forEach var="n" begin="1" end="5" step="1">
		<div>${6- n}</div>
	</c:forEach>
	<hr>
	<%-- 3. <select> 1월 ~ 12월 --%>
	<select name="month">
		<option value="">월선택</option>
		<c:forEach var="n" begin="1" end="12" step="1">
			<option value="${n}">${n}월</option>
		</c:forEach>
	</select>
	<hr>
	<%-- 4. 배열 --%>
	<%
		String[] menus = {"김밥","떡볶이","순대"};
		pageContext.setAttribute("menus", menus);
	%>
	<c:forEach var="menu" items="${menus}" varStatus="vs">
		인덱스 : ${vs.index}, 순번 : ${vs.count}, 배열요소: ${menu}<br>
	</c:forEach>
	<hr>
	<%-- 5. 리스트 --%>
	<%
		List<String> seasons = Arrays.asList("봄","여름","가을","겨울");
		pageContext.setAttribute("seasons", seasons);
	%>
	<c:forEach var="season" items="${seasons}" varStatus="k">
		인덱스 : ${k.index}, 순번 : ${k.count}, 배열요소: ${season}<br>
	</c:forEach>
	<hr>
	<%-- 6. Map(반복문이 필요한 건 아님) --%>
	<%
		Map<String, Integer> map = new HashMap<>();
		map.put("begin", 1);
		map.put("end", 10);
		pageContext.setAttribute("map", map);
	%>
	${map.begin} ~ ${map.end}<br>
	
	<%-- 7. 객체 (반복이 필요한 건 아님) --%>
	<%
		Board board = new Board();
		board.setBoardNo(1);
		board.setTitle("도대체 언제까지...");
		board.setHit(100);
		pageContext.setAttribute("board", board);
	%>
	
	${board.boardNo}, ${board.title}, ${board.hit}<br>
	${board.getBoardNo()}, ${board.getTitle()}, ${board.getHit()}<br>
	<%--
		${board.title}은 ${board.getTitle()}를 자동으로 호출한다.(짧은코드 사용)
	 --%>
	 
	 <hr>
	 
	 <%--
	 	문제. 임의의 Board 객체를 3개 저장한 리스트
	  --%>
	  <%
	  Board board1 = new Board(101,"질문입니다",5);
	  Board board2 = new Board(102,"저도 궁금해요",42);
	  Board board3 = new Board(103,"답변입니다.",60);
	  List<Board> boards = Arrays.asList(board1, board2, board3);
	  pageContext.setAttribute("boards", boards);
	  %>
	  <table border="1">
	  	<thead>
	  		<tr>
	  			<th>순번</th>
	  			<th>게시글번호</th>
	  			<th>제목</th>
	  			<th>조회수</th>
	  		</tr>
	  	</thead>
	  	<tbody>	  		
  			<c:forEach var="board" items="${boards}" varStatus="vs">
	 			<tr>
	 				<td style="text-align:center">${vs.count}</td>
	 				<td>${board.boardNo}</td>
	 				<td>${board.title}</td>
	 				<td>${board.hit}</td>
				</tr>
  			</c:forEach>
	  		
	  	</tbody>
	  </table>
	
	
	
	
</body>
</html>