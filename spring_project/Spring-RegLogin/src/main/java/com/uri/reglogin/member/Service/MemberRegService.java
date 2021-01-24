package com.uri.reglogin.member.Service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uri.reglogin.member.dao.MemberDao;
import com.uri.reglogin.member.domain.Member;
import com.uri.reglogin.member.domain.MemberRegRequest;

@Service
public class MemberRegService {

	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int memberReg(MemberRegRequest regRequest, HttpServletRequest request) {
		
		// return 해줄 값
		int result = 0;
		
		
		File newFile = null;
		String newFileName = null;
		
		// == regRequest의 Photo가 비어있지 "않을" 때
		if(!regRequest.getMem_Photo().isEmpty()) {
			// 웹 경로
			String uploadPath = "/fileupload/member";
			// 시스템의 실제 경로
			String saveDirPath = request.getSession().getServletContext().getRealPath(uploadPath);
			// 새로운 파일 이름
			newFileName = regRequest.getMem_Id() + System.currentTimeMillis();
			newFile = new File(saveDirPath, newFileName);
			
			// 파일 저장
			try {
				regRequest.getMem_Photo().transferTo(newFile);
				
			} catch (IllegalStateException e) {
				e.printStackTrace();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		Member member = regRequest.toMember();
		
		// 새로운 파일의 이름이 "있다"면 
		if(newFileName != null) {
			member.setMem_Photo(newFileName);
		}
		
		try {
		// 데이터 베이스에 입력
		dao = template.getMapper(MemberDao.class);
		result = dao.insertMember(member);
		
		} catch (Exception e) {
			e.printStackTrace();
			// 에러가 발생 했을때 현재 저장한 파일이 있다면? -> 삭제
			if(newFile != null && newFile.exists()) {
				newFile.delete();
			}
		}
		
		return result;
	}
	
}
