package exam2;

import java.util.Scanner;

public class PhoneSoloManager {

	//생성될 배열이름 phoneData
	final PhoneSolo[] phoneData;
	int cnt;
	
	//사이즈를 미입력시
	PhoneSoloManager(){
		phoneData = new PhoneSolo[100]; 
	}
	
	//사이즈를 입력시
	PhoneSoloManager(int size) {
		phoneData = new PhoneSolo[size];
	}
	
	// 기능 : 저장, 검색, 삭제
	
	
		// 저장 기능
		// 사용자로부터 데이터를 받아서 ->
	Scanner sc = new Scanner(System.in);
		// 인스턴스를 생성 -> 
	void saveData() {
		
		System.out.println("저장을 실행합니다.");
		System.out.println("=====================");
		//이름
		System.out.println("• 이름   : " );
		String name = sc.nextLine();
		
		//번호
		System.out.println("• 번호   : " );
		String phoneNumber = sc.nextLine();
		
		//생일
		System.out.println("• 생일   : " );
		String birthday = sc.nextLine();
		
		//배열 저장위해 인스턴트 참조변수 선언
		PhoneSolo solo = null;
		
		// 생일이 입력되었는지 여부에 따라 인스턴스 생성을 다르게 처리
		if(birthday != null && birthday.length()>0) {
			solo = new PhoneSolo(name, phoneNumber, birthday);
		} else {
			solo = new PhoneSolo(name, phoneNumber);
		}
		phoneData[cnt++] = solo;
		
	}
		// 배열에 생성된 인스턴스의 참조값을 저장 : 저장 index -> cnt를 이용
		// 저장 후에는 cnt++
		
	// 정보 검색
		// 검색하고자 하는 이름을 사용자로 부터 받고
		// 배열의 요소 (참조 값 -> 인스턴스 참조) 
		// PhoneInfor.name 변수의 값과 검색 이름을 비교(동등 비교)
		// 해당 index를 찾을 수 있다.
		// 검색된 index로 정보 출력 
	

	//index 찾기
	
	int searchIndex(String name) {
		
		int result=-1; //찾고자하는 정보가 없을때 분기해주기위해 -1로 설정
		
	// 검색 : index를 찾는다
		
	for(int i=0; i<cnt; i++) {
		if(phoneData[i].name.equals(name)) {
			result=i;
			break;
		}
	}
		return result;
	}
	
	
	void searchData() {
		
		if(cnt==0) {
			System.out.println("저장된 데이터가 없습니다.");
			return;
		}
		
		System.out.println("정보검색을 시작합니다.");
		System.out.println("검색 할 이름을 입력해주세요.");
		String name = sc.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0) {
			System.out.println("해당되는 데이터가 없습니다.");
		} else {
			phoneData[index].showSolo();
		}
		
		
	}
	
	// 정보 삭제
		// 삭제하고자 하는 이름을 사용자로부터 받는다
		// 배열에서 이름으로 검색해서 index를 찾는다
		// 배열에서 찾은 index의 참조값을 삭제 : 인스턴스는 참조하는 참조변수가 없으면 삭제 된다
		// 참조값에 null을 입력하거나, 다른 주소값을 입력 -> 이전에 있던 참조값은 없어진다.
		// 삭제 대상의 index 부터 왼쪽으로 값을 시프트 처리
		// cnt-1
	
	void deleteData() {
		if(cnt==0) {
			System.out.println("저장된 데이터가 없습니다.");
			return;
		}	
		
			System.out.println("정보삭제를 시작합니다.");
			System.out.println("삭제 할 이름을 입력해주세요.");
			String name = sc.nextLine();
			
		
			int index = searchIndex(name);
			
			if(index<0) {
				System.out.println("해당되는 데이터가 없습니다.");
			} else {
				for(int i=index; i<cnt-1; i++) {
					phoneData[i] = phoneData[i+1];
				}
				cnt--;
				System.out.println("정보를 삭제했습니다.");
			}
	
		}
	
	
	
	
	
	
	
}
