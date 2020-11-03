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
		
		//PhoneBookManager 인스턴스 생성 : 배열과 메서드사용 ver0.3
		//PhoneBookManager에 아무것도 입력X 일시 [100]배열 생성됌ver0.3
		PhoneBookManager manager = new PhoneBookManager();
		
		System.out.println("저장된 정보의 개수 : " + manager.cnt);
		System.out.println("저장이 가능한 공간의 개수 : " + manager.phoneBook.length);
		
		// 입력 받기위한 스캐너 ver0.2
		Scanner sc = new Scanner(System.in);
		
		//메뉴 만들기
		while(true) {
			
			System.out.println("전화번호 관리 프로그램");
			System.out.println("메뉴를 입력하세요");
			System.out.println("1.정보 저장");
			System.out.println("2.정보 검색");
			System.out.println("3.정보 삭제");
			System.out.println("4.정보 전체보기");
			System.out.println("5.프로그램 종료");
			
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				manager.addPhoneBook();
				break;
			case 2:
				manager.searchPhoneBook();
				break;
			case 3:
				manager.deletePhoneBook();
				break;
			case 4:
				manager.showAll();
				break;
			case 5:
				System.out.println("프로그램 종료합니다");
				System.exit(0);
				break;
				
			}
		}
	}

}

