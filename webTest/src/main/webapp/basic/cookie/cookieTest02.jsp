<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<%= request.getContextPath()%>/cookieCountServlet.do">쿠키카운트 증가하기</a>
	<a href="<%= request.getContextPath()%>/cookieCountdel.do">쿠키카운트 초기화</a>

</body>
</html>