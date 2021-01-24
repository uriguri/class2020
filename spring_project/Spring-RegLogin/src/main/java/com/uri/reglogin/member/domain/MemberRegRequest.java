package com.uri.reglogin.member.domain;

import org.springframework.web.multipart.MultipartFile;

public class MemberRegRequest {

	private String mem_Id;
	private String mem_Pw;
	private String mem_Name;
	private MultipartFile mem_Photo;
	private String mem_Loc;
	private String mem_Gender;
	
	public String getMem_Id() {
		return mem_Id;
	}
	public void setMem_Id(String mem_Id) {
		this.mem_Id = mem_Id;
	}
	public String getMem_Pw() {
		return mem_Pw;
	}
	public void setMem_Pw(String mem_Pw) {
		this.mem_Pw = mem_Pw;
	}
	public String getMem_Name() {
		return mem_Name;
	}
	public void setMem_Name(String mem_Name) {
		this.mem_Name = mem_Name;
	}
	public MultipartFile getMem_Photo() {
		return mem_Photo;
	}
	public void setMem_Photo(MultipartFile mem_Photo) {
		this.mem_Photo = mem_Photo;
	}
	public String getMem_Loc() {
		return mem_Loc;
	}
	public void setMem_Loc(String mem_Loc) {
		this.mem_Loc = mem_Loc;
	}
	public String getMem_Gender() {
		return mem_Gender;
	}
	public void setMem_Gender(String mem_Gender) {
		this.mem_Gender = mem_Gender;
	}
	
	public Member toMember() {
		Member member = new Member();
		member.setMem_Id(mem_Id);
		member.setMem_Name(mem_Name);
		member.setMem_Pw(mem_Pw);
		return member;
	}
	
	@Override
	public String toString() {
		return "MemberRegRequest [mem_Id=" + mem_Id + ", mem_Pw=" + mem_Pw + ", mem_Name=" + mem_Name + ", mem_Photo="
				+ mem_Photo + ", mem_Loc=" + mem_Loc + ", mem_Gender=" + mem_Gender + "]";
	}
	
	
	
}
