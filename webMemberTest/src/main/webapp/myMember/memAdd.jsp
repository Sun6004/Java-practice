<%@page import="myMember.vo.MyMemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.min.js"></script>
<script type="text/javascript">
	
</script>

<style type="text/css">
table {
	border: 1px solid blue;
}
</style>
</head>
<body>
	<%
	MyMemberVO vo = (MyMemberVO) session.getAttribute("list");
	%>

	<h3>회원 정보 입력 폼</h3>
	<form action="<%=request.getContextPath()%>/addMember.do" method="post"
		enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>ID</td>
				<td><input type="text" name="memId">
					<button type="button">중복확인</button></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="memPass"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="text" name="memPass2"></td>
			</tr>
			<tr>
				<td>회원이름</td>
				<td><input type="text" name="memName"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="memTel"></td>
			</tr>
			<tr>
				<td>회원주소</td>
				<td><input type="text" name="memAddr"></td>
			</tr>
			<tr>
				<td>프로필 사진</td>
				<td><input type="file" name="mem_photo"></td>
			</tr>

			<tr>
				<td colspan="2" style="text-align: center"><input type="submit"
					value="저장">
					<button type="reset">취소</button>
					<button type="button"
						onclick="location.href='<%=request.getContextPath()%>/memList.jsp'">회원목록</button>
				</td>
			</tr>

		</table>
	</form>
</body>
</html>