package ver06;

import java.util.InputMismatchException;

import ver03.Util;

public class PhoneBookMain {

	public static void main(String[] args) {
	
		//PhoneBookManager manager = new PhoneBookManager(100);
		
		PhoneBookManager manager = PhoneBookManager.getInstance();
		
		
while(true) {
			System.out.println("메뉴를 입력해주세요. ==================");
			System.out.println(Menu.INSERT + ". 저장 ");
			System.out.println(Menu.SEARCH + ". 검색 ");
			System.out.println(Menu.DELETE + ". 삭제 ");
			System.out.println(Menu.DISPLAY_ALL + ". 모든 정보 출력 ");
			System.out.println(Menu.EXIT + ". EXIT ");
			
			System.out.println("\n>> ");
			
			int select = Util.sc.nextInt();
		
			// 메뉴 번호외 숫자를 입력했을때 예외처리
			if(!(select>0 && select<6)) {
			System.out.println("메뉴의 선택이 옳바르지 않습니다. \n다시 선택해주세요.");
			continue;
			}
				
			switch (select) {
			
			
			case Menu.INSERT:
				manager.insertInfor();
				break;
				
			case Menu.SEARCH:
				manager.searchInfor();
				break;
				
			case Menu.DELETE:
				break;
				
			case Menu.DISPLAY_ALL:
				manager.showAllInfor();
				break;
				
			case Menu.EXIT:
				System.out.println("프로그램을 종료합니다. 띠리링~");
				return;
			}
			
}	
		




	}
}