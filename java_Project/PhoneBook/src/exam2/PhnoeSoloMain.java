package exam2;

import java.util.Scanner;

import ver03.Util;

public class PhnoeSoloMain {

	public static void main(String[] args) {
		
	PhoneSoloManager manager = new PhoneSoloManager();
	
	Scanner sc = new Scanner(System.in);
	
	
	while(true) {
		

		System.out.println("전화번호 관리 프로그램=========");
		System.out.println("메뉴를 입력하세요");
		System.out.println(" 1. 정보 저장");
		System.out.println(" 2. 정보 검색");
		System.out.println(" 3. 정보 삭제");
		System.out.println(" 4. 프로그램 종료");
		System.out.println("========================");
	
		char menu = sc.nextLine().charAt(0);
		
		switch(menu) {
		case '1' :
			manager.saveData();
			break;
		case '2' :
			manager.searchData();
			break;
		case '3' :
			manager.deleteData();
			break;
		case '4' :
			System.out.println("프로그램 종료 띠로링");
			System.exit(0);
		}
		
		
	}

	
	

		
	
	
	}
}