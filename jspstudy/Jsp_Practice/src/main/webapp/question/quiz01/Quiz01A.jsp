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
	<%
		String[][] sites = {
				{"구글","https://www.google.com"},
				{"네이버","https://www.naver.com"},
				{"다음","https://www.daum.net"},
				{"네이트","https://www.nate.net"}
	};
	%>
	<form action="Quiz01B.jsp">
		사이트명:
		<select name="site">
			<c:forEach>
			
			</c:forEach>
		</select>
	</form>

</body>
</html>