package com.aia.op.member.domain;

import org.springframework.web.multipart.MultipartFile;

public class MemberEditRequest {

		private int idx;
		private String Userid;
		private String pw;
		private String username;
		private String oldPhoto;
		private MultipartFile userPhoto;
		
		
		public void setIdx(int idx) {
			this.idx = idx;
		}
		public void setPw(String pw) {
			this.pw = pw;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public void setOldPhoto(String oldPhoto) {
			this.oldPhoto = oldPhoto;
		}
		public void setUserPhoto(MultipartFile userPhoto) {
			this.userPhoto = userPhoto;
		}
		
		public int getIdx() {
			return idx;
		}
		public String getPw() {
			return pw;
		}
		public String getUsername() {
			return username;
		}
		public String getOldPhoto() {
			return oldPhoto;
		}
		public MultipartFile getUserPhoto() {
			return userPhoto;
		}
		
		public String getUserid() {
			return Userid;
		}
		public void setUserid(String userid) {
			this.Userid = userid;
		}
		
		public Member getToMember() {
			Member member = new Member();
			member.setIdx(idx);
			//member.setMemberid(Userid);
			member.setMembername(username);
			member.setPassword(pw);
			
			return member;
		}
		
		@Override
		public String toString() {
			return "MemberEditRequest [idx=" + idx + ", userid=" + Userid + ", pw=" + pw + ", username=" + username
					+ ", oldPhoto=" + oldPhoto + ", userPhoto=" + userPhoto + "]";
		}
		
		
		
		
		
		
}
