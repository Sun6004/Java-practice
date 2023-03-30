<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	//로그인한 id를 쿠키에서 읽어온다.
	String cookieUserId =""; // 로그인한 id가 저장될 변수
	String chk = ""; //Checkbox의 체크 여부를 체크한다.
	
	Cookie[] cookieArr = request.getCookies();
	if(cookieArr != null){
		for(Cookie cookie: cookieArr){
			if("USERID".equals(cookie.getName())){
				cookieUserId = cookie.getValue();
				chk = "checked";
			}
		}
	}

%>
<body>
<form action="<%=request.getContextPath()%>/cookieLoginServlet.do" method="post">
	<table style="margin: 0 auto;">
		<tr>
			<td>ID: </td>
			<td><input type="text" name="userId" value="<%=cookieUserId %>" placeholder="id입력"> </td>
		</tr>
		<tr>
			<td>PW: </td>
			<td><input type="text" name="userPw" placeholder="pw입력"> </td>
		</tr>
		<tr>
			<td colspan="2"> <input type="checkbox" name="chkid" value="check" <%=chk%>>id기억하기</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;"> <input type="submit" value="logIn"> </td>
		</tr>
	</table>
</form>
</body>
</html>