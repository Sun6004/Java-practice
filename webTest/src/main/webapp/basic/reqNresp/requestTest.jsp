<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 
	HTML주석
 -->
 <%--
 	JSP주석
  --%>
  <%
 	// jsp문서에서 java명령어를 사용할 수 있는 영역으로 '스크립트릿'이라고 한다
 	String name = "hong";
  %>
<body>
<%-- 	<%= 변수 또는 수식 %> ==> jsp에서 변수에 저장된 값이나 수식의 결과를 출력할 때 사용한다. --%>

<!-- 
	<form>태그의 속성
	1)action ==> form 태그 영역에서 구성된 데이터를 받아서 처리할 문서명 또는 서블릿urp
	2)method ==> 전송방식(grt,post) ==>기본값: get
	3)target ==> 응답이 나타날 프레임명
	4)enctype ==> 인코딩 방식 (서버로 파일을 전송할 때는 이 속성에 'multipart/form-data'로 지정해야 한다.)
 -->
<h2><%=name%> 의 Request연습 <%=3*2+7 %></h2>
<form action="/webTest/requestTest01.do" method=get>
	<table border="1">
		<tr>
			<td>name</td>
			<td> <input type="text" size="10" name="username"> </td>
		</tr>
		<tr>
			<td>job</td>
			<td>
			 	<select name="job">
					<option value="백수">- 백수 -</option>
					<option value="건달">- 건달 -</option>
					<option value="학생">- 학생 -</option>
					<option value="회사원">- 회사원 -</option>
				</select>
			 </td>
		</tr>
		<tr>
			<td>hobby</td>
			<td> 
				<input type="checkbox" name="hobby" value="여행">여행 
				<input type="checkbox" name="hobby" value="운동">운동 
				<input type="checkbox" name="hobby" value="게임">게임 
				<input type="checkbox" name="hobby" value="도박">도박 
				<input type="checkbox" name="hobby" value="술">술 
				<input type="checkbox" name="hobby" value="마약">마약 		
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<input type="submit" value="전송"> <input type="reset" value="취소">
			</td>
		</tr>
	</table>
	
</form>
</body>
</html>