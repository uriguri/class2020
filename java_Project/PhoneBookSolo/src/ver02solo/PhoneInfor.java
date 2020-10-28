package ver02solo;

/*
			전화번호 관리 프로그램 | Version 0.2 | 복습 2020 - 10 - 28일 
						"프로그램 사용자로부터 데이터 입력"
			프로그램 사용자로부터 데이터를 입력 받아 클래스의 인스턴스를 생성하는 것이 핵심.
			단 반복문을 이용해서 프로그램의 흐름을 계속 유지하도록 한다.
			프로그램 종료를 하지 않으면, 다음과 같은 과정이 반복적으로 이루어짐.
			
						키보드로부터 데이터 입력 
								↓
						입력 받은 데이터로 인스턴스 생성
								↓
						생성된 인스턴스의 메소드 호출
		
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
