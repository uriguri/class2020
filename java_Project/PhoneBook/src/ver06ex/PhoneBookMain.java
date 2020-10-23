package ver06ex;

import java.util.InputMismatchException;

//	0.6ver 추가내용
//		ArrayList<T>를 사용해 배열을 저장
//		사용자 메뉴 입력시 예외처리를 해봅시다.

import ver03.Util;
import ver05.Menu;
import ver05.PhoneBookManager;

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
			
			int select = 0; // try-catch 사용을 위해 새로 초기화 
			
		try {
			select = Util.sc.nextInt();
			
			// 메뉴 번호외 숫자를 입력했을때 예외처리
			if(!(select>0 && select<6)) {
				System.out.println("메뉴의 선택이 옳바르지 않습니다. \n다시 선택해주세요.");
				continue;
			}
		} catch (InputMismatchException e) { // 문자 입력시 나오는 에러를 캐치.
			System.out.println("숫자를 입력해주세요!!! \n >>다시 선택해주세요.");
			Util.sc.nextLine(); // 공백으로 들어와서 무한루프 도는걸 막아줌.
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
				manager.deleteInfor();
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