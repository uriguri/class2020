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

public class PhoneBookMain {

	public static void main(String[] args) {
		
		// 생년월일 정보 포함 PhoneInfor
		PhoneInfor pi1 = new PhoneInfor("우리", "010-123-4567", "1992-02-07");
		// 출력 메서드 사용
		pi1.showPhoneInfor();
		
		// 생년월일 정보 X PhoneInfor
		PhoneInfor pi2 = new PhoneInfor("창수", "010-987-6543");
		pi2.showPhoneInfor();

	}

}

/*
 결과
========================
• 이     름  : 우리
• 전화번호  : 010-123-4567
• 생년월일  : 1992-02-07
========================
========================
• 이     름  : 창수
• 전화번호  : 010-987-6543
• 생년월일  : null
========================
*/