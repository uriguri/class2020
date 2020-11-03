package ver04solo;

public class PhoneInfor {

	// 변수
	private String name;
	private String phoneNumber;
	private String address;
	private String email;
	
	// 변수 캡슐화 했기 때문에 getter 사용
	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}
	
	// 생성자 
		PhoneInfor(String name, String phoneNumber, String address, String email) {
			this.name = name;
			this.phoneNumber = phoneNumber;
			this.address = address;
			this.email = email;
		}
	
	// 출력메서드
	void showPhoneInfor() {
		System.out.println("• 이     름  : " + getName());
		System.out.println("• 전화번호  : " + getPhoneNumber());
		System.out.println("• 주     소  : " + getAddress());
		System.out.println("• 이 메 일  : " + getEmail() );
	}

	
	
	
		
	
		
	
		

}
