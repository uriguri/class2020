<%@page import="form.LoginData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 1. 사용자로부터 받은 데이터를 beans에 저장하고,
// 		beans 객체를 생성
LoginData loginData = new LoginData();

// 사용자로부터 데이터를 받아온다. request
String userId = request.getParameter("userid");
String pw = request.getParameter("pw");


// beans에 데이터를 저장
loginData.setUserid(userId);//아이디 저장
loginData.setPw(pw); //비밀번호 저장


// view.jsp로 beans 객체를 전달 (공유)
request.setAttribute("data", loginData);

%>

<jsp:forward page="loginView.jsp"/>