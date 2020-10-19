package ver04;

import java.util.Scanner;

public class PhoneInforMain {

	public static void main(String[] args) {
		
		//저장 배열 생성
		PhoneInforManager phoneArr = new PhoneInforManager(10);
		
		Scanner sc = new Scanner(System.in);
		
		// 프로그램 동작을 위한 무한루프
		while(true) {
			System.out.println("============메뉴 선택============");
			System.out.println(" 1. 데이터 저장 ");
			System.out.println(" 2. 저장된 데이터 확인");
			System.out.println(" 3. 프로그램 종료");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1 : 
				System.out.println(" ========저장 할 정보의 종류를 선택해주세요 ======");
				System.out.println(" 1. 일반 정보로 저장  ");
				System.out.println(" 2. 대학 정보 함께 입력 ");
				System.out.println(" 3. 회사 정보 함께 입력 ");
				System.out.println(" 4. 동호회 정보 함께 입력 ");
				int inforChoice = sc.nextInt();
				phoneArr.addAllInfor(inforChoice);
				break;
				
			case 2 : phoneArr.showAllInfor();
				break;
				
			case 3 : System.out.println("프로그램을 종료합니다."); 
				return;
			}
		}
	}
}
