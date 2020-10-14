package ver02;

import java.util.Scanner;

public class PhoneBookMain {
/*
	Project : ver 0.20

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
	public static void main(String[] args) {
		
		// 사용자에게 데이터를 받는다.
		Scanner s = new Scanner(System.in);
		
		
		while(true) {
			
		// 인스턴스 생성을 위해서는 이름, 전화번호, 생일 데이터를 받는다.
		System.out.println("저장을 위한 데이터를 입력해주세요");
		System.out.println("이름을 입력해주세요");
		String name = s.nextLine();
		System.out.println("전화번호를 입력해주세요");
		String phoneNumber = s.nextLine();
		System.out.println("생일을 입력해주세요");
		String birthday = s.nextLine();	 // " ";
		
		// 인스턴스 생성
		PhoneInfor infor = null; 
				
		//trim() -> "    123    " .trim() -> "123"
		
		// 입력값 없이 enter인 경우 공백 문자열을 반환
		// 문자열의 길이가 0이면 
		//if(birthday.length()==0) {  // "    ".trim() -> ""
		
		if(birthday.trim().isEmpty()) {  // or // length() == 0 => true
			infor = new PhoneInfor(name, phoneNumber, null);			
		} else {
			infor = new PhoneInfor(name, phoneNumber, birthday);
		}
	
		
		// 메서드 호출
		infor.showInfor();
		
		}
	}

}
