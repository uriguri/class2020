package com.uri.reglogin.member.domain;

import java.sql.Timestamp;
import java.util.Date;

public class Member {

	private int mem_idx;
	private String mem_Id;
	private String mem_Pw;
	private String mem_Name;
	private String mem_Photo;
	private String mem_Loc;
	private String mem_Lev;
	private String mem_Like;
	private String mem_Bookmark;
	private String mem_Gender;
	private Timestamp mem_Regdate;
	private int mem_Emailchk;
	private int mem_Social;
	
	
	public int getMem_idx() {
		return mem_idx;
	}
	public void setMem_idx(int mem_idx) {
		this.mem_idx = mem_idx;
	}
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
	public String getMem_Photo() {
		return mem_Photo;
	}
	public void setMem_Photo(String mem_Photo) {
		this.mem_Photo = mem_Photo;
	}
	public String getMem_Loc() {
		return mem_Loc;
	}
	public void setMem_Loc(String mem_Loc) {
		this.mem_Loc = mem_Loc;
	}
	public String getMem_Lev() {
		return mem_Lev;
	}
	public void setMem_Lev(String mem_Lev) {
		this.mem_Lev = mem_Lev;
	}
	public String getMem_Like() {
		return mem_Like;
	}
	public void setMem_Like(String mem_Like) {
		this.mem_Like = mem_Like;
	}
	public String getMem_Bookmark() {
		return mem_Bookmark;
	}
	public void setMem_Bookmark(String mem_Bookmark) {
		this.mem_Bookmark = mem_Bookmark;
	}
	public String getMem_Gender() {
		return mem_Gender;
	}
	public void setMem_Gender(String mem_Gender) {
		this.mem_Gender = mem_Gender;
	}
	public Timestamp getMem_Regdate() {
		return mem_Regdate;
	}
	public void setMem_Regdate(Timestamp mem_Regdate) {
		this.mem_Regdate = mem_Regdate;
	}
	public int getMem_Emailchk() {
		return mem_Emailchk;
	}
	public void setMem_Emailchk(int mem_Emailchk) {
		this.mem_Emailchk = mem_Emailchk;
	}
	public int getMem_Social() {
		return mem_Social;
	}
	public void setMem_Social(int mem_Social) {
		this.mem_Social = mem_Social;
	}
	public Date getToDate() {
		return new Date(this.mem_Regdate.getTime());
	}
	
	@Override
	public String toString() {
		return "Member [mem_idx=" + mem_idx + ", mem_Id=" + mem_Id + ", mem_Pw=" + mem_Pw + ", mem_Name=" + mem_Name
				+ ", mem_Photo=" + mem_Photo + ", mem_Loc=" + mem_Loc + ", mem_Lev=" + mem_Lev + ", mem_Like="
				+ mem_Like + ", mem_Bookmark=" + mem_Bookmark + ", mem_Gender=" + mem_Gender + ", mem_Regdate="
				+ mem_Regdate + ", mem_Emailchk=" + mem_Emailchk + ", mem_Social=" + mem_Social + "]";
	}
	
	
	
}
