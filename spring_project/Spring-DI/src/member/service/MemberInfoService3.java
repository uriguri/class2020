package member.service;

import javax.annotation.Resource;

import member.dao.Dao;

public class MemberInfoService3 implements MemberService {
	
	@Resource(name = "guestDao")
	Dao	dao;

	
	public Object process() {
		System.out.println("MemberInfoService 인스턴스 실행");
		
		dao.select();
		
		return null;
	}

}
