<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	request.setAttribute("userName", "�����1");
	session.setAttribute("userName", "�����2");
	application.setAttribute("userName", "�����3");
	session.setAttribute("userId", "son");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>
		requestScope.userName : ${requestScope.userName}, 
								${userName},
								<%= request.getAttribute("userName") %> <br>
		
		sessionScope.userId : ${sessionScope.userId}, 
							  ${userId},
							  <%= session.getAttribute("userId") %> <br>
		
		param.code : <%= request.getParameter("code") %>,
					 ${param.code} <br>
					 
		pageContext : <%= pageContext.getRequest().getServletContext().getContextPath() %>
					  <br> ${pageContext.request.requestURI}
					  <br> ${pageContext.request.requestURL}
					  <br> ${pageContext.request.contextPath},
					  <%= request.getContextPath()%> <br>
					  
					  <a href="view1.jsp">session ��ü Ȯ��</a>
	</h1>
</body>
</html>