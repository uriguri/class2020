package member;

public class Member {

	// 회원 정보를 저장하는 beans 클래스 정의
	
	// 변수는 private
	private String userId;
	private String paassword;
	private String userName;
	private String userPhoto;
	
	// 기본 생성자 필수 
	public Member() {}

	public Member(String userId, 
				  String paassword, 
				  String userName, 
				  String userPhoto) {
		this.userId = userId;
		this.paassword = paassword;
		this.userName = userName;
		this.userPhoto = userPhoto;
	}

	// Getter & Setter
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPaassword() {
		return paassword;
	}

	public void setPaassword(String paassword) {
		this.paassword = paassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", paassword=" + paassword + ", userName=" + userName + ", userPhoto="
				+ userPhoto + "]";
	}
	
	
	
}
