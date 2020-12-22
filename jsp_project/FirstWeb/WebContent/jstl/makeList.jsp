<%@page import="member.Member"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	List<Member> members = new ArrayList<Member>();

	members.add(new Member("cool1", "1111", "COOL1", "photo1.jpg"));
	members.add(new Member("cool2", "1112", "COOL2", "photo12.jpg"));
	members.add(new Member("cool3", "1113", "COOL3", null));
	members.add(new Member("cool4", "1114", "COOL4", "photo14.jpg"));
	members.add(new Member("cool5", "1115", "COOL5", "photo15.jpg"));
	members.add(new Member("cool6", "1116", "COOL6", "photo16.jpg"));
	members.add(new Member("cool7", "1117", "COOL7", "photo17.jpg"));
	members.add(new Member("cool8", "1118", "COOL8", null));
	members.add(new Member("cool9", "1119", "COOL9", null));
	members.add(new Member("cool10", "1110", "COOL10", "photo10.jpg"));
	
	session.setAttribute("members", members);

	
%>