package ver04solo;

import java.util.Scanner;

/*
		전화번호 관리 프로그램 | Version 0.4 | 복습 2020 - 11 - 03일 
		다음 두 클래스를 추가로 삽입. 상속 구조가 가능하다면 상속 구조로 구성 해보세요. 
		PhoneUnivInfor, PhoneCompaanyInfor, 개인적인 클래스 추가 
		각 클래스에 정의되어야 하는 인스턴스 변수. 
				
	PhoneUnivInfor 					PhoneCompaanyInfor 
	이름        name        String 		이름        name         String 
	전화번호   phoneNumber String  		전화번호   phoneNumber  String
	주소        address     String  		주소         address     String
	이메일     email       String  		이메일      email        String  
	----------------------------------------------------------
 	전공       major       String		회사        company      String  
 	학년       year        String 
 
	Ex) PhoneCafeInfor 또는 PhoneFamilyInfor 등을 추가해 보자 
	
	[추가 사항]
	1. 입력    --> 1. 일반  2. 대학  3. 회사  4. 동호회 --> 입력 형태로 구성
	
*/

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneBookManager phoneArr = new PhoneBookManager(100);

		Scanner sc = new Scanner(System.in);
		
		//메뉴 만들기
		while(true) {
			System.out.println("============메뉴 선택============");
			System.out.println(" 1. 데이터 저장 ");
			System.out.println(" 2. 저장된 데이터 확인");
			System.out.println(" 3. 프로그램 종료");
			
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				System.out.println(" ========저장 할 정보의 종류를 선택해주세요 ======");
				System.out.println(" 1. 일반 정보로 저장  ");
				System.out.println(" 2. 대학 정보 함께 입력 ");
				System.out.println(" 3. 회사 정보 함께 입력 ");
				System.out.println(" 4. 동호회 정보 함께 입력 ");
				
				int inforSelect = sc.nextInt();
				phoneArr.addAllInfor(inforSelect);
				
				break;
			case 2:
				phoneArr.showAllInfor();
				break;
			case 3:
				System.out.println("프로그램 종료합니다");
				System.exit(0);
				break;
				
			}
		}
	}

}

