<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<div class="contents">
		<h2 class="contents_title">회원 가입</h2>
		<hr>
		
		<div class="content">
			<form method="post" enctype="multipart/form-data">
				<table>
				
					<tr>
						<th><label for="memId">아이디(E-mail)</label></th>
						<td><input type="email" id="mem_Id" name="mem_Id"></td>
					</tr>
					
					<tr>
						<th><label for="memPw">비밀번호</label></th>
						<td><input type="password" id="mem_Pw" name="mem_Pw"></td>
					</tr>
					
					<tr>
						<th><label for="memName">닉네임</label></th>
						<td><input type="text" id="mem_Name" name="mem_Name"></td>
					</tr>
					
					<tr>
						<th><label for="memPhoto">프로필 사진</label></th>
						<td><input type="file" id="mem_Photo" name="mem_Photo"></td>
					</tr>
					
					<tr>
						<th><label for="memLoc">내 위치</label></th>
						<td><input type="text" id="mem_Loc" name="mem_Loc"></td>
					</tr>
					
					<tr>
						<th></th>
						<td><input type="submit" value="회원가입"></td>
						<td><input type="reset" value="초기화"></td>
					</tr>
					
				</table>
			</form>
		</div>
	</div>
</body>
</html>