<%@page import="myMember.vo.MyMemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: 1px solid blue;
}

img{
	width: 200px;
	height: 150px;
}
</style>
</head>
<body>
	<h3>회원 정보 상세보기</h3>
	<%
	MyMemberVO vo = (MyMemberVO) request.getAttribute("memVo");
	%>
	<table border="1">
		<tr>
			<td>
			<img src="<%=request.getContextPath()%>/imgView.do?filename=<%=vo.getMem_photo()%>">
			</td>
		</tr>
		<tr>
			<td>회원ID</td>
			<td><%=vo.getMem_id()%></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%=vo.getMem_pass()%></td>
		</tr>
		<tr>
			<td>회원이름</td>
			<td><%=vo.getMem_name()%></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><%=vo.getMem_tel()%></td>
		</tr>
		<tr>
			<td>회원주소</td>
			<td><%=vo.getMem_addr()%></td>
		</tr>
		<tr>
			<td colspan="2">
				<span> 
					<a
						href="<%=request.getContextPath()%>/updateMember.do?memId=<%=vo.getMem_id()%>&memPhoto=<%=vo.getMem_photo()%>">
							<button type="button">수정</button>
					</a> 
					
					<a
						href="<%=request.getContextPath()%>/delMember.do?memId=<%=vo.getMem_id()%>">
							<button type="button">삭제</button>
					</a> 
					
					<a href="<%=request.getContextPath()%>/memList.jsp">
							<button type="button">회원목록</button>
					</a>
				</span>
			</td>
		</tr>
	</table>
</body>
</html>