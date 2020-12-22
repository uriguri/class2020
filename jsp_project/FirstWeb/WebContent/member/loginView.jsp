<%@page import="form.LoginData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	LoginData data = (LoginData)request.getAttribute("data");
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원의 로그인 입력 데이터</title>
</head>
<body>
	<h1>회원이 입력한 로그인 데이터 출력</h1>
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
	</table>
	
</body>
</html>