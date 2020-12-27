<%@page import="jdbc.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// DAO 객체의 insert 메서드로 member 참조변수 전달
	
	// Connection 객체의 참조변수 전달
	
	Connection conn = ConnectionProvider.getConnection();
	
	if(conn !=null){
	
		// 폼에 입력한 사용자의 입력데이터 한글 처리
		request.setCharacterEncoding("utf-8");
		
		// 폼에 있는 name의 파라미터를 가져온다. (name이 동일해야함)
		String userId = request.getParameter("userid");
		String pw = request.getParameter("pw");
		String userName = request.getParameter("username");
		String userPhoto = request.getParameter("userPhoto");
		
		// 객체 생성
		Member member = new Member();
		member.setUserId(userId);
		member.setPaassword(pw);
		member.setUserName(userName);
		member.setUserPhoto(userPhoto);
		
		System.out.println(member);
	}
	
%>