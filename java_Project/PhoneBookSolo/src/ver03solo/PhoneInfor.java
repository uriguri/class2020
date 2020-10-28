package ver03solo;

public class PhoneInfor {
	

	// 변수
	String name;
	String phoneNumber;
	String birthday;
	
	// 생성자 (생일정보 저장O)
	PhoneInfor(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	// 생성자 오버로드 (생일정보 저장X)
	PhoneInfor(String name, String phoneNumber){
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	// 출력메서드
	void showPhoneInfor() {
		System.out.println("========================");
		System.out.println("• 이     름  : " + name);
		System.out.println("• 전화번호  : " + phoneNumber);
		System.out.println("• 생년월일  : " + birthday);
		System.out.println("========================");
	}
	
	
		
	
		
	
		

}
