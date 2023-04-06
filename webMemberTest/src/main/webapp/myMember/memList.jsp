<%@page import="myMember.vo.MyMemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<script type="text/javascript">
 $(function(){
 	$(document).on('click', '.memId', function(){
		value = this.text();
		uri = 'memberDetail.do?memId=' + value;
		location.href='<%=request.getContextPath() %>/' + uri;
	})
}) 
</script>
<style type="text/css">
	table {
	border: 1px solid blue;
}
</style>
<script type="text/javascript">
	$(function(){
		$(document).on('click', '.memId', function(){
			value = this.text();
			uri = 'memberDetail.do?memId=' + value;
			location.href='<%=request.getContextPath()%>/' + uri;
		})
		
	})
	
</script>
</head>
<body>
<% List<MyMemberVO> list = (List<MyMemberVO>)request.getAttribute("list"); 
%>
	<h3>회원 목록 보기</h3>
	<table border="1">
		<tr>
			<td><input type="button" value="회원추가" id="addMem" onclick="location.href='<%=request.getContextPath()%>/addMember.do'"></td>
		</tr>
		<tr>
			<th>ID</th>
			<th>PW</th>
			<th>NAME</th>
			<th>전화</th>
			<th>주소</th>
		</tr>
		<tbody>
		<%
			
			for(MyMemberVO vo : list){
		%>
			<tr>		
				<td ><a class="memId"  href="<%=request.getContextPath() %>/memberDetail.do?memId=<%=vo.getMem_id()%>">
				<%=vo.getMem_id() %></a>
				</td>
				<td><%=vo.getMem_pass() %></td>
				<td><%=vo.getMem_name() %></td>
				<td><%=vo.getMem_tel()%></td>
				<td><%=vo.getMem_addr()%></td>
			</tr>
		
		<%
			}
		%>
		</tbody>
	</table>
</body>
</html>