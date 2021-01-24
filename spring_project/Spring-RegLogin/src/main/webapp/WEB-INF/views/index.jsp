<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 / 로그인</title>
</head>
<body>
	<h2>회원가입 / 로그인 페이지 입니다</h2>
	<hr>
	<div class="content">
		<table>
			<tr>
				<td><a href="<c:url value="/member/reg"/>">회원가입</a></td> 
				<td><a href="<c:url value="/member/login"/>">로그인</a></td>
			</tr>
		</table>
	</div>
</body>
</html>