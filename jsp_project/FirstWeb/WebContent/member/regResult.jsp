<%@page import="form.RegData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 받은데이터 빈즈 저장한걸(RegData) 빈즈객체(regData)생성
	RegData regData = new RegData();

	// request사용해서 데이터를 받아온다
	String userid = request.getParameter("userid");
	String pw = request.getParameter("pw");
	String username = request.getParameter("username");
	String userPhoto = request.getParameter("userPhoto");
	
	// 빈즈에 데이터저장 쎄터사용
	regData.setUserid(userid);
	regData.setPw(pw);
	regData.setUsername(username);
	regData.setUserPhoto(userPhoto);
	
	// 뷰페이지로 데이터를 공유
	request.setAttribute("data", regData);
%>
<!-- 페이지연결 포워드방식 -->

<jsp:forward page="regView.jsp"/>
