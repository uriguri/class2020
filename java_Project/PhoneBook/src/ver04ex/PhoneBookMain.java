package ver04ex;

import ver03.Util;

public class PhoneBookMain {

	public static void main(String[] args) {
	
		PhoneBookManager manager = new PhoneBookManager(100);
		
		while(true) {
			System.out.println("메뉴를 입력해주세요. ==================");
			System.out.println(" 1. 저장 ");
			System.out.println(" 2. 검색 ");
			System.out.println(" 3. 삭제 ");
			System.out.println(" 4. 모든 정보 출력 ");
			System.out.println(" 5. EXIT ");
			
			System.out.println("\n>> ");
			
			int select = Util.sc.nextInt();
			
			// 메뉴 번호외 숫자를 입력했을때 예외처리
			if(!(select>0 && select<6)) {
				System.out.println("메뉴의 선택이 옳바르지 않습니다. \n다시 선택해주세요.");
				continue;
			}
			
			switch (select) {
			case 1:
				manager.insertInfor();
				break;
				
			case 2:
				manager.searchInfor();
				break;
				
			case 3:
				
				break;
				
			case 4:
				manager.showAllInfor();
				break;
				
			case 5:
				System.out.println("프로그램을 종료합니다. 띠리링~");
				return;
			}
			
		}

		
		
		
	}

}
