<%@page import="memberVo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	// Session 정보를 가져온다. --> JSP문서에서 HttpSession객체는 session이라는 이름으로 저장되어 있다.
	MemberVO loginMemVo = (MemberVO)session.getAttribute("loginMember"); 
	//값을 가져오지 못하면 loginid에 null이 저장
%>
<%
if(loginMemVo == null){
	%>
<body>
<!--
 로그인이 되어있지 않을때 화면
 -->
 <form action="<%=request.getContextPath()%>/sessionLoginDB.do" method="post">
	<table style="margin: 0 auto;">
		<tr>
			<td>ID: </td>
			<td><input type="text" name="userId" value="" placeholder="id입력"> </td>
		</tr>
		<tr>
			<td>PW: </td>
			<td><input type="text" name="userPass" placeholder="pw입력"> </td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;"> <input type="submit" value="logIn"> </td>
		</tr>
	</table>
</form>
<%
}else{
%>
<!-- 로그인이 되었을 때 화면 -->
<h3><%=loginMemVo.getMem_name() %>님 반갑습니다.</h3>
<a href="<%=request.getContextPath()%>/sessionLogoutDB.do">로그아웃</a>
	
	
<%
}
%>
</body>
</html>