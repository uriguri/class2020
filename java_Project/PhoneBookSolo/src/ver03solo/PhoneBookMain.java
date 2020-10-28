package ver03solo;

import java.util.Scanner;

/*
		전화번호 관리 프로그램 | Version 0.3 | 복습 2020 - 10 - 28일 
		배열을 이용해서 프로그램 사용자가 입력하는 정보가 최대 100개까지 유지되도록 프로그램을 변경. 
		
								아래기능 삽입
		저장 : 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장
		검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
		삭제 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 삭제
		
		데이터 삭제 후 남아있는 데이터 처리는 데이터를 빈 공란이 없이 순차적으로 재정리 
		2번이 삭제되었다면 3번 이후 데이터들의 주소 값이 -1 처리되어 재저장.

*/
public class PhoneBookMain {

	public static void main(String[] args) {
		
		// 입력 받기위한 스캐너 ver0.2
		Scanner sc = new Scanner(System.in);
		
		// 반복문을 이용한 프로그램 흐름 유지 ver0.2
		while(true) {
			
			System.out.println("전화번호부 저장을 시작합니다.");
			System.out.println("이름을 입력해주세요 \n >>");
			String name = sc.nextLine();
			System.out.println("전화번호를 입력해주세요 \n >>");
			String phoneNumber = sc.nextLine();
			System.out.println("생년월일을 입력해주세요 \n >>");
			String birthday = sc.nextLine();
			
			// 인스턴스를 생성한다.ver0.2
			PhoneInfor infor;
			
			// 생년월일입력 여부에 따라 만들어질 infor 조건문으로 설정 ver0.2
			
			//	공백 입력을 걸러내는 다양한 방법.
			//	trim()의 사용법  : "    123    " + .trim() = "123"
			//	isEmpty() : 공백일때
			//	length()==0 : 문자열(길이) 없을때(0일때)
			
				//.trim()로 공백문자 " "를 입력한경우 ""로 변경
				//.isEmpty() ""처럼 아무것도 입력하지 않은경우  -> null
			
			if(birthday.trim().isEmpty()) {
				infor = new PhoneInfor(name, phoneNumber);
			} else {
				infor = new PhoneInfor(name, phoneNumber, birthday);
			}
			
			// 인스턴스의 메서드 호출
			infor.showPhoneInfor();
			
		}
	}

}

/*
 결과 

// 변수 부분을 사용자로 부터 입력받음.

전화번호부 저장을 시작합니다.

이름을 입력해주세요 
 >>
우리

전화번호를 입력해주세요 
 >>
010-123-4567

생년월일을 입력해주세요 
 >>
1992-02-07

// 입력받은 내용이 showPhoneInfor에 담겨 출력
 
========================
• 이     름  : 우리
• 전화번호  : 010-123-4567
• 생년월일  : 1992-02-07
========================

// while(true)로 반복 
 
전화번호부 저장을 시작합니다.
이름을 입력해주세요 
 >>

 */
