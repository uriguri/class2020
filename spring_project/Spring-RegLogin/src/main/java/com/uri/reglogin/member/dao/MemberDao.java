package com.uri.reglogin.member.dao;

import com.uri.reglogin.member.domain.Member;

public interface MemberDao {

	
	// 회원가입
	int insertMember (Member member);
	
}
