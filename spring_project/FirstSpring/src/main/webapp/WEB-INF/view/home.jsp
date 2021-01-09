<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Index</h1>
	 <c:url value="/hello" var="hello"/>
	<ul>
		<li><a href="${hello}">${hello}</a></li>
	</ul>
	
	 <c:url value="/member/login" var="login"/>
	<ul>
		<li><a href="${login}">${login}</a></li>
	</ul>
	
	<c:url value="/member/search" var="membersearch"/>
	<ul>
		<li><a href="${membersearch}">${membersearch}</a></li>
	</ul>
	
	<c:url value="/order/order" var="order"/>
	<ul>
		<li><a href="${order}">${order}</a></li>
	</ul>
	
	<c:url value="/cookie/make" var="cookieMake"/>
	<ul>
		<li><a href="${cookieMake}">${cookieMake}</a></li>
	</ul>
	
	<c:url value="/cookie/view" var="cookieView"/>
	<ul>
		<li><a href="${cookieView}">${cookieView}</a></li>
	</ul>
	
	<c:url value="/header/header" var="header_url"/>
	<ul>
		<li><a href="${header_url}">${header_url}</a></li>
	</ul>
	
	<c:url value="/search/search" var="search"/>
	<ul>
		<li><a href="${search}">${search}</a></li>
	</ul>
	
	<c:url value="/upload/uploadForm" var="fileupload"/>
	<ul>
		<li><a href="${fileupload}">${fileupload}</a></li>
	</ul>
	
	
</body>
</html>
