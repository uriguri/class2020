<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
		margin: 0;
		padding: 0;
	}
	
	body {
		padding : 10px;
	}
	
	header, nav, div.contents, footer   {
		width : 800px;
		margin : 0 auto;
		/* background-color: #EEE; */
	}
	
	header {
		padding : 10px 20px;
	}
	
	nav>ul {		
		overflow : hidden;	
		list-style: none;
		
		border-top : 1px solid #DDD;
		border-bottom : 1px solid #DDD;
	}
	
	nav>ul>li {
		float: left;
		padding : 5px 20px;		
	}
	
	div.contents {
		clear : both;
		
		margin-top: 20px;
		margin-bottom: 20px;
	}
	
	div.contents>h2.content_title {
		
		padding : 10px;
		
	}
	
	hr {
		border : 0;
		border-top: 1px solid #DDD;
	}
	
	div.content {
		padding : 20px 5px;
	}
	
	footer {
	
		border-top : 1px solid #DDD;		
		
		padding : 10px;
		text-align : center;
	}
	
</style>
</head>
<body>

	<%@ include file="/include/header.jsp" %>
		
	
	<%@ include file="/include/nav.jsp" %>
	
	<div class="contents">
		<h2 class="content_title">회원 가입폼</h2>
		<hr>
		<div class="content">
	
    <form action="memberReg.jsp" method="post">
        <table>
            <tr>
                <th><label for="userid">아이디(email)</label></th>
                <td>
                    <input type="email" id="userid" name="userid">
                </td>
            </tr>
            <tr>
                <th><label for="pw">비밀번호</label></th>
                <td>
                    <input type="password" id="pw" name="pw"> 
                </td>
            </tr>
            <tr>
                <th><label for="username">이름</label></th>
                <td>
                    <input type="text" id="username" name="username">
                </td>
            </tr>
            <tr>
                <th><label for="userPhoto">사진</label></th>
                <td>
                    <input type="file" id="userPhoto" name="userPhoto">
                </td>
            </tr>
            <tr>
                <th></th>
                <td>
                    <input type="submit" value="회원가입">
                </td>
            </tr>
        </table>
    </form>
		</div>
	</div>
	
	
	
	
	
	<%@ include file="/include/footer.jsp"%>

	
	
	
	
	
	
	
	
	


</body>
</html>