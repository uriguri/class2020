package com.uri.sp.member.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.uri.sp.member.domain.MemberRegRequest;

@Service
public class MemberRegService {
	
	// 파일을 업로드해준다(유저사진), 데이터베이스에 저장해준다.
	public int memberReg(MemberRegRequest regRequest,
						 HttpServletRequest request) {
		
		// 웹 경로
		String uploadPath = "/fileupload/member";
		
		// 시스템의 실제(절대) 경로
		String saveDirPath = request.getSession().getServletContext().getRealPath(uploadPath);
		
		// 새로운 파일 이름 (중복을 막기위해 파일명을 Userid+long타입의 숫자로 만들어주었다)
		String newFileName = regRequest.getUserid()+System.currentTimeMillis();
		
		
		File newFile = new File(saveDirPath, newFileName); 
		
		// 파일저장
		try {
			regRequest.getUserPhoto().transferTo(newFile);
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
