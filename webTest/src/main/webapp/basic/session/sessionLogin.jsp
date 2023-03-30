<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	
%>
<body>
	<form action="<%=request.getContextPath()%>/sessionLogin.do" method="post">
		<table style="margin: 0 auto;">
			<tr>
			<td>ID: </td>
			<td><input type="text" name="userId" value="" placeholder="id입력"> </td>
		</tr>
		<tr>
			<td>PW: </td>
			<td><input type="text" name="userPw" placeholder="pw입력"></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;"> <input type="submit" value="logIn"> </td>
		</tr>
		</table>
	
	</form>
</body>
</html>