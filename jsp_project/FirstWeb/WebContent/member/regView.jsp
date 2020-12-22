<%@page import="form.RegData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	// 빈즈에 setAttribute한 "data"
 	RegData data = (RegData)request.getAttribute("data");
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 데이터</title>
</head>
<body>
	<h1>회원이 입력한 가입데이터 출력</h1>
	<%= data %>
	<table>
		<tr>
			<td>아이디</td>
			<td><%=data.getUserid() %></td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><%=data.getPw() %></td>
		</tr>
		<tr>
			<td>닉네임</td>
			<td><%=data.getUsername() %></td>
		</tr>
		<tr>
			<td>업로드사진</td>
			<td><%=data.getUserPhoto() %></td>
		</tr>
	</table>
	
</body>
</html>