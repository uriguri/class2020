<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	request.setAttribute("userName", "손흥민");
	
	application.setAttribute("userId", "1111");	
	
	session.setAttribute("nickName", "SON");
	
	pageContext.setAttribute("age", 27);
%> 
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%= request.getAttribute("userName") %>,
	<%= application.getAttribute("userId")%>,
	<%= session.getAttribute("nickName")%>,
	<%= pageContext.getAttribute("age")%>,
</body>
</html>