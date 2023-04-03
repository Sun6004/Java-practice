<%@page import="controller.FileList"%>
<%@page import="vo.FileinfoVO"%>
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
	//컨트롤러(서블릿)에서 보내온 데이터 받기
	List<FileinfoVO> list = (List<FileinfoVO>)request.getAttribute("fileList");
%>
	<h3>전체 파일 목록</h3>
	<br><hr><br>
	<a href="<%=request.getContextPath()%>/fileUpload.do">파일 업로드</a>
	<table border="1">
	<thead>
		<tr>
			<th>번호</th> 
			<th>작성자</th> 
			<th>저장파일명</th> 
			<th>원래 파일명</th> 
			<th>파일크기</th> 
			<th>날짜</th> 
			<th>비고</th> 
		</tr>
	</thead>
	<%
	if(list == null || list.size()==0){
		
	%>
		<tr><td colspan="7" style="text-align: center;">저장된 파일 목록이 하나도 없습니다.</td></tr>
	<%
	} else{
		for(FileinfoVO vo : list){	
	%>
		<tr>
			<td><%=vo.getFILE_NO() %></td>
			<td><%=vo.getFILE_WRITER() %></td>
			<td><%=vo.getSAVE_FILE_NAME() %></td>
			<td><%=vo.getORIGIN_FILE_NAME() %></td>
			<td><%=vo.getFILE_SIZE() %></td>
			<td><%=vo.getFILE_DATE() %></td>
			<td>DownLoad</td>
		</tr>
	<%
		}
	}
	%>
	<tbody>
	</tbody>
	</table>
</body>
</html>