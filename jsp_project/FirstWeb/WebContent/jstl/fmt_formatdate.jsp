<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%
	request.setAttribute("now", new Date());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	${now}
	<br>
	<fmt:formatDate value="${now}" type="date"/>
	<br>
	<fmt:formatDate value="${now}" type="date" dateStyle="full"/>
	<br>
	<fmt:formatDate value="${now}" type="date" dateStyle="short"/>
	<br>
	<fmt:formatDate value="${now}" type="time"/>
	<br>
	<fmt:formatDate value="${now}" type="time" dateStyle="full"/>
	<br>
	<fmt:formatDate value="${now}" type="time" dateStyle="short"/>
	
	
</body>
</html>