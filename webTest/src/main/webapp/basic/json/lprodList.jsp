<%@page import="json.LprodVO"%>
<%@page import="java.util.List"%>
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
	List<LprodVO> list = (List<LprodVO>)request.getAttribute("list");	
%>
<table border="1">
	<tr><td>lprod_id</td>
	<td>lprod_gu</td>
	<td>lprod_nm</td></tr>	
<%
	for(LprodVO vo : list){
%>
	<tr><td><%=vo.getLprod_id() %></td>
	<td><%=vo.getLprod_gu() %></td>
	<td><%=vo.getLprod_nm() %></td></tr>
<%
}
%>
</table>
</body>
</html>