package com.uri.sp.domain;

import org.springframework.web.multipart.MultipartFile;

public class MemberRegRequest {

	// 폼에서 post방식으로 넘겨주는 Data
	private String userid;
	private String pw;
	private String username;
	private MultipartFile userPhoto;
	
	// getter & setter
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public MultipartFile getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(MultipartFile userPhoto) {
		this.userPhoto = userPhoto;
	}
	
	// 확인용 toString
	@Override
	public String toString() {
		return "MemberRegRequest [userid=" + userid + ", pw=" + pw + ", username=" + username + ", userPhoto="
				+ userPhoto + "]";
	}
	
	
	
	
	
	
	
}
