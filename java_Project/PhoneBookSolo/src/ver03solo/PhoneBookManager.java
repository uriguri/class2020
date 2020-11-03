package ver03solo;

import java.util.Scanner;

public class PhoneBookManager {

	// PhoneInfor 타입의 (이름, 전화번호, 생년월일) 배열[] : phoneBook 생성.
	PhoneInfor[] phoneBook;
	
	// 배열의 index를 관리해줄 변수 
	int cnt;
	
	// 초기화
	
	// 공백으로 생성 시 100개의 배열 생성
	PhoneBookManager() {
		phoneBook = new PhoneInfor[100]; 
	}
	
	// size를 입력할 시 size개의 배열 생성 
	PhoneBookManager(int size) {
		phoneBook = new PhoneInfor[size];
	}
	
	// 기능 : 저장, 검색, 삭제
	// 기능 = 메서드를 만드는 것.
	
	// 저장 기능
	
	// 1: 사용자로부터 데이터를 받아서 
	// 2: 인스턴스를 생성 
	// 3: 배열에 생성된 인스턴스의 참조값을 저장 : 저장 index -> cnt를 이용
	// 4: 저장 후에는 cnt++ 하여서 새로운 index를 갖도록 함.
	
	// 1 :사용자로부터 데이터를 받아서 
	Scanner sc = new Scanner(System.in);
	
	void addPhoneBook() {
		System.out.println("*****정보저장을 실행합니다.*****");
		System.out.println("이름을 입력해주세요  \n >>");
		String name = sc.nextLine();
		System.out.println("전화번호를 입력해주세요  \n >>");
		String phoneNumber = sc.nextLine();
		System.out.println("생년월일을 입력해주세요  \n >>");
		String birthday = sc.nextLine();
		
		// 2 :인스턴스를 생성
		PhoneInfor infor;
		
		// 생년월일 입력 여부에 따라 인스턴스를 다르게 생성
		if(birthday.trim().isEmpty()) {
			infor = new PhoneInfor(name, phoneNumber);
		} else {
			infor = new PhoneInfor(name, phoneNumber, birthday);
		}
		
		// 3: 배열에 생성된 인스턴스의 참조값을 저장 : 저장 index -> cnt를 이용
		// phoneBook[cnt] : phoneBook배열의 [cnt] index에 = infor를 저장해줌.
		phoneBook[cnt] = infor;

		// 4: 저장 후에는 cnt++ 하여서 새로운 index를 갖도록 함.
		// cnt++을 하지 않으면 계속 phoneBook[0]에 덮어씌워짐.
		cnt++;
	}
	
	// 검색 기능
	
	// 1: 검색하고자 하는 이름을 사용자로 부터 받고
	// 2: 배열의 요소 (참조 값 -> 인스턴스 참조) 
	// 3: PhoneInfor.name 변수의 값과 검색 이름을 비교(동등 비교)
	// 	   해당 index를 찾을 수 있다.
	// 4: 검색된 index로 정보 출력 
	
	// 1: 검색하고자 하는 이름을 사용자로 부터 받고 (위에 선언된 sc를 사용함)
	
	void searchPhoneBook() {

		// + 아예 저장된 정보가 없다면 다시 돌려보내기 위해 조건설정
		if(cnt==0) {
			System.out.println("저장된 정보가 없습니다. 메인메뉴로 돌아갑니다.");
			return;
		}
		
		// + 저장된 정보가 있다면 정상적으로 진행 
		System.out.println("*****정보검색을 시작합니다.*****");
		System.out.println("검색하실 이름을 입력해주세요.  \n >>");
		String name = sc.nextLine();
		
		// 2:3: 배열의 요소 (참조 값 -> 인스턴스 참조) PhoneInfor.name 변수의 값과 
		//		검색 이름을 비교(동등 비교)해당 index를 찾을 수 있다.
		
		// 해당하는(이름이 같은) index가 없을 경우 분기를 주기위해 -1로설정
		
		// 배열index에는 음수가 없다.
		
		int index = -1; 
		
		// 찾는 index는 현재 저장된 정보(cnt) 보다 작다 (i<cnt;)
		for(int i=0; i<cnt; i++) {
			// 만약 phoneBook[i]번째의 .이름이.입력받은이름과같다면))
			if(phoneBook[i].name.equals(name)) {
				//index는 찾아낸 이름이 같은  i인덱스를 가진다
				index = i;
				break;
			}
		}
		
		// 4: 찾아낸  index로 저장되어있는 정보 출력
		//    검색후 index가 여전히 -1이라면 해당하는 정보가 없는 것이기 때문에 
		//    찾는 정보가 없음을 출력해줌. 아니라면 찾아낸 index를 호출
		
		if(index<0) {
			System.out.println("찾으시는 정보가 존재하지 않습니다.");
		} else {
			phoneBook[index].showPhoneInfor();
		}
		
	}
	
	// 삭제 기능
	
	// 1: 삭제하고자 하는 이름을 사용자로부터 받는다
	// 2: 배열에서 이름으로 검색해서 index를 찾는다
	// 3: 배열에서 찾은 index의 참조값을 삭제 : 인스턴스는 참조하는 참조변수가 없으면 삭제 된다
	// 4: 참조값에 null을 입력하거나, 다른 주소값을 입력 -> 이전에 있던 참조값은 없어진다.
	// 5: 삭제 대상의 index 부터 왼쪽으로 값을 시프트 처리
	// 6: 정보가 삭제되었기 때문에 index 값인  cnt를 -1	
	
	void deletePhoneBook() {
		
		// + 아예 저장된 정보가 없다면 다시 돌려보내기 위해 조건설정
		if(cnt==0) {
			System.out.println("저장된 정보가 없습니다. 메인메뉴로 돌아갑니다.");
			return;
		}
		
		// + 저장된 정보가 있다면 정상적으로 진행 
		System.out.println("*****정보삭제를 시작합니다.*****");
		System.out.println("삭제하실 이름을 입력해주세요.  \n >>");
		String name = sc.nextLine();
			
		// 해당하는(이름이 같은) index가 없을 경우 분기를 주기위해 -1로설정
		
		// 배열index에는 음수가 없다.
		
		int index = -1;
		
		// 찾는 index는 현재 저장된 정보(cnt) 보다 작다 (i<cnt;)
		for(int i=0; i<cnt; i++) {
			// 만약 phoneBook[i]번째의 .이름이.입력받은이름과같다면))
			if(phoneBook[i].name.equals(name)) {
				//index는 찾아낸 이름이 같은  i인덱스를 가진다
				index = i;
				break;
			}
		}
			
		if(index<0) {
			System.out.println("삭제 할 데이터가 존재하지 않습니다.");
		} else {
			for(int i=index; i<cnt-1; i++) {
				phoneBook[i]=phoneBook[i+1];
			}
			cnt--;
			System.out.println("정보를 삭제 했습니다.");
		}
		
	}
	
	void showAll() {
		
		if(cnt==0) {
			System.out.println("저장된 정보가 없습니다.");
			return;
		}
		
		System.out.println("전체 정보를 출력합니다." + cnt +"개");
		System.out.println("=====================");
		for(int i=0; i<cnt; i++) {
			phoneBook[i].showPhoneInfor();
			System.out.println("=====================");
		}
	}
	
}

/*
 	// 이름 문자열을 받아서 배열의 정보와 비교하고 index를 찾아서 반환하는 메서드
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
*/ 
 
