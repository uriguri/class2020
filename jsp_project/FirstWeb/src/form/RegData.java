package form;

public class RegData {

	//변수
	private String userid;
	private String pw;
	private String username;
	private String userPhoto;
	
	//생성자
	public RegData() {
		
	}
	
	public RegData(String userid, String pw, String username, String userPhoto) {
		super();
		this.userid = userid;
		this.pw = pw;
		this.username = username;
		this.userPhoto = userPhoto;
	}

	//게터세터
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

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	
	//투스트링
	@Override
	public String toString() {
		return "RegData [userid=" + userid + ", pw=" + pw + ", username=" + username + ", userPhoto=" + userPhoto + "]";
	}
	
	
}
