package form;

public class LoginData {
	
	//변수
	private String userid;
	private String pw;
	
	//기본생성자
	public LoginData() {
		
	}

	public LoginData(String userid, String pw) {
		super();
		this.userid = userid;
		this.pw = pw;
	}

	//게터와 세터
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
	
	//투스트링
	@Override
	public String toString() {
		return "LoginData [userid=" + userid + ", pw=" + pw + "]";
	}
	

}
