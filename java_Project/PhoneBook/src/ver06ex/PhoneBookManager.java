package ver06ex;

import ver03.Util;

public class PhoneBookManager { 
	
	// 전화번호 정보를 저장 할 배열을 가지고,
	// 배열을 이용한 정보의 저장, 삭제, 출력을 하는 기능
	
	// 배열 선언 : 상속 관계이기 때문에 PhoneInfor 타입으로 선언
	private PhoneInfor[] pBook; 	// 전화번호 정보를 저장 할 배열
	private int cnt; 				// 배열에 저장된 요소의 개수, 배열의 index
	
	// 생성자 : 싱글톤 처리 -> 외부에서 인스턴스 생성을 금지.
	private PhoneBookManager(int num) {
		pBook = new PhoneInfor[num];	// 생성자의 매개변수 인자를 전달 받아 배열 생성
		cnt = 0;
	}
	
	// 내부에서 인스턴스 생성
	private static PhoneBookManager manager = new PhoneBookManager(100);
	
	// 외부에서 참조변수를 받을 수 있는 메서드
	public static PhoneBookManager getInstance() {
		return manager;
	}
	
	// 정보 저장
	// 1. 배열에 저장 메서드 "다형성"을 이용해서 하나의 메서도로 정의 addInfor(상위 클래스 타입의 매개변수)
	// 2. 사용자에게 받은 데이터를 인스턴스로 생성 메서드
	//		입력의 구분 -> 구분에 따라 /인스턴스 생성도 구분 -> addInfor()메서드를 이용해서 정보를 저장
	
	// 배열에 전화번호 정보를 저장하는 메서드
	private void addInfor(PhoneInfor infor) {
		pBook[cnt++] = infor;
	}
	
	// 전화번호 정보를 인스턴스 생성하고 배열에 저장
	void insertInfor() {
		
		System.out.println(" 어떤 정보를 입력하시겠습니까? ");
		// System.out.println(" 1. 기본 "); // 추상클래스 -> 인스턴스 생성불가
		System.out.println(Menu.UNIV + ". 대학 ");
		System.out.println(Menu.COM + ". 회사 ");
		System.out.println(Menu.CAFE + ". 동호회 ");
		
		
		int select = Util.sc.nextInt();

		Util.sc.nextLine();
		
		if( !(select>0 && select<5) ) {
			System.out.println("메뉴 선택이 옳바르지 않습니다.");
			System.out.println("초기메뉴로 이동합니다.");
			return;
		}
		
		System.out.println(" 입력을 시작합니다. ");
		System.out.println(" 이름 >> ");
		String name = Util.sc.nextLine();
		System.out.println(" 전화번호 >> ");
		String pNum = Util.sc.nextLine();
		System.out.println(" 주소 >> ");
		String addr = Util.sc.nextLine();
		System.out.println(" 이메일 >> ");
		String email = Util.sc.nextLine();

		switch(select) {
//		case 1 : 
//			// 인스턴스 생성 -> 배열에 저장
//			addInfor(new PhoneInfor(name, pNum, addr, email));
//			break;
//			
		case Menu.UNIV : 
			// 추가 정보 받고 -> 인스턴스 생성 -> 배열에 저장
			// 전공, 학년
			System.out.println(" 전공 >> ");
			String major = Util.sc.nextLine();
			
			System.out.println(" 학년 >> ");
			int grade = Util.sc.nextInt();
			
			addInfor(new UnivPhoneInfor(name, pNum, addr, email, major, grade));
			break;
			
		case Menu.COM : 
			// 추가 정보 받고 -> 인스턴스 생성 -> 배열에 저장
			// 회사이름
			System.out.println(" 회사 이름 >> ");
			String company = Util.sc.nextLine();
			
			addInfor(new CompanyPhoneInfor(name, pNum, addr, email, company));
			break;
			
		case Menu.CAFE : 
			// 추가 정보 받고 -> 인스턴스 생성 -> 배열에 저장
			// 동호회이름, 닉네임
			System.out.println(" 동호회 이름 >> ");
			String cafeName = Util.sc.nextLine();
			
			System.out.println(" 닉네임 >> ");
			String nickName = Util.sc.nextLine();
			
			addInfor(new CafePhoneInfor(name, pNum, addr, email, cafeName, nickName));
			break;
			
		default :
			
		}
		
	}
		
	// 정보 검색
	// 배열의 index를 찾는 메서드
	private int searchIndex(String name) {
		int index = -1; // 정보가 없을 때 
		
		for(int i=0; i<cnt; i++) {
			// 이름으로 비교
			if(pBook[i].getName().equals(name)) {
				index = i;
			}
		}
		return index;
	}

	// 해당 index의 참조변수로 정보 출력 : 사용자가 입력한 이름으로 검색
	public void searchInfor() {

		Util.sc.nextLine();
		System.out.println("검색하실 이름을 입력해주세요.");
		String name = Util.sc.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0) {
			System.out.println("검색하신 이름의 정보가 존재하지 않습니다.");
			System.out.println("메뉴로 돌아갑니다.");
		} else {
			System.out.println("검색 결과 ========================");
			pBook[index].showInfor();
		}
	}
	
	// 사용자에게 이름을 입력받고 이름으로 검색을 한 후 정보를 삭제
	// 삭제되상이 되도록 변경해주는 것 index를 이용하여서.
	public void deleteInfor() {
		
		Util.sc.nextLine();
		
		System.out.println("삭제하고자 하는 정보의 이름을 입력해주세요.");
		String name = Util.sc.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0) {
			System.out.println("찾으시는 이름"+ name +"정보가 존재하지 않습니다.");
			System.out.println("메뉴로 이동합니다.");
		} else {
			// 배열의 요소를 왼쪽으로 시프트(이동시킨다)
			for(int i=index; i<cnt-1; i++) {
				pBook[i] = pBook[i+1];
			}
			cnt--; // 저장된 개수를 감소
			System.out.println("요청하신 이름의 정보를 삭제했습니다.");
		}
		
	}
	
	//전체 정보를 출력하는 메서드
	public void showAllInfor() {
		System.out.println("전체 정보를 출력 합니다. =========================");
		for(int i=0; i<cnt; i++) {
			pBook[i].showInfor();
			System.out.println("---------------------");
		}
	}
	
	
	
	
	
}
