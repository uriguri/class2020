package ver01solo;

/*
	전화번호 관리 프로그램 | Version 0.1 | 복습 2020 - 10 - 28일 
	PhoneInfor 라는 이름의 클래스를 정의해 보자. 
	클래스는 다음의 데이터들의 문자열 형태로 저장이 가능 해야 하며, 
	저장된 데이터의 적절한 출력이 가능하도록 메소드 정의
	• 이름            name           String
	• 전화번호       phoneNumber    String
	• 생년월일       birthday       String 
	단, 생년월일 정보는 저장할 수도 있고, 저장 않을 수도 있게끔 생성자 생성.
	
*/

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
