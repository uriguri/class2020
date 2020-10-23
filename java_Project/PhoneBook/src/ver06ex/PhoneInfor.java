package ver06ex;

public abstract class PhoneInfor implements Infor {
	
	// 친구의 이름 , 전화번호 , 주소 , 이메일
	// 캡슐화 : 정보은닉 ( 변수의 직접 접근을 제한 - 변수를 보호 )
	private String name;		// 이름
	private String phoneNum;    // 전화번호
	private String addr;		// 주소
	private String email;		// 이메일
	
	// 기본 생성자 생성
	public PhoneInfor(String name, String phoneNum, String addr, 
					  String email) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.addr = addr;
		this.email = email;
	}


	// getter/setter 메서드
	// getter - 값을 읽어올때
	// setter - 값을 설정할때 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// 정보 출력 기능 : 하위 클래스에서 오버라이딩 하는 목적
	
	@Override
	public void showInfor() {
		System.out.println("이름 : " + getName());
		System.out.println("전화 : " + getPhoneNum());
		System.out.println("주소 : " + getAddr());
		System.out.println("이메일 : " + getEmail());
	}
	
	// 추상메서드 showBasicInfor() 멤버로 가진다.
	@Override
	public void showBasicInfor() {
		System.out.println("이름 : " + getName());
		System.out.println("전화 : " + getPhoneNum());
	}
	
}
