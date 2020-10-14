package ver03;

public class PhoneBookManager {

	// 배열 : 전화번호 정보(이름,전화번호,생일)을 저장하는 목적
	
	final PhoneInfor[] phoneBook; // 정보 저장을 위한 배열 선언
	int cnt; 	// 저장된 정보의 개수 : 반복의 횟수 사용, 배열에 새로운 데이터 입력시 index로 사용
		
	// 초기화 
	PhoneBookManager(){  //공백으로 만들면 100개의 배열을 가지도록함.
		
		//phoneBook = new PhoneInfor[100]; //배열의 저장공간을 100개 생성
		
		this(100);
	}
	
	PhoneBookManager(int size) { //size를 입력하면 size만큼의 배열을 가지도록함.
		phoneBook = new PhoneInfor[size];
	}
	
	
	// 기능 : 저장, 검색, 삭제
	
	
	// 저장 기능
	// 사용자로부터 데이터를 받아서 -> 
	// 인스턴스를 생성 -> 
	// 배열에 생성된 인스턴스의 참조값을 저장 : 저장 index -> cnt를 이용
	// 저장 후에는 cnt++
	
	void insertMember() {
		
		System.out.println("친구의 정보 입력을 시작합니다.");

		// 이름 입력 받기
		System.out.println("이름을 입력해주세요. : ");
		String name = Util.sc.nextLine().trim();
		
		// 전화번호 받기
		System.out.println("전화번호를 입력해주세요 : ");
		String pNum = Util.sc.nextLine().trim();
		
		// 생일 받기
		System.out.println("생일 정보를 입력해주세요 : ");
		String birthday = Util.sc.nextLine().trim();
		
		
		// 배열에 저장하기 위한 인스턴스의 참조변수 선언
		PhoneInfor infor = null;
		
		// 생일이 입력되었는지 여부에 따라 인스턴스 생성을 다르게 처리
		if(birthday != null && birthday.length()>0) {
			infor = new PhoneInfor(name, pNum, birthday);
		} else {
			infor = new PhoneInfor(name, pNum);
		}
		
		phoneBook[cnt++] = infor; //phoneBook[0] = 0x111
		//cnt++;	// 추가된 정보의 개수를 +1
	}
	
	
	// 정보 검색
	// 검색하고자 하는 이름을 사용자로 부터 받고
	// 배열의 요소 (참조 값 -> 인스턴스 참조) 
	// PhoneInfor.name 변수의 값과 검색 이름을 비교(동등 비교)
	// 해당 index를 찾을 수 있다.
	// 검색된 index로 정보 출력 
	void searchMember() {
		
		if(cnt==0) {
			System.out.println("저장된 데이터가 없습니다. 다시 메뉴로 이동합니다.");
			return;
		}
		
		// 찾고자 하는 이름을 받는다.
		System.out.println("정보 검색을 시작합니다.");
		System.out.println("찾고자 하는 이름을 입력해주세요. :");
		String name = Util.sc.nextLine();
		
		// 이름으로 요소 index 검색
		int index = searchIndex(name);
		
		//int index = -1; //찾고자하는 정보가 없을때 분기해주기위해 -1로 설정
		
		// 검색 : index를 찾는다
		//for(int i=0; i<cnt; i++) {
		//	if(phoneBook[i].name.equals(name)) {
		//		index=i;
		//		break;
		//	}
		//}
		
		if(index<0) {
			System.out.println("찾으시는 이름의 정보가 존재하지 않습니다.");
		} else {
			// 찾은 정보 출력
			phoneBook[index].showInfor();
		}
	}
	
	
	
	// 이름 문자열을 받아서 , 
	// 배열의 정보와 비교하고 , 
	// index를 찾아서 반환하는 메서드
	
	int searchIndex(String name) {
		int result=-1; //찾고자하는 정보가 없을때 분기해주기위해 -1로 설정
		
	// 검색 : index를 찾는다
		
	for(int i=0; i<cnt; i++) {
		if(phoneBook[i].name.equals(name)) {
			result=i;
			break;
		}
	}
		return result;
	}
	
	// 정보 삭제
	// 삭제하고자 하는 이름을 사용자로부터 받는다
	// 배열에서 이름으로 검색해서 index를 찾는다
	// 배열에서 찾은 index의 참조값을 삭제 : 인스턴스는 참조하는 참조변수가 없으면 삭제 된다
	// 참조값에 null을 입력하거나, 다른 주소값을 입력 -> 이전에 있던 참조값은 없어진다.
	// 삭제 대상의 index 부터 왼쪽으로 값을 시프트 처리
	// cnt-1
	
	void deleteMember() {
		
		if(cnt==0) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		}
		
		System.out.println("정보 삭제를 진행합니다.");
		System.out.println("삭제 하고자 하는 정보의 이름을 입력해주세요.");
		String name = Util.sc.nextLine();
		
		// 이름으로 요소 index 검색
		int index = searchIndex(name);
		
//		int index = -1; //찾고자하는 정보가 없을때 분기해주기위해 -1로 설정
//		
//		// 검색 : index를 찾는다
//		for(int i=0; i<cnt; i++) {
//			if(phoneBook[i].name.equals(name)) {
//				index=i;
//				break;
//			}
//		}
		
		if(index<0) {
			System.out.println("삭제 하고자 하는 정보가 존재하지 않습니다.");
		} else {
			
			// 삭제 처리 : 삭제해야하는 index 부터 왼쪽으로 시프트 처리
			// index = 3;
			// phoneBook[3] = phoneBook[4]
			// phoneBook[4] = phoneBook[5]
			
			for(int i=index; i<cnt-1; i++) {
				phoneBook[i]=phoneBook[i+1];
			}
			cnt--; //정보 저장개수를 빼주기
			
			System.out.println("정보를 삭제 했습니다.");
		}
		
	}
	
	// 전체 정보 출력
	void displayAll() {
		
		if(cnt==0) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		}
		
		System.out.println("전체 정보를 출력합니다.("+cnt+")");
		System.out.println("-----------------");
		for(int i=0; i<cnt; i++) {
			phoneBook[i].showInfor();
			System.out.println("-----------------");
		}
	}
	
	
}
//"cnt" 는 저장 삭제가 아니면 변하지않음 그래서 정보의 수량을 표시해줌. 
// 매 코드들 앞에 if(cnt==0){
//				System.out.println("등록된 정보가 없습니다.")
//              return;
//           }  으로 표시함. 