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
// jsp 문서에서는 Session정보가 session이라는 이름으로 자동으로 저장되어 있다.
// 그래서 HttpSession session = request.getSession(); 명령을 사용할 필요없음.

%>
<h3>이름: <%=session.getAttribute("userName") %></h3>
	<a href="<%=request.getContextPath()%>/sessionAdd.do">Session정보 저장하기</a>
	<br><br>
	<a href="<%=request.getContextPath()%>/sessionRead.do">Session정보 확인하기</a>
	<br><br>
	<a href="<%=request.getContextPath()%>/sessionDel.do">Session정보 삭제하기</a>
</body>
</html>